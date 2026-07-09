package com.harsh.microservices.ecom_orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude
@Getter
@Setter
public class OrderRequestDTO {
    private int amount;
}
