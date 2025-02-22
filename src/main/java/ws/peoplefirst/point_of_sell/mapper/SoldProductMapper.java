package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.dto.soldProduct.SoldProductResponseDTO;
import ws.peoplefirst.point_of_sell.model.SoldProduct;

public class SoldProductMapper {

    public static SoldProductResponseDTO toResponseDTO(SoldProduct soldProduct) {
        return new SoldProductResponseDTO(
                soldProduct.getId(),
                soldProduct.getReceipt().getId(),
                soldProduct.getQuantity(),
                soldProduct.getBarCode().getId(),
                soldProduct.getTotal()
        );
    }
}
