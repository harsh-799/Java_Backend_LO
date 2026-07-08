package com.harsh.microservices.ecom_paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PaymentResponseDTO {
    private Boolean success;
    private String transactionId;
}
