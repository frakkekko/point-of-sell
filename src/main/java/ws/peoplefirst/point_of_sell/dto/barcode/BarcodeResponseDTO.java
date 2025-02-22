package ws.peoplefirst.point_of_sell.dto.barcode;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class BarcodeResponseDTO {
    private UUID id;
    private String code;
    private LocalDate dateStartValidity;
    private LocalDate dateEndValidity;
    private UUID productId;
    private List<UUID> priceIds;

    public BarcodeResponseDTO() {}

    public BarcodeResponseDTO(UUID id, String code, LocalDate dateStartValidity, LocalDate dateEndValidity, UUID productId, List<UUID> priceIds) {
        this.id = id;
        this.code = code;
        this.dateStartValidity = dateStartValidity;
        this.dateEndValidity = dateEndValidity;
        this.productId = productId;
        this.priceIds = priceIds;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateEndValidity() {
        return dateEndValidity;
    }

    public void setDateEndValidity(LocalDate dateEndValidity) {
        this.dateEndValidity = dateEndValidity;
    }

    public LocalDate getDateStartValidity() {
        return dateStartValidity;
    }

    public void setDateStartValidity(LocalDate dateStartValidity) {
        this.dateStartValidity = dateStartValidity;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public List<UUID> getPriceIds() {
        return priceIds;
    }

    public void setPriceIds(List<UUID> priceIds) {
        this.priceIds = priceIds;
    }
}
