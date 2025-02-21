package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDate.ReportTotalCollectionByDateResponseDTO;
import ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment.*;
import ws.peoplefirst.point_of_sell.model.Receipt;
import ws.peoplefirst.point_of_sell.model.SoldProduct;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReportService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public ReportTotalCollectionByDateResponseDTO calculateTotalCollectionByDate(LocalDate date) {
        List<Receipt> receiptEmittedForDate = receiptRepository.findAllByDate(date);

        Integer totalProductQuantitySoldForDate = calculateTotalProductQuantitySoldForDate(receiptEmittedForDate);
        Double totalCollectionForDate = calculateTotalCollectionForDate(receiptEmittedForDate);

        return new ReportTotalCollectionByDateResponseDTO(totalProductQuantitySoldForDate, totalCollectionForDate);
    }

    public ReportTotalCollectionByProductByDayResponseDTO calculateSoldProductsForDay(LocalDate date) {
        List<SoldProduct> soldProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSoldProducts().stream())
                .toList();

        List<ReportTotalCollectionByProductItemDTO> reportProductItemList = buildReportProductItemListFromSoldProducts(soldProducts);

        return new ReportTotalCollectionByProductByDayResponseDTO(
                reportProductItemList,
                reportProductItemList.stream().mapToInt(ReportTotalCollectionByProductItemDTO::getQuantity).sum(),
                date
        );
    }

    public ReportTotalCollectionByDepartmentByDayResponseDTO calculateCollectionForDepartmentDay(LocalDate date) {
        List<SoldProduct> soldProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSoldProducts().stream())
                .toList();

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = buildDepartmentItemListFromSoldProduct(soldProducts);

        return new ReportTotalCollectionByDepartmentByDayResponseDTO(departmentItemList, date);
    }

    public ReportTotalCollectionByDepartmentByYearResponseDTO calculateCollectionForDepartmentYear(String year) {
        List<SoldProduct> soldProducts = receiptRepository.findAll().stream()
                .filter(receipt -> receipt.getDate().getYear() == Integer.parseInt(year))
                .flatMap(receipt -> receipt.getSoldProducts().stream())
                .toList();

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = buildDepartmentItemListFromSoldProduct(soldProducts);

        return new ReportTotalCollectionByDepartmentByYearResponseDTO(departmentItemList, year);
    }

    // --------------------------------------------------------------------

    private Integer calculateTotalProductQuantitySoldForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .flatMap(receipt -> receipt.getSoldProducts().stream())
                .mapToInt(SoldProduct::getQuantity)
                .sum();
    }

    private Double calculateTotalCollectionForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .mapToDouble(Receipt::getTotal)
                .sum();
    }

    private List<ReportTotalCollectionByProductItemDTO> buildReportProductItemListFromSoldProducts(List<SoldProduct> soldProducts) {

        List<ReportTotalCollectionByProductItemDTO> reportProductItemList = new ArrayList<>();

        soldProducts.forEach(soldProduct -> {
            Optional<ReportTotalCollectionByProductItemDTO> normItemFound = reportProductItemList.stream()
                    .filter(normItem -> normItem.getProductId() == soldProduct.getBarCode().getProduct().getId())
                    .findFirst();

            if(normItemFound.isEmpty()) {
                reportProductItemList.addLast(new ReportTotalCollectionByProductItemDTO(
                        soldProduct.getBarCode().getProduct().getId(),
                        soldProduct.getBarCode().getProduct().getName(),
                        soldProduct.getQuantity(),
                        soldProduct.getTotal()
                ));
            } else {
                normItemFound.get().setQuantity(
                        normItemFound.get().getQuantity() + soldProduct.getQuantity()
                );

                normItemFound.get().setTotalCollection(
                        soldProduct.getTotal() + normItemFound.get().getTotalCollection()
                );
            }
        });

        return reportProductItemList;
    }

    private List<ReportTotalCollectionByDepartmentItemDTO> buildDepartmentItemListFromSoldProduct(List<SoldProduct> soldProducts) {
        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = new ArrayList<>();

        Map<String,List<SoldProduct>> groupedData = soldProducts.stream().collect(Collectors.groupingBy(
                soldProduct -> soldProduct.getBarCode().getProduct().getDepartement()));

        groupedData.forEach((department, soldProductList) -> {
            departmentItemList.addLast(
                    new ReportTotalCollectionByDepartmentItemDTO(
                            department,
                            soldProductList.stream().mapToDouble(SoldProduct::getTotal).sum()
                    )
            );
        });

        return departmentItemList;
    }
}
