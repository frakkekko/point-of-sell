package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

import java.util.List;

public class ReportTotalCollectionByDepartmentByYearResponseDTO {

    private List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment;
    private String year;

    public ReportTotalCollectionByDepartmentByYearResponseDTO(List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment, String year) {
        this.collectionByDepartment = collectionByDepartment;
        this.year = year;
    }

    public List<ReportTotalCollectionByDepartmentItemDTO> getCollectionByDepartment() {
        return collectionByDepartment;
    }

    public void setCollectionByDepartment(List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment) {
        this.collectionByDepartment = collectionByDepartment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
