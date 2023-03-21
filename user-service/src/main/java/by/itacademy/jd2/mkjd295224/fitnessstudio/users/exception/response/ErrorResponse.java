package by.itacademy.jd2.mkjd295224.fitnessstudio.users.exception.response;

public class ErrorResponse {

    private final String logref = "error";
    private final String message;


    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public String getMessage() {
        return message;
    }
}
