package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
