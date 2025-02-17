package ws.peoplefirst.point_of_sell.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

    public Stock() {}

    public Stock(LocalDate date, Product product) {
        this.date = date;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
