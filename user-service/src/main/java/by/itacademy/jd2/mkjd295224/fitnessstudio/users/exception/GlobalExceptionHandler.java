package by.itacademy.jd2.mkjd295224.fitnessstudio.users.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    protected ResponseEntity<Object> handleConflict(BindException ex, WebRequest request) {
        List<ObjectError> allErrors = ex.getAllErrors();
        return ResponseEntity.badRequest().body(new StructuredErrorResponse(allErrors));
    }
}
