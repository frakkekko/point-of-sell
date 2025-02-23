package ws.peoplefirst.point_of_sell.exception.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.peoplefirst.point_of_sell.exception.responseDto.CommonExceptionResponseDTO;
import ws.peoplefirst.point_of_sell.exception.responseDto.utils.ExceptionMapper;

@ControllerAdvice
public class CommonExceptionHandler<T> {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonExceptionResponseDTO> handleException(EntityNotFoundException exception) {
        return new ResponseEntity<>(ExceptionMapper.mapCommonExceptionToResponseBody(exception), HttpStatus.NOT_FOUND);
    }
}
