package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.Price;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
