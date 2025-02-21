package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReportTotalCollectionByDateResponseDTO {

    private Integer totalQuantitySold;
    private Double totalCollection;

    public ReportTotalCollectionByDateResponseDTO(Integer quantity, Double totalCollection) {
        this.totalQuantitySold = quantity;
        this.totalCollection = totalCollection;
    }

    public Integer getTotalQuantitySold() {
        return totalQuantitySold;
    }

    public void setTotalQuantitySold(Integer totalQuantitySold) {
        this.totalQuantitySold = totalQuantitySold;
    }

    public Double getTotalCollection() {
        return new BigDecimal(totalCollection).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }
}
