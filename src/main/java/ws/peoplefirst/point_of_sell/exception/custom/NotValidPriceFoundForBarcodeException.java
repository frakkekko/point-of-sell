package ws.peoplefirst.point_of_sell.exception.custom;

import java.util.UUID;

public class NotValidPriceFoundForBarcodeException extends RuntimeException {

    public NotValidPriceFoundForBarcodeException() {
        super("Valid price not found");
    }

    public NotValidPriceFoundForBarcodeException(UUID barcodeId) {
        super(String.format("Not found a valid price for barcode: %s", barcodeId));
    }
}
