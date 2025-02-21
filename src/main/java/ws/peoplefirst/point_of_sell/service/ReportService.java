package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDate.ReportTotalCollectionByDateResponseDTO;
import ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment.*;
import ws.peoplefirst.point_of_sell.model.Receipt;
import ws.peoplefirst.point_of_sell.model.SelledProduct;
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
        List<SelledProduct> selledProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        List<ReportTotalCollectionByProductItemDTO> reportProductItemList = buildReportProductItemListFromSelledProducts(selledProducts);

        return new ReportTotalCollectionByProductByDayResponseDTO(
                reportProductItemList,
                reportProductItemList.stream().mapToInt(ReportTotalCollectionByProductItemDTO::getQuantity).sum(),
                date
        );
    }

    public ReportTotalCollectionByDepartmentByDayResponseDTO calculateCollectionForDepartmentDay(LocalDate date) {
        List<SelledProduct> selledProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = buildDepartmentItemListFromSelledProduct(selledProducts);

        return new ReportTotalCollectionByDepartmentByDayResponseDTO(departmentItemList, date);
    }

    public ReportTotalCollectionByDepartmentByYearResponseDTO calculateCollectionForDepartmentYear(String year) {
        List<SelledProduct> selledProducts = receiptRepository.findAll().stream()
                .filter(receipt -> receipt.getDate().getYear() == Integer.parseInt(year))
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = buildDepartmentItemListFromSelledProduct(selledProducts);

        return new ReportTotalCollectionByDepartmentByYearResponseDTO(departmentItemList, year);
    }

    // --------------------------------------------------------------------

    private Integer calculateTotalProductQuantitySoldForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .mapToInt(SelledProduct::getQuantity)
                .sum();
    }

    private Double calculateTotalCollectionForDate(List<Receipt> receiptEmittedForDate) {
        return receiptEmittedForDate.stream()
                .mapToDouble(Receipt::getTotal)
                .sum();
    }

    private List<ReportTotalCollectionByProductItemDTO> buildReportProductItemListFromSelledProducts(List<SelledProduct> selledProducts) {

        List<ReportTotalCollectionByProductItemDTO> reportProductItemList = new ArrayList<>();

        selledProducts.forEach(selledProduct -> {
            Optional<ReportTotalCollectionByProductItemDTO> normItemFound = reportProductItemList.stream()
                    .filter(normItem -> normItem.getProductId() == selledProduct.getBarCode().getProduct().getId())
                    .findFirst();

            if(normItemFound.isEmpty()) {
                reportProductItemList.addLast(new ReportTotalCollectionByProductItemDTO(
                        selledProduct.getBarCode().getProduct().getId(),
                        selledProduct.getBarCode().getProduct().getName(),
                        selledProduct.getQuantity(),
                        selledProduct.getTotal()
                ));
            } else {
                normItemFound.get().setQuantity(
                        normItemFound.get().getQuantity() + selledProduct.getQuantity()
                );

                normItemFound.get().setTotalCollection(
                        selledProduct.getTotal() + normItemFound.get().getTotalCollection()
                );
            }
        });

        return reportProductItemList;
    }

    private List<ReportTotalCollectionByDepartmentItemDTO> buildDepartmentItemListFromSelledProduct(List<SelledProduct> selledProducts) {
        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = new ArrayList<>();

        Map<String,List<SelledProduct>> groupedData = selledProducts.stream().collect(Collectors.groupingBy(
                selledProduct -> selledProduct.getBarCode().getProduct().getDepartement()));

        groupedData.forEach((department, selledProductList) -> {
            departmentItemList.addLast(
                    new ReportTotalCollectionByDepartmentItemDTO(
                            department,
                            selledProductList.stream().mapToDouble(SelledProduct::getTotal).sum()
                    )
            );
        });

        return departmentItemList;
    }
}
