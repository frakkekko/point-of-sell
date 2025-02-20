package ws.peoplefirst.point_of_sell.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "selled_product")
public class SelledProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "barcode_id", nullable = false)
    private BarCode barCode;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    public SelledProduct() {}

    public SelledProduct(Receipt receipt, BarCode barCode, Integer quantity, Double singlePrice) {
        this.receipt = receipt;
        this.barCode = barCode;
        this.quantity = quantity;
        this.total = singlePrice * (double) quantity;
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

    public BarCode getBarCode() {
        return barCode;
    }

    public void setBarCode(BarCode barCode) {
        this.barCode = barCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
