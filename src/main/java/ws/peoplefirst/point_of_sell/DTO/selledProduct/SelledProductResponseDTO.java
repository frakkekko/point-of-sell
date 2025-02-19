package ws.peoplefirst.point_of_sell.DTO.selledProduct;

import java.util.UUID;

public class SelledProductResponseDTO {
    private UUID id;
    private UUID receiptId;
    private UUID barCodeId;
    private Integer quantity;

    public SelledProductResponseDTO() {
    }

    public SelledProductResponseDTO(UUID id, UUID receiptId, Integer quantity, UUID barCodeId) {
        this.id = id;
        this.receiptId = receiptId;
        this.quantity = quantity;
        this.barCodeId = barCodeId;
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
}
