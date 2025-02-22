package ws.peoplefirst.point_of_sell.dto.report.totalCollectionByDepartment;

import java.time.LocalDate;
import java.util.List;

public class ReportTotalCollectionByDepartmentByDayResponseDTO {

    private List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment;
    private LocalDate date;

    public ReportTotalCollectionByDepartmentByDayResponseDTO(List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment, LocalDate date) {
        this.collectionByDepartment = collectionByDepartment;
        this.date = date;
    }

    public List<ReportTotalCollectionByDepartmentItemDTO> getCollectionByDepartment() {
        return collectionByDepartment;
    }

    public void setCollectionByDepartment(List<ReportTotalCollectionByDepartmentItemDTO> collectionByDepartment) {
        this.collectionByDepartment = collectionByDepartment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
