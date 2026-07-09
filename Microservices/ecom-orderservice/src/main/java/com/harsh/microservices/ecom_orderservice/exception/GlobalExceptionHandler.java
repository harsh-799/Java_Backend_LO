package com.harsh.microservices.ecom_orderservice.exception;

import com.harsh.microservices.ecom_orderservice.dto.ErrorResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InventoryServiceUnavailableException.class)
    public ResponseEntity<ErrorResponses> handleInventoryServiceUnavailable(InventoryServiceUnavailableException ex) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setSuccess(false);
        errorResponses.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponses);
    }

    @ExceptionHandler(PaymentServiceUnavailableException.class)
    public ResponseEntity<ErrorResponses> handlePaymentServiceUnavailable(PaymentServiceUnavailableException ex) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setSuccess(false);
        errorResponses.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponses);
    }

    @ExceptionHandler(Inventory401Exception.class)
    public ResponseEntity<ErrorResponses> handleServiceUnauthorized(Inventory401Exception ex) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setSuccess(false);
        errorResponses.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponses);
    }

    @ExceptionHandler(Inventory403Exception.class)
    public ResponseEntity<ErrorResponses> handleServiceForbidden(Inventory403Exception ex) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setSuccess(false);
        errorResponses.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponses);
    }
}
