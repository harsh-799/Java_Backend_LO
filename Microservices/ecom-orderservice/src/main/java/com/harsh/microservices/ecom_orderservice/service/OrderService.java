package com.harsh.microservices.ecom_orderservice.service;

import com.harsh.microservices.ecom_orderservice.client.InventoryClient;
import com.harsh.microservices.ecom_orderservice.client.PaymentClient;
import com.harsh.microservices.ecom_orderservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_orderservice.dto.OrderResponse;
import com.harsh.microservices.ecom_orderservice.dto.PaymentRequest;
import com.harsh.microservices.ecom_orderservice.dto.PaymentResponse;
import com.harsh.microservices.ecom_orderservice.exception.InventoryServiceUnavailableException;
import com.harsh.microservices.ecom_orderservice.exception.PaymentServiceUnavailableException;
import feign.RetryableException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final InventoryClient inventoryClient;
    private final PaymentClient paymentClient;

    public OrderService(InventoryClient inventoryClient, PaymentClient paymentClient) {
        this.inventoryClient = inventoryClient;
        this.paymentClient = paymentClient;
    }

    public OrderResponse placeOrder(int id) {
        OrderResponse response = new OrderResponse();
        InventoryCheckResponse resp = null;
        try {
            resp = inventoryClient.checkInventory(id);
        } catch (RetryableException e) {
            throw new InventoryServiceUnavailableException("Inventory service is currently unavailable.");
        }

        if (resp.getAvailable()) {
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setAmount(1500);
            PaymentResponse paymentResponse = null;
            try {
                paymentResponse = paymentClient.beginPayment(paymentRequest);
            } catch (RetryableException e) {
                throw new PaymentServiceUnavailableException("Payment service is currently unavailable.");
            }

            if (paymentResponse.getSuccess()) {
                response.setStatus(true);
                response.setMessage("Order placed successfully");
            }
        } else {
            response.setStatus(false);
            response.setMessage("OUT OF STOCK!");
        }

        return response;
    }
}
