package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.DTO.product.ProductResponseDTO;
import ws.peoplefirst.point_of_sell.model.Product;

public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getWeight(),
                product.getUnitType(),
                product.getDepartement(),
                product.getBarcodes().stream().map(barcode -> barcode.getId()).toList(),
                product.getStock().getQuantity()
        );
    }
}
