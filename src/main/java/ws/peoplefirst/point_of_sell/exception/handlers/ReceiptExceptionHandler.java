package ws.peoplefirst.point_of_sell.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.peoplefirst.point_of_sell.controller.rest.ReceiptController;
import ws.peoplefirst.point_of_sell.exception.custom.NotValidPriceFoundForBarcodeException;
import ws.peoplefirst.point_of_sell.exception.custom.ProductNotAvailableInMagazineException;
import ws.peoplefirst.point_of_sell.exception.responseDto.CommonExceptionResponseDTO;
import ws.peoplefirst.point_of_sell.exception.responseDto.utils.ExceptionMapper;

@ControllerAdvice(assignableTypes = ReceiptController.class)
public class ReceiptExceptionHandler {

    @ExceptionHandler(ProductNotAvailableInMagazineException.class)
    public ResponseEntity<CommonExceptionResponseDTO> handleException(ProductNotAvailableInMagazineException exception) {
        return new ResponseEntity<>(ExceptionMapper.mapCommonExceptionToResponseBody(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotValidPriceFoundForBarcodeException.class)
    public ResponseEntity<CommonExceptionResponseDTO> handleException(NotValidPriceFoundForBarcodeException exception) {
        return new ResponseEntity<>(ExceptionMapper.mapCommonExceptionToResponseBody(exception), HttpStatus.NOT_FOUND);
    }

}
