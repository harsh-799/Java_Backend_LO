package com.harsh.microservices.ecom_inventoryservice.Service;

import com.harsh.microservices.ecom_inventoryservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_inventoryservice.exceptions.ExceptionStatus401;
import com.harsh.microservices.ecom_inventoryservice.exceptions.ExceptionStatus403;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public InventoryCheckResponse inventoryStock(int productId) throws InterruptedException {
        InventoryCheckResponse resp = new InventoryCheckResponse();

        // if (true) throw new RuntimeException();
        // Thread.sleep(10000);

        if (productId == 1) throw new ExceptionStatus401("401 ex");
        else if (productId == 2) throw new ExceptionStatus403("403 ex");

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
