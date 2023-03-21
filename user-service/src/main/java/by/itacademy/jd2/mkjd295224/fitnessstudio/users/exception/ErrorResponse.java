package by.itacademy.jd2.mkjd295224.fitnessstudio.users.exception;

public class ErrorResponse {

    private final String logref = "error";
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
