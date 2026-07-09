package com.harsh.microservices.ecom_paymentservice.exceptions;

import com.harsh.microservices.ecom_paymentservice.dto.PaymentErrorResponse;
import com.harsh.microservices.ecom_paymentservice.dto.PaymentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentGlobalHandler {

    @ExceptionHandler(Payment401Exception.class)
    public ResponseEntity<PaymentErrorResponse> handle401(Payment401Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new PaymentErrorResponse());
    }

    @ExceptionHandler(Payment403Exception.class)
    public ResponseEntity<PaymentErrorResponse> handle403(Payment403Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new PaymentErrorResponse());
    }
}
