package ws.peoplefirst.point_of_sell.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "barcode")
public class BarCode {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "date_start_validity")
    private LocalDate dateStartValidity;

    @Column(name = "date_end_validity")
    private LocalDate dateEndValidity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "barcode", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Price> prices;

    @JsonProperty
    public UUID getProductId() {
        return product.getId();
    }

    public BarCode() {}

    public BarCode(String code, LocalDate dateStartValidity, LocalDate dateEndValidity, Product product, List<Price> prices) {
        this.code = code;
        this.dateStartValidity = dateStartValidity;
        this.dateEndValidity = dateEndValidity;
        this.product = product;
        this.prices = prices;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateStartValidity() {
        return dateStartValidity;
    }

    public void setDateStartValidity(LocalDate dateStartValidity) {
        this.dateStartValidity = dateStartValidity;
    }

    public LocalDate getDateEndValidity() {
        return dateEndValidity;
    }

    public void setDateEndValidity(LocalDate dateEndValidity) {
        this.dateEndValidity = dateEndValidity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
