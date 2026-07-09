package com.harsh.microservices.ecom_orderservice.exception;

public class Inventory403Exception extends RuntimeException {
    public Inventory403Exception(String message) {
        super(message);
    }
}
