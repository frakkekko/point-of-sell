package ws.peoplefirst.point_of_sell.dto.soldProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class SoldProductResponseDTO {
    private UUID id;
    private UUID receiptId;
    private UUID barCodeId;
    private Integer quantity;
    private Double total;

    public SoldProductResponseDTO() {
    }

    public SoldProductResponseDTO(UUID id, UUID receiptId, Integer quantity, UUID barCodeId, Double total) {
        this.id = id;
        this.receiptId = receiptId;
        this.quantity = quantity;
        this.barCodeId = barCodeId;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getBarCodeId() {
        return barCodeId;
    }

    public void setBarCodeId(UUID barCodeId) {
        this.barCodeId = barCodeId;
    }

    public UUID getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(UUID receiptId) {
        this.receiptId = receiptId;
    }

    public Double getTotal() {
        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
