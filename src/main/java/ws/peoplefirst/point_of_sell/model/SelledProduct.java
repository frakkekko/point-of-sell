package ws.peoplefirst.point_of_sell.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonBackReference
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "barcode_id", nullable = false)
    @JsonBackReference
    private BarCode barCode;

    @JsonProperty
    public UUID getProductId() {
        return barCode.getId();
    }

    public SelledProduct() {}

    public SelledProduct(Receipt receipt, BarCode barCode) {
        this.receipt = receipt;
        this.barCode = barCode;
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
}
