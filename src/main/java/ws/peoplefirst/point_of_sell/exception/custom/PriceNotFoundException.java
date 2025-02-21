package ws.peoplefirst.point_of_sell.exception.custom;

import java.util.UUID;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException() {
        super("Valid price not found");
    }

    public PriceNotFoundException(UUID barcodeId) {
        super(String.format("Not found a valid price for barcode: %s", barcodeId));
    }
}
