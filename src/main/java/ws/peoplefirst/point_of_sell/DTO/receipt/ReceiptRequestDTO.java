package ws.peoplefirst.point_of_sell.DTO.receipt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ReceiptRequestDTO {
    private LocalDate date;
    private List<Map<String, String>> barcodes;

    public ReceiptRequestDTO() {
    }

    public ReceiptRequestDTO(LocalDate date, List<Map<String, String>> barcodes) {
        this.date = date;
        this.barcodes = barcodes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Map<String, String>> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<Map<String, String>> barcodes) {
        this.barcodes = barcodes;
    }
}
