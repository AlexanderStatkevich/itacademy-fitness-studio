package by.itacademy.jd2.mkjd295224.fitnessstudio.users.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class StructuredErrorResponse {

    private final String logref = "structured_error";
    private final List<FieldErrorResponse> errors;

    public StructuredErrorResponse(List<ObjectError> errors) {
        this.errors = errors.stream()
                .map(FieldErrorResponse::new)
                .toList();
    }

    public String getLogref() {
        return logref;
    }

    public List<FieldErrorResponse> getErrors() {
        return errors;
    }
}



