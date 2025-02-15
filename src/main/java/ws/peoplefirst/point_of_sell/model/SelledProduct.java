package ws.peoplefirst.point_of_sell.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "selled_product")
public class SelledProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public SelledProduct() {}

    public SelledProduct(Receipt receipt, Product product) {
        this.receipt = receipt;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
