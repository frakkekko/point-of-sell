package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptRequestDTO;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.ReceiptMapper;
import ws.peoplefirst.point_of_sell.model.BarCode;
import ws.peoplefirst.point_of_sell.model.Price;
import ws.peoplefirst.point_of_sell.model.Receipt;
import ws.peoplefirst.point_of_sell.model.SelledProduct;
import ws.peoplefirst.point_of_sell.repository.BarCodeRepository;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final BarCodeRepository barCodeRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository, BarCodeRepository barCodeRepository) {
        this.receiptRepository = receiptRepository;
        this.barCodeRepository = barCodeRepository;
    }

    public List<ReceiptResponseDTO> getAll() {
        return receiptRepository.findAll().stream().map(receipt -> ReceiptMapper.toResponseDTO(receipt)).toList();
    }

    public ReceiptResponseDTO getById(UUID id) {
        return ReceiptMapper.toResponseDTO(receiptRepository.getReferenceById(id));
    }

    public ReceiptResponseDTO createNewReceipt(ReceiptRequestDTO receiptRequestDTO) {
        Receipt receipt = new Receipt();
        List<SelledProduct> selledProducts = receiptRequestDTO.getBarcodes().stream().map(barcodeMap -> {
            UUID barcodeId = UUID.fromString(barcodeMap.get("id"));
            Integer quantity = Integer.valueOf(barcodeMap.get("quantity"));

            BarCode barcode = barCodeRepository.getReferenceById(barcodeId);
            Price price = barcode.getPrices().stream()
                    .filter(currentPrice -> LocalDate.now().isAfter(currentPrice.getDateStartValidity()) && LocalDate.now().isBefore(currentPrice.getDateEndValidity()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Price not found"));

            return new SelledProduct(receipt, barcode, quantity, price.getAmount());
        }).toList();

        Double receiptTotal = selledProducts.stream()
                .map(selledProduct -> selledProduct.getTotal())
                .reduce(0.0, Double::sum);

        receipt.setSelledProducts(selledProducts);
        receipt.setDate(receiptRequestDTO.getDate());
        receipt.setTotal(receiptTotal);

        Receipt receiptSaved = receiptRepository.save(receipt);

        return ReceiptMapper.toResponseDTO(receiptSaved);
    }
}
