package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReportTotalCollectionByDepartmentItemDTO {

    private String department;
    private Double totalCollection;

    public ReportTotalCollectionByDepartmentItemDTO(String department, Double totalCollection) {
        this.department = department;
        this.totalCollection = totalCollection;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getTotalCollection() {
        return new BigDecimal(totalCollection).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }
}
