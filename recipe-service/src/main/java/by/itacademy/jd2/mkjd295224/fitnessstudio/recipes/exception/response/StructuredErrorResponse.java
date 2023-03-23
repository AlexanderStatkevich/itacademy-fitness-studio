package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.exception.response;

import java.util.List;

public class StructuredErrorResponse {

    private final String logref = "structured_error";
    private final List<ErrorResponseField> errors;

    public StructuredErrorResponse(List<ErrorResponseField> errors) {
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<ErrorResponseField> getErrors() {
        return errors;
    }
}



