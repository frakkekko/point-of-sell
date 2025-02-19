package ws.peoplefirst.point_of_sell.DTO.stock;


import java.time.LocalDate;
import java.util.UUID;

public class StockResponseDTO {

    private UUID id;
    private LocalDate date;
    private Integer quantity;
    private UUID productId;

    public StockResponseDTO() {
    }

    public StockResponseDTO(UUID id, LocalDate date, Integer quantity, UUID productId) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.productId = productId;
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

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
