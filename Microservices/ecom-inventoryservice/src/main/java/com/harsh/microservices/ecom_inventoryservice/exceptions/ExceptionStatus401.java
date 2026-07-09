package com.harsh.microservices.ecom_inventoryservice.exceptions;

public class ExceptionStatus401 extends RuntimeException {
    public ExceptionStatus401(String message) {
        super(message);
    }
}
