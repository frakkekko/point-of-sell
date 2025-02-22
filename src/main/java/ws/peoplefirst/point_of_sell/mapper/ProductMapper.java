package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.dto.product.ProductResponseDTO;
import ws.peoplefirst.point_of_sell.model.BarCode;
import ws.peoplefirst.point_of_sell.model.Product;

public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getWeight(),
                product.getUnitType(),
                product.getDepartment(),
                product.getBarcodes().stream().map(BarCode::getId).toList(),
                product.getStock().getQuantity()
        );
    }
}
