package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

import java.time.LocalDate;
import java.util.List;

public class ReportTotalCollectionByDepartmentByDayResponseDTO {

    private List<ReportTotalCollectionByDepartmentDayItemDTO> collectionByDepartment;
    private LocalDate date;

    public ReportTotalCollectionByDepartmentByDayResponseDTO(List<ReportTotalCollectionByDepartmentDayItemDTO> collectionByDepartment, LocalDate date) {
        this.collectionByDepartment = collectionByDepartment;
        this.date = date;
    }

    public List<ReportTotalCollectionByDepartmentDayItemDTO> getCollectionByDepartment() {
        return collectionByDepartment;
    }

    public void setCollectionByDepartment(List<ReportTotalCollectionByDepartmentDayItemDTO> collectionByDepartment) {
        this.collectionByDepartment = collectionByDepartment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
