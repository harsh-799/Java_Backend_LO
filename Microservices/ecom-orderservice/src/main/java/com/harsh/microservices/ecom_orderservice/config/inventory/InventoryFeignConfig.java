package com.harsh.microservices.ecom_orderservice.config.inventory;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new InventoryErrorDecoder();
    }

}
