package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.Receipt;

import java.util.UUID;

public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {
}
