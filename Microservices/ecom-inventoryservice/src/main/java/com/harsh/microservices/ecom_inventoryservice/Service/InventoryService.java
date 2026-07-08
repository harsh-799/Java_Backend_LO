package com.harsh.microservices.ecom_inventoryservice.Service;

import com.harsh.microservices.ecom_inventoryservice.dto.InventoryCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public InventoryCheckResponse inventoryStock(int productId) {
        InventoryCheckResponse resp = new InventoryCheckResponse();
        if (productId > 0 && productId < 5) {
            resp.setProductId(5);
            resp.setAvailable(true);
            return resp;
        }

        resp.setProductId(productId);
        resp.setAvailable(false);
        return resp;
    }
}
