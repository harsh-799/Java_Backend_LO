package com.harsh.microservices.ecom_orderservice.config.inventory;

import com.harsh.microservices.ecom_orderservice.exception.Inventory401Exception;
import com.harsh.microservices.ecom_orderservice.exception.Inventory403Exception;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        int statusCode = response.status();

        switch (statusCode) {
            case 401:
                return new Inventory401Exception("Inventory 401 Unauthorized");

            case 403:
                return new Inventory403Exception("Inventory 403 Forbidden");

            default:
                break;
        }

        return new RuntimeException("Unexpected error");
    }
}
