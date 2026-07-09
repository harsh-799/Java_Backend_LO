package com.harsh.microservices.ecom_paymentservice.exceptions;

public class Payment401Exception extends RuntimeException {
    public Payment401Exception(String message) {
        super(message);
    }
}
