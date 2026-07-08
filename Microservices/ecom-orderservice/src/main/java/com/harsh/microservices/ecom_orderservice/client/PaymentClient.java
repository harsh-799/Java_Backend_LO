package com.harsh.microservices.ecom_orderservice.client;

import com.harsh.microservices.ecom_orderservice.dto.PaymentRequest;
import com.harsh.microservices.ecom_orderservice.dto.PaymentResponse;
import com.harsh.microservices.ecom_orderservice.exception.PaymentServiceUnavailableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PaymentClient {

    private RestClient restClient;

    public PaymentClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public PaymentResponse beginPayment(PaymentRequest paymentRequest) {
        try {
            return restClient
                    .post()
                    .uri("http://localhost:8082/payment/process")
                    .body(paymentRequest)
                    .retrieve()
                    .body(PaymentResponse.class);
        } catch (Exception e) {
            throw new PaymentServiceUnavailableException("Payment Service is unavailable");
        }
    }
}
