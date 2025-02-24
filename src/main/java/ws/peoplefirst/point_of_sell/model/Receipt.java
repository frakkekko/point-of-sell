package ws.peoplefirst.point_of_sell.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total")
    private Double total;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SoldProduct> soldProducts;

    public Receipt() {}

    public Receipt(LocalDate date, List<SoldProduct> soldProducts, Double total) {
        this.date = date;
        this.soldProducts = soldProducts;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSoldProducts(List<SoldProduct> soldProducts) {
        this.soldProducts = soldProducts;
    }
    
    public List<SoldProduct> getSoldProducts() {
        return soldProducts;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
