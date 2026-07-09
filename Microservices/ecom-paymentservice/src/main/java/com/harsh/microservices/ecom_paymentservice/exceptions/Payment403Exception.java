package com.harsh.microservices.ecom_paymentservice.exceptions;

public class Payment403Exception extends RuntimeException {
    public Payment403Exception(String message) {
        super(message);
    }
}
