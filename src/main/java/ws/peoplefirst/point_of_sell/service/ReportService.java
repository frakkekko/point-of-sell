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

    public ReportTotalCollectionByProductByDayResponseDTO calculateSoldProductsForDay(LocalDate date) {
        List<SelledProduct> selledProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        List<ReportTotalCollectionByProductItemDTO> normalizedProductList = new ArrayList<>();

        selledProducts.forEach(selledProduct -> {
            Optional<ReportTotalCollectionByProductItemDTO> normItemFound = normalizedProductList.stream()
                    .filter(normItem -> normItem.getProductId() == selledProduct.getBarCode().getProduct().getId())
                    .findFirst();

            if(normItemFound.isEmpty()) {
                normalizedProductList.addLast(new ReportTotalCollectionByProductItemDTO(
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

        return new ReportTotalCollectionByProductByDayResponseDTO(
                normalizedProductList,
                normalizedProductList.stream().mapToInt(ReportTotalCollectionByProductItemDTO::getQuantity).sum(),
                date
        );
    }

    public ReportTotalCollectionByDepartmentByDayResponseDTO calculateCollectionForDepartmentDay(LocalDate date) {
        List<SelledProduct> selledProducts = receiptRepository.findAllByDate(date).stream()
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        Map<String,List<SelledProduct>> groupedData = selledProducts.stream().collect(Collectors.groupingBy(
                selledProduct -> selledProduct.getBarCode().getProduct().getDepartement()));

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = new ArrayList<>();

        groupedData.forEach((department, selledProductList) -> {
            departmentItemList.addLast(
                    new ReportTotalCollectionByDepartmentItemDTO(
                            department,
                            selledProductList.stream().mapToDouble(SelledProduct::getTotal).sum()
                            )
            );
        });

        return new ReportTotalCollectionByDepartmentByDayResponseDTO(departmentItemList, date);
    }

    public ReportTotalCollectionByDepartmentByYearResponseDTO calculateCollectionForDepartmentYear(String year) {
        List<SelledProduct> selledProducts = receiptRepository.findAll().stream()
                .filter(receipt -> receipt.getDate().getYear() == Integer.parseInt(year))
                .flatMap(receipt -> receipt.getSelledProducts().stream())
                .toList();

        Map<String,List<SelledProduct>> groupedData = selledProducts.stream().collect(Collectors.groupingBy(
                selledProduct -> selledProduct.getBarCode().getProduct().getDepartement()));

        List<ReportTotalCollectionByDepartmentItemDTO> departmentItemList = new ArrayList<>();

        groupedData.forEach((department, selledProductList) -> {
            departmentItemList.addLast(
                    new ReportTotalCollectionByDepartmentItemDTO(
                            department,
                            selledProductList.stream().mapToDouble(SelledProduct::getTotal).sum()
                    )
            );
        });

        return new ReportTotalCollectionByDepartmentByYearResponseDTO(departmentItemList, year);
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
