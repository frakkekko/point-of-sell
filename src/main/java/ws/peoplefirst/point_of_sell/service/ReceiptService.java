package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.receipt.ReceiptRequestDTO;
import ws.peoplefirst.point_of_sell.dto.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.exception.custom.PriceNotFoundException;
import ws.peoplefirst.point_of_sell.exception.custom.ProductNotAvailableInMagazineException;
import ws.peoplefirst.point_of_sell.mapper.ReceiptMapper;
import ws.peoplefirst.point_of_sell.model.*;
import ws.peoplefirst.point_of_sell.repository.BarCodeRepository;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;
import ws.peoplefirst.point_of_sell.repository.StockRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final BarCodeRepository barCodeRepository;
    private final StockRepository stockRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository, BarCodeRepository barCodeRepository, StockRepository stockRepository) {
        this.receiptRepository = receiptRepository;
        this.barCodeRepository = barCodeRepository;
        this.stockRepository = stockRepository;
    }

    public List<ReceiptResponseDTO> getAll() {
        return receiptRepository.findAll().stream().map(ReceiptMapper::toResponseDTO).toList();
    }

    public ReceiptResponseDTO getById(UUID id) {
        return ReceiptMapper.toResponseDTO(receiptRepository.getReferenceById(id));
    }

    public ReceiptResponseDTO createNewReceipt(ReceiptRequestDTO receiptRequestDTO) {

        Receipt receipt = new Receipt();
        ReceiptRequestDTO normalizedReceiptRequestDTO = normalizeReceiptRequestDTO(receiptRequestDTO);

        List<SoldProduct> soldProducts = getSoldProductsFromReceiptRequestDTO(normalizedReceiptRequestDTO, receipt);

        updateStock(soldProducts);

        receipt.setSoldProducts(soldProducts);
        receipt.setDate(normalizedReceiptRequestDTO.getDate());
        receipt.setTotal(calcReceiptTotal(soldProducts));

        Receipt receiptSaved = receiptRepository.save(receipt);

        return ReceiptMapper.toResponseDTO(receiptSaved);
    }

    // --------------------------------------------------------------

    private List<SoldProduct> getSoldProductsFromReceiptRequestDTO(ReceiptRequestDTO receiptRequestDTO, Receipt receipt) {
        return receiptRequestDTO.getBarcodes().stream().map(barcodeMap -> {
            UUID barcodeId = UUID.fromString(barcodeMap.get("id"));
            Integer quantity = Integer.valueOf(barcodeMap.get("quantity"));

            BarCode barcode = barCodeRepository.getReferenceById(barcodeId);
            Price price = barcode.getPrices().stream()
                    .filter(currentPrice ->
                            LocalDate.now().isAfter(currentPrice.getDateStartValidity()) && LocalDate.now().isBefore(currentPrice.getDateEndValidity()))
                    .findFirst()
                    .orElseThrow(() -> new PriceNotFoundException(barcodeId));

            return new SoldProduct(receipt, barcode, quantity, price.getAmount());
        }).toList();
    }

    private void updateStock(List<SoldProduct> soldProducts) {
        soldProducts.forEach(soldProduct -> {
            Stock productStock = stockRepository.findByProductId(soldProduct.getBarCode().getProduct().getId());

            int newQuantity = productStock.getQuantity() - soldProduct.getQuantity();

            if(newQuantity < 0) {
                throw new ProductNotAvailableInMagazineException(
                        soldProduct.getBarCode().getProduct().getId(),
                        productStock.getQuantity(),
                        soldProduct.getQuantity()
                );
            }

            productStock.setQuantity(productStock.getQuantity() - soldProduct.getQuantity());
            stockRepository.save(productStock);
        });
    }

    private Double calcReceiptTotal(List<SoldProduct> soldProducts) {
        return soldProducts.stream()
                .map(soldProduct -> soldProduct.getTotal())
                .reduce(0.0, Double::sum);
    }

    private ReceiptRequestDTO normalizeReceiptRequestDTO(ReceiptRequestDTO receiptRequestDTO) {
        List<Map<String, String>> normalizedBarcodes = new ArrayList<>();

        receiptRequestDTO.getBarcodes().forEach(barcodeMap -> {
            Optional<Map<String, String>> barCodeFound = normalizedBarcodes.stream()
                    .filter(barcodeMapItem -> barcodeMapItem.get("id").equals( barcodeMap.get("id")))
                    .findFirst();

            if(barCodeFound.isEmpty()) {
                normalizedBarcodes.addLast(barcodeMap);
            } else {
                barCodeFound.get().merge("quantity", barcodeMap.get("quantity"), (currValue, newValue) -> String.valueOf(Integer.parseInt(currValue) + Integer.parseInt(newValue)));
            }
        });

        return new ReceiptRequestDTO(receiptRequestDTO.getDate(), normalizedBarcodes);
    }
}
