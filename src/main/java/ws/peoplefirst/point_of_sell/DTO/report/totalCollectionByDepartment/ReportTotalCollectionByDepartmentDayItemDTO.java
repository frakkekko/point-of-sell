package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

public class ReportTotalCollectionByDepartmentDayItemDTO {

    private String department;
    private Double totalCollection;

    public ReportTotalCollectionByDepartmentDayItemDTO(String department, Double totalCollection) {
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
        return totalCollection;
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }
}
