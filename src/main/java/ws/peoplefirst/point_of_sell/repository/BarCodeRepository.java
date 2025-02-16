package ws.peoplefirst.point_of_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.peoplefirst.point_of_sell.model.BarCode;

import java.util.UUID;

public interface BarCodeRepository extends JpaRepository<BarCode, UUID> {
}
