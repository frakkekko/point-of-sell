package ws.peoplefirst.point_of_sell.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SelledProduct> selledProducts;

    public Receipt() {}

    public Receipt(LocalDate date, List<SelledProduct> selledProducts) {
        this.date = date;
        this.selledProducts = selledProducts;
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

    public void setSelledProducts(List<SelledProduct> selledProducts) {
        this.selledProducts = selledProducts;
    }
    
    public List<SelledProduct> getSelledProducts() {
        return selledProducts;
    }
}
