package com.harsh.microservices.ecom_orderservice.exception;

public class Inventory401Exception extends RuntimeException {
    public Inventory401Exception(String message) {
        super(message);
    }
}
