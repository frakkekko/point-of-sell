package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptRequestDTO;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.ReceiptMapper;
import ws.peoplefirst.point_of_sell.model.*;
import ws.peoplefirst.point_of_sell.repository.BarCodeRepository;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;
import ws.peoplefirst.point_of_sell.repository.StockRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
        return receiptRepository.findAll().stream().map(receipt -> ReceiptMapper.toResponseDTO(receipt)).toList();
    }

    public ReceiptResponseDTO getById(UUID id) {
        return ReceiptMapper.toResponseDTO(receiptRepository.getReferenceById(id));
    }

    public ReceiptResponseDTO createNewReceipt(ReceiptRequestDTO receiptRequestDTO) {

        Receipt receipt = new Receipt();
        List<SelledProduct> selledProducts = getSelledProductsFromReceiptRequestDTO(receiptRequestDTO, receipt);

        updateStock(selledProducts);

        receipt.setSelledProducts(selledProducts);
        receipt.setDate(receiptRequestDTO.getDate());
        receipt.setTotal(calcReceiptTotal(selledProducts));

        Receipt receiptSaved = receiptRepository.save(receipt);

        return ReceiptMapper.toResponseDTO(receiptSaved);
    }

    // --------------------------------------------------------------

    private List<SelledProduct> getSelledProductsFromReceiptRequestDTO(ReceiptRequestDTO receiptRequestDTO, Receipt receipt) {
        return receiptRequestDTO.getBarcodes().stream().map(barcodeMap -> {
            UUID barcodeId = UUID.fromString(barcodeMap.get("id"));
            Integer quantity = Integer.valueOf(barcodeMap.get("quantity"));

            BarCode barcode = barCodeRepository.getReferenceById(barcodeId);
            Price price = barcode.getPrices().stream()
                    .filter(currentPrice ->
                            LocalDate.now().isAfter(currentPrice.getDateStartValidity()) && LocalDate.now().isBefore(currentPrice.getDateEndValidity()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Price not found"));

            return new SelledProduct(receipt, barcode, quantity, price.getAmount());
        }).toList();
    }

    private void updateStock(List<SelledProduct> selledProducts) {
        selledProducts.stream().forEach(selledProduct -> {
            Stock productStock = stockRepository.findByProductId(selledProduct.getBarCode().getProduct().getId());
            Integer newQuantity = productStock.getQuantity() - selledProduct.getQuantity();

            if(newQuantity < 0) throw new RuntimeException("Products not available in magazine");

            productStock.setQuantity(productStock.getQuantity() - selledProduct.getQuantity());
            stockRepository.save(productStock);
        });
    }

    private Double calcReceiptTotal(List<SelledProduct> selledProducts) {
        return selledProducts.stream()
                .map(selledProduct -> selledProduct.getTotal())
                .reduce(0.0, Double::sum);
    }
}
