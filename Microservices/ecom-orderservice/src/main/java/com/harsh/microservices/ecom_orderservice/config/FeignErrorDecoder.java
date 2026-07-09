package com.harsh.microservices.ecom_orderservice.config;

import com.harsh.microservices.ecom_orderservice.exception.Inventory401Exception;
import com.harsh.microservices.ecom_orderservice.exception.Inventory403Exception;
import com.harsh.microservices.ecom_orderservice.exception.InventoryServiceUnavailableException;
import com.harsh.microservices.ecom_orderservice.exception.PaymentServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        // return new InventoryServiceUnavailableException("Inventory Service not available intentionally");

    //     We can even implement based on the status code
        if (response.status() == 401) return new Inventory401Exception("Not Authorized");
        if (response.status() == 403) return new Inventory403Exception("Forbidden ho");

        return new InventoryServiceUnavailableException("Last wala");
    }
}
