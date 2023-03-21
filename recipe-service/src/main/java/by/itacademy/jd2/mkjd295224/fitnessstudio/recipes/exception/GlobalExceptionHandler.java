package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.exception;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.exception.response.ErrorResponse;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.exception.response.ErrorResponseField;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.exception.response.StructuredErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleBindException(BindException ex) {
        List<ObjectError> allErrors = ex.getAllErrors();
        StructuredErrorResponse structuredErrorResponse = ErrorResponseUtils.buildStructuredObjectErrorResponse(allErrors);
        return ResponseEntity.badRequest().body(structuredErrorResponse);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<List<ErrorResponse>> handleMissingPathVariableException(MissingPathVariableException ex) {
        String message = "The required path variable '" + ex.getVariableName() + "' is missing from the request URL.";
        ErrorResponse errorResponse = new ErrorResponse(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(errorResponse));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StructuredErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StructuredErrorResponse structuredErrorResponse = ErrorResponseUtils.buildStructuredConstraintViolationResponse(constraintViolations);
        return ResponseEntity.badRequest().body(structuredErrorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<List<ErrorResponse>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        String message = "The request body is not readable or is missing required fields.";
        ErrorResponse errorResponse = new ErrorResponse(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(errorResponse));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StructuredErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ErrorResponseField> errorFields = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorResponseField(fieldError.getDefaultMessage(),
                        fieldError.getField()))
                .collect(Collectors.toList());

        StructuredErrorResponse structuredErrorResponse = new StructuredErrorResponse(errorFields);
        return ResponseEntity.badRequest().body(structuredErrorResponse);
    }

    @ExceptionHandler({EntityNotFoundException.class, OptimisticLockException.class, NullPointerException.class, SQLException.class})
    public ResponseEntity<List<ErrorResponse>> handleGeneralServiceException(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.internalServerError().body(List.of(errorResponse));
    }

    @ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
    public ResponseEntity<List<ErrorResponse>> handleAuthException(RuntimeException ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(List.of());
    }


}
