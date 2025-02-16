package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.SelledProduct;

import java.util.UUID;

public interface SelledProductRepository extends JpaRepository<SelledProduct, UUID> {
}
