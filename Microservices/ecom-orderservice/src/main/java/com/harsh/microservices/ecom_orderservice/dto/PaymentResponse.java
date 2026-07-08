package com.harsh.microservices.ecom_orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {
    private Boolean success;
    private String transactionId;
}
