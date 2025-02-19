package ws.peoplefirst.point_of_sell.DTO.receipt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReceiptRequestDTO {
    private LocalDate date;
    private List<Map<UUID, Integer>> barcodes;  // id dei prodotti (no selled product)

    public ReceiptRequestDTO(LocalDate date, List<Map<UUID, Integer>> barcodes) {
        this.date = date;
        this.barcodes = barcodes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Map<UUID, Integer>> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<Map<UUID, Integer>> barcodes) {
        this.barcodes = barcodes;
    }
}
