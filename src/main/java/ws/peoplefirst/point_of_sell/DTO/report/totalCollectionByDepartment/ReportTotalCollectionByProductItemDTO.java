package ws.peoplefirst.point_of_sell.DTO.report.totalCollectionByDepartment;

import java.util.UUID;

public class ReportTotalCollectionByProductItemDTO {

    private UUID productId;
    private String productName;
    private Integer quantity;
    private Double totalCollection;

    public ReportTotalCollectionByProductItemDTO(UUID productId, String productName, Integer quantity, Double totalCollection) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalCollection = totalCollection;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }
}
