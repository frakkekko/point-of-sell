package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.dto.barcode.BarcodeResponseDTO;
import ws.peoplefirst.point_of_sell.model.BarCode;
import ws.peoplefirst.point_of_sell.model.Price;

public class BarCodeMapper {

    public static BarcodeResponseDTO toResponseDTO(BarCode barcode) {
        return new BarcodeResponseDTO(
                barcode.getId(),
                barcode.getCode(),
                barcode.getDateStartValidity(),
                barcode.getDateEndValidity(),
                barcode.getProduct().getId(),
                barcode.getPrices().stream().map(Price::getId).toList()
        );
    }
}
