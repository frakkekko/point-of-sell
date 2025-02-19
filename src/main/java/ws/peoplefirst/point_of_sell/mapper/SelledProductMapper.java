package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.DTO.selledProduct.SelledProductResponseDTO;
import ws.peoplefirst.point_of_sell.model.SelledProduct;

public class SelledProductMapper {

    public static SelledProductResponseDTO toResponseDTO(SelledProduct selledProduct) {
        return new SelledProductResponseDTO(
                selledProduct.getId(),
                selledProduct.getReceipt().getId(),
                selledProduct.getQuantity(),
                selledProduct.getBarCode().getId()
        );
    }
}
