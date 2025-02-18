package ws.peoplefirst.point_of_sell.DTO.receipt;

import ws.peoplefirst.point_of_sell.model.SelledProduct;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ReceiptResponseDTO {
    private UUID id;
    private LocalDate date;
    private List<String> selledProductsIds;

    public ReceiptResponseDTO(UUID id, LocalDate date, List<String> selledProductsIds) {
        this.id = id;
        this.date = date;
        this.selledProductsIds = selledProductsIds;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getSelledProductsIds() {
        return selledProductsIds;
    }

    public void setSelledProductsIds(List<String> selledProductsIds) {
        this.selledProductsIds = selledProductsIds;
    }
}
