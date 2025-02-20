package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

import java.time.LocalDate;
import java.util.List;

public class ReportTotalCollectionByProductByDayResponseDTO {

    private List<ReportTotalCollectionByProductItemDTO> collectionByProductList;
    private Integer totalItemsSold;
    private LocalDate date;

    public ReportTotalCollectionByProductByDayResponseDTO(List<ReportTotalCollectionByProductItemDTO> collectionByProductList, Integer totalItemsSold, LocalDate date) {
        this.collectionByProductList = collectionByProductList;
        this.totalItemsSold = totalItemsSold;
        this.date = date;
    }

    public List<ReportTotalCollectionByProductItemDTO> getCollectionByProductList() {
        return collectionByProductList;
    }

    public void setCollectionByProductList(List<ReportTotalCollectionByProductItemDTO> collectionByProductList) {
        this.collectionByProductList = collectionByProductList;
    }

    public Integer getTotalItemsSold() {
        return totalItemsSold;
    }

    public void setTotalItemsSold(Integer totalItemsSold) {
        this.totalItemsSold = totalItemsSold;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
