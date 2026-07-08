package com.harsh.microservices.ecom_orderservice.service;

import com.harsh.microservices.ecom_orderservice.client.InventoryClient;
import com.harsh.microservices.ecom_orderservice.client.PaymentClient;
import com.harsh.microservices.ecom_orderservice.dto.InventoryCheckResponse;
import com.harsh.microservices.ecom_orderservice.dto.OrderResponse;
import com.harsh.microservices.ecom_orderservice.dto.PaymentRequest;
import com.harsh.microservices.ecom_orderservice.dto.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private InventoryClient inventoryClient;
    private PaymentClient paymentClient;

    public OrderService(InventoryClient inventoryClient, PaymentClient paymentClient) {
        this.inventoryClient = inventoryClient;
        this.paymentClient = paymentClient;
    }

    public OrderResponse placeOrder(int id) {
        OrderResponse response = new OrderResponse();
        InventoryCheckResponse resp = inventoryClient.checkInventory(id);

        if (resp.getAvailable()) {
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setAmount(1500);
            PaymentResponse paymentResponse = paymentClient.beginPayment(paymentRequest);

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
