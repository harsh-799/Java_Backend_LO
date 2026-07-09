package com.harsh.microservices.ecom_inventoryservice.exceptions;

import com.harsh.microservices.ecom_inventoryservice.dto.InventoryErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ExceptionStatus401.class)
    public ResponseEntity<InventoryErrorResponse> handle401(ExceptionStatus401 ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new InventoryErrorResponse());
    }

    @ExceptionHandler(ExceptionStatus403.class)
    public ResponseEntity<InventoryErrorResponse> handle403(ExceptionStatus403 ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new InventoryErrorResponse());
    }
}
