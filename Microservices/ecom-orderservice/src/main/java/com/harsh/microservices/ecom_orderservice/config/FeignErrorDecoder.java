package com.harsh.microservices.ecom_orderservice.config;

import com.harsh.microservices.ecom_orderservice.exception.InventoryServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        return new InventoryServiceUnavailableException("Inventory Service not available intentionally");

    }
}
