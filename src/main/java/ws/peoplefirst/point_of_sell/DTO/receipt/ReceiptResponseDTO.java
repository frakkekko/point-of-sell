package ws.peoplefirst.point_of_sell.DTO.receipt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReceiptResponseDTO {
    private UUID id;
    private LocalDate date;
    private List<Map<UUID, Integer>> selledProducts;
    private Double total;

    public ReceiptResponseDTO(UUID id, LocalDate date, List<Map<UUID, Integer>> selledProducts, Double total) {
        this.id = id;
        this.date = date;
        this.selledProducts = selledProducts;
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

    public List<Map<UUID, Integer>> getSelledProducts() {
        return selledProducts;
    }

    public void setSelledProducts(List<Map<UUID, Integer>> selledProducts) {
        this.selledProducts = selledProducts;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
