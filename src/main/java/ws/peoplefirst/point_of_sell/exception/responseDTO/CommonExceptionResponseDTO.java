package ws.peoplefirst.point_of_sell.exception.responseDTO;

public class CommonExceptionResponseDTO {

    private long timestamp;
    private String exceptionType;
    private String message;

    public CommonExceptionResponseDTO(long timestamp, String exceptionType, String message) {
        this.timestamp = timestamp;
        this.exceptionType = exceptionType;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
