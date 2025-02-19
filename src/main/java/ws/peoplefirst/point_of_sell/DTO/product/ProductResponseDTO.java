package ws.peoplefirst.point_of_sell.DTO.product;

import java.util.List;
import java.util.UUID;

public class ProductResponseDTO {
    private UUID id;
    private String name;
    private Double weight;
    private String unitType;
    private String department;
    private List<UUID> barcodeIds;
    private Integer stockQuantity;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(UUID id, String name, Double weight, String unitType, String department, List<UUID> barcodeIds, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.unitType = unitType;
        this.department = department;
        this.barcodeIds = barcodeIds;
        this.stockQuantity = stockQuantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<UUID> getBarcodeIds() {
        return barcodeIds;
    }

    public void setBarcodeIds(List<UUID> barcodeIds) {
        this.barcodeIds = barcodeIds;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
