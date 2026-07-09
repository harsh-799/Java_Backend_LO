package com.harsh.microservices.ecom_orderservice.config.payment;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFeignConfig {

    @Bean
    public ErrorDecoder paymentErrorDecoder() {
        return new PaymentErrorDecoder();
    }
}
