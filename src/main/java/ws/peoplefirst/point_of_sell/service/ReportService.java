package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDate.ReportTotalCollectionByDateResponseDTO;
import ws.peoplefirst.point_of_sell.model.Receipt;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    private ReceiptRepository receiptRepository;

    @Autowired
    public ReportService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public ReportTotalCollectionByDateResponseDTO calculateTotalCollectionByDate(LocalDate date) {
        List<Receipt> receiptEmittedForDate = receiptRepository.findAllByDate(date);

        Integer totalProductQuantitySoldForDate = getTotalProductQuantitySoldForDate(receiptEmittedForDate);
        Double totalCollectionForDate = getTotalCollectionForDate(receiptEmittedForDate);

        return new ReportTotalCollectionByDateResponseDTO(totalProductQuantitySoldForDate, totalCollectionForDate);
    }

    // --------------------------------------------------------------------

    private Integer getTotalProductQuantitySoldForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .map(selledProduct -> selledProduct.getQuantity())
                .reduce(0, Integer::sum);
    }

    private Double getTotalCollectionForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .map(receipt -> receipt.getTotal())
                .reduce(0.0, Double::sum);
    }
}
