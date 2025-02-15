package ws.peoplefirst.point_of_sell.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "date_start_validity")
    private LocalDate dateStartValidity;

    @Column(name = "date_end_validity")
    private LocalDate dateEndValidity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Price() {}

    public Price(LocalDate dateStartValidity, LocalDate dateEndValidity, Product product) {
        this.dateStartValidity = dateStartValidity;
        this.dateEndValidity = dateEndValidity;
        this.product = product;
    }

    public UUID getId() {
        return id;
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
}
