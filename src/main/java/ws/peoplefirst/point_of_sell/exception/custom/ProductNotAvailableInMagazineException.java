package ws.peoplefirst.point_of_sell.exception.custom;

import ws.peoplefirst.point_of_sell.model.SoldProduct;
import ws.peoplefirst.point_of_sell.model.Stock;

import java.util.UUID;

public class ProductNotAvailableInMagazineException extends RuntimeException {

    public ProductNotAvailableInMagazineException() {
        super("Product not available in magazine.");
    }

    public ProductNotAvailableInMagazineException(SoldProduct soldProduct, Stock productStock) {
        super(String.format("Product with id '%s' associated to barcode %s is not available in magazine. Requested %s Available %s",
                soldProduct.getBarCode().getProduct().getId(),
                soldProduct.getBarCode().getId(),
                soldProduct.getQuantity(),
                productStock.getQuantity()));
    }

    public ProductNotAvailableInMagazineException(UUID productId, Integer quantityAvailable, Integer quantityRequested) {
        super(String.format("Product with id: '%s' is not available in magazine. Requested %s Available %s", productId, quantityRequested, quantityAvailable));
    }

    public ProductNotAvailableInMagazineException(UUID productId, Integer quantityAvailable) {
        super(String.format("Product with id: '%s' is not available in magazine. Quantity Available %s", productId, quantityAvailable));
    }

    public ProductNotAvailableInMagazineException(UUID productId) {
        super(String.format("Product with id: '%s' is not available in magazine.", productId));
    }
}
