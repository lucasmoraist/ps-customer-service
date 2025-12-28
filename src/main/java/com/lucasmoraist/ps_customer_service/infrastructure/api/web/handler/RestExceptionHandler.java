package com.lucasmoraist.ps_customer_service.infrastructure.api.web.handler;

import com.lucasmoraist.ps_customer_service.domain.exceptions.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Void> handleNotFoundException(NotFoundException ex) {
        log.warn("Resource not found", ex);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<DataException>> handleDataRequestException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors()
                .stream()
                .map(DataException::new)
                .toList();
        log.warn("Data request exception");

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleException(Exception ex) {
        log.error("Internal server error", ex);
        return ResponseEntity.internalServerError().build();
    }

    public record DataException(String label, String message) {

        public DataException(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }

}
