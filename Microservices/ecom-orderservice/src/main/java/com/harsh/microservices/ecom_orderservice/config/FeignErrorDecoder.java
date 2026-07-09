package com.harsh.microservices.ecom_orderservice.config;

import com.harsh.microservices.ecom_orderservice.exception.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        // return new InventoryServiceUnavailableException("Inventory Service not available intentionally");

    //     We can even implement based on the status code
        if (response.status() == 401 && s.contains("InventoryClient")) return new Inventory401Exception("Not Authorized");
        if (response.status() == 401 && s.contains("PaymentClient")) return new Payment401Exception("Not Authorized For Payment");
        if (response.status() == 403 && s.contains("InventoryClient")) return new Inventory403Exception("Forbidden ho");
        if (response.status() == 403 && s.contains("PaymentClient")) return new Inventory403Exception("Forbidden ho For Payment");

        return new InventoryServiceUnavailableException("Last wala");
    }
}
