package com.harsh.microservices.ecom_orderservice.client;

import com.harsh.microservices.ecom_orderservice.config.payment.PaymentFeignConfig;
import com.harsh.microservices.ecom_orderservice.dto.PaymentRequest;
import com.harsh.microservices.ecom_orderservice.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service", url = "http://localhost:8082/payment", configuration = PaymentFeignConfig.class)
public interface PaymentClient {

    @PostMapping("/process")
    PaymentResponse beginPayment(PaymentRequest paymentRequest);
}
