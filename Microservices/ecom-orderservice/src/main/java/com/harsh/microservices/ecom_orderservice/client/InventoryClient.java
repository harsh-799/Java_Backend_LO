package com.harsh.microservices.ecom_orderservice.client;

import com.harsh.microservices.ecom_orderservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_orderservice.exception.InventoryServiceUnavailableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class InventoryClient {

    private RestClient restClient;

    public InventoryClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public InventoryCheckResponse checkInventory(int productId) {
        try {
            return restClient
                    .get()
                    .uri("http://localhost:8081/inventory/check/{productId}", productId)
                    .retrieve()
                    .body(InventoryCheckResponse.class);
        } catch (Exception e) {
            throw new InventoryServiceUnavailableException("Inventory Service unavailable");
        }
    }
}
