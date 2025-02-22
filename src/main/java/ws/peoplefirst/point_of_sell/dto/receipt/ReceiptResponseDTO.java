package ws.peoplefirst.point_of_sell.dto.receipt;

import ws.peoplefirst.point_of_sell.dto.soldProduct.SoldProductResponseDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ReceiptResponseDTO {
    private UUID id;
    private LocalDate date;
    private List<SoldProductResponseDTO> soldProducts;
    private Double total;

    public ReceiptResponseDTO() {
    }

    public ReceiptResponseDTO(UUID id, LocalDate date, List<SoldProductResponseDTO> soldProducts, Double total) {
        this.id = id;
        this.date = date;
        this.soldProducts = soldProducts;
        this.total = total;
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

    public List<SoldProductResponseDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductResponseDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Double getTotal() {
        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
