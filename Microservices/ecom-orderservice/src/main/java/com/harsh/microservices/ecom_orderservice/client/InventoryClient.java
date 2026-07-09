package com.harsh.microservices.ecom_orderservice.client;

import com.harsh.microservices.ecom_orderservice.config.inventory.InventoryFeignConfig;
import com.harsh.microservices.ecom_orderservice.dto.InventoryCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8081/inventory", configuration = InventoryFeignConfig.class)
public interface InventoryClient {

    @GetMapping("/check/{id}")
    InventoryCheckResponse checkInventory(@PathVariable int id);

    @GetMapping("/token")
    String checkToken();

}
