package ws.peoplefirst.point_of_sell.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    @Column(name = "date_start_validity")
    private LocalDate dateStartValidity;

    @Column(name = "date_end_validity")
    private LocalDate dateEndValidity;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "barcode_id", nullable = false)
    private BarCode barcode;

    @JsonProperty
    public UUID getBarCodeId() {
        return barcode.getId();
    }

    public Price() {}

    public Price(LocalDate dateStartValidity, LocalDate dateEndValidity, BarCode barcode) {
        this.dateStartValidity = dateStartValidity;
        this.dateEndValidity = dateEndValidity;
        this.barcode = barcode;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BarCode getBarcode() {
        return barcode;
    }

    public void setBarcode(BarCode barcode) {
        this.barcode = barcode;
    }
}
