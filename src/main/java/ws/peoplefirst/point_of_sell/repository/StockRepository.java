package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.Stock;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
}
