package ws.peoplefirst.point_of_sell.mapper;

import ws.peoplefirst.point_of_sell.DTO.barcode.BarcodeResponseDTO;
import ws.peoplefirst.point_of_sell.model.BarCode;

public class BarCodeMapper {

    public static BarcodeResponseDTO toResponseDTO(BarCode barcode) {
        return new BarcodeResponseDTO(
                barcode.getId(),
                barcode.getCode(),
                barcode.getDateStartValidity(),
                barcode.getDateEndValidity(),
                barcode.getProduct().getId(),
                barcode.getPrices().stream().map(price -> price.getId()).toList()
        );
    }
}
