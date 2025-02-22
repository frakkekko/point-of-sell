package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.dto.stock.StockResponseDTO;
import ws.peoplefirst.point_of_sell.model.Stock;

public class StockMapper {

    public static StockResponseDTO toResponseDTO(Stock stock) {
        return new StockResponseDTO(
                stock.getId(),
                stock.getDate(),
                stock.getQuantity(),
                stock.getProduct().getId()
        );
    }
}
