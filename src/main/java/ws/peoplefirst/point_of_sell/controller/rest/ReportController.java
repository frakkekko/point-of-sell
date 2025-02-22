package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.dto.report.totalCollectionByDate.ReportTotalCollectionByDateResponseDTO;
import ws.peoplefirst.point_of_sell.dto.report.totalCollectionByDepartment.ReportTotalCollectionByDepartmentByDayResponseDTO;
import ws.peoplefirst.point_of_sell.dto.report.totalCollectionByDepartment.ReportTotalCollectionByDepartmentByYearResponseDTO;
import ws.peoplefirst.point_of_sell.dto.report.totalCollectionByDepartment.ReportTotalCollectionByProductByDayResponseDTO;
import ws.peoplefirst.point_of_sell.service.ReportService;

import java.time.LocalDate;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/total-collection-by-date/{date}")
    public ResponseEntity<ReportTotalCollectionByDateResponseDTO> getTotalCollectionByDate(@PathVariable LocalDate date) {
        return new ResponseEntity<>(reportService.calculateTotalCollectionByDate(date), HttpStatus.OK);
    }

    @GetMapping("/sold-products-for-day/{date}")
    public ResponseEntity<ReportTotalCollectionByProductByDayResponseDTO> getProductsSoldRecap(@PathVariable LocalDate date) {
        return new ResponseEntity<>(reportService.calculateSoldProductsForDay(date), HttpStatus.OK);
    }

    @GetMapping("/total-collection-by-department-day/{date}")
    public ResponseEntity<ReportTotalCollectionByDepartmentByDayResponseDTO> getCollectionForDepartmentDay(@PathVariable LocalDate date) {
        return new ResponseEntity<>(reportService.calculateCollectionForDepartmentDay(date), HttpStatus.OK);
    }

    @GetMapping("/total-collection-by-department-year/{year}")
    public ResponseEntity<ReportTotalCollectionByDepartmentByYearResponseDTO> getCollectionForDepartmentDay(@PathVariable String year) {
        return new ResponseEntity<>(reportService.calculateCollectionForDepartmentYear(year), HttpStatus.OK);
    }
}
