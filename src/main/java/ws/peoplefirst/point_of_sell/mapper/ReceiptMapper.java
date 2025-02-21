package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.model.Receipt;

public class ReceiptMapper {

    public static ReceiptResponseDTO toResponseDTO(Receipt receipt) {
        return new ReceiptResponseDTO(
                receipt.getId(),
                receipt.getDate(),
                receipt.getSoldProducts().stream().map(soldProduct -> SoldProductMapper.toResponseDTO(soldProduct)).toList(),
                receipt.getTotal()
        );
    }
}
