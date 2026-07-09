package com.harsh.microservices.ecom_orderservice.config.payment;

import com.harsh.microservices.ecom_orderservice.exception.Inventory401Exception;
import com.harsh.microservices.ecom_orderservice.exception.Inventory403Exception;
import com.harsh.microservices.ecom_orderservice.exception.Payment401Exception;
import com.harsh.microservices.ecom_orderservice.exception.Payment403Exception;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PaymentErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        int statusCode = response.status();

        switch (statusCode) {
            case 401:
                return new Payment401Exception("Payment 401 Unauthorized");

            case 403:
                return new Payment403Exception("Payment 403 Forbidden");

            default:
                break;
        }

        return new RuntimeException("Unexpected error Payment");
    }
}
