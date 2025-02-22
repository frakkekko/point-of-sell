package ws.peoplefirst.point_of_sell.dto.price;

import java.time.LocalDate;
import java.util.UUID;

public class PriceResponseDTO {

    private UUID id;
    private LocalDate dateStartValidity;
    private LocalDate dateEndValidity;
    private Double amount;
    private UUID barcodeId;

    public PriceResponseDTO() {
    }

    public PriceResponseDTO(UUID id, LocalDate dateStartValidity, LocalDate dateEndValidity, Double amount, UUID barcodeId) {
        this.id = id;
        this.dateStartValidity = dateStartValidity;
        this.dateEndValidity = dateEndValidity;
        this.amount = amount;
        this.barcodeId = barcodeId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(UUID barcodeId) {
        this.barcodeId = barcodeId;
    }

    public LocalDate getDateEndValidity() {
        return dateEndValidity;
    }

    public void setDateEndValidity(LocalDate dateEndValidity) {
        this.dateEndValidity = dateEndValidity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDateStartValidity() {
        return dateStartValidity;
    }

    public void setDateStartValidity(LocalDate dateStartValidity) {
        this.dateStartValidity = dateStartValidity;
    }
}
