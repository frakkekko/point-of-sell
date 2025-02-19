package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.DTO.price.PriceResponseDTO;
import ws.peoplefirst.point_of_sell.model.Price;

public class PriceMapper {

    public static PriceResponseDTO toResponseDTO(Price price) {
        return new PriceResponseDTO(
                price.getId(),
                price.getDateStartValidity(),
                price.getDateEndValidity(),
                price.getAmount(),
                price.getBarcode().getId()
        );
    }
}
