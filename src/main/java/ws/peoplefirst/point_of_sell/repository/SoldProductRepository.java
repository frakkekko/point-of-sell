package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.SoldProduct;

import java.util.UUID;

public interface SoldProductRepository extends JpaRepository<SoldProduct, UUID> {
}
