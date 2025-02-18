package ws.peoplefirst.point_of_sell.DTO.receipt;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ReceiptRequestDTO {
    private LocalDate date;
    private List<UUID> productIds;  // id dei prodotti (no selled product)

    public ReceiptRequestDTO(LocalDate date, List<String> productIds) {
        this.date = date;
        this.productIds = productIds.stream().map(productIdStr -> UUID.fromString(productIdStr)).toList();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<UUID> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<UUID> productIds) {
        this.productIds = productIds;
    }
}
