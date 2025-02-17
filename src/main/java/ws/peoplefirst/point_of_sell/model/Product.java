package ws.peoplefirst.point_of_sell.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "unit_type")
    private String unitType;

    @Column(name = "departement")
    private String departement;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BarCode> barcodes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Price> prices;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Stock> stock;

    public Product() {};

    public Product(String name, Double weight, String unitType, String departement, List<BarCode> barcodes, List<Price> prices, List<Stock> stock) {
        this.name = name;
        this.weight = weight;
        this.unitType = unitType;
        this.departement = departement;
        this.barcodes = barcodes;
        this.prices = prices;
        this.stock = stock;
    }

    public UUID getId() {
        return id;
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

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<BarCode> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<BarCode> barcodes) {
        this.barcodes = barcodes;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }
}
