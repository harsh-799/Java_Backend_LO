package com.harsh.microservices.ecom_inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class InventoryCheckResponse {
    private int productId;
    private Boolean available;
}
