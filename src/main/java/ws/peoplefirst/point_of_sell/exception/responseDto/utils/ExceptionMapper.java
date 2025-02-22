package ws.peoplefirst.point_of_sell.exception.responseDto.utils;

import ws.peoplefirst.point_of_sell.exception.responseDto.CommonExceptionResponseDTO;

public class ExceptionMapper {

    public static CommonExceptionResponseDTO mapCommonExceptionToResponseBody(Exception exception) {
        return new CommonExceptionResponseDTO(System.currentTimeMillis(), exception.getClass().getSimpleName(), exception.getMessage());
    }
}
