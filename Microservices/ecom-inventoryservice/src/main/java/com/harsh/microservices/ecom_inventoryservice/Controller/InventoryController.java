package com.harsh.microservices.ecom_inventoryservice.Controller;

import com.harsh.microservices.ecom_inventoryservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_inventoryservice.Service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/check/{productId}")
    public ResponseEntity<InventoryCheckResponse> checkInventory(@PathVariable int productId) throws InterruptedException {
        InventoryCheckResponse resp = inventoryService.inventoryStock(productId);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}

