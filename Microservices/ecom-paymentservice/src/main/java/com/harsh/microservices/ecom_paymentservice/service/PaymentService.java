package com.harsh.microservices.ecom_paymentservice.service;

import com.harsh.microservices.ecom_paymentservice.dto.PaymentRequestDTO;
import com.harsh.microservices.ecom_paymentservice.dto.PaymentResponseDTO;
import com.harsh.microservices.ecom_paymentservice.exceptions.Payment401Exception;
import com.harsh.microservices.ecom_paymentservice.exceptions.Payment403Exception;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public PaymentResponseDTO processPayments(PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO resp = new PaymentResponseDTO();

        if (paymentRequestDTO.getAmount() == 500) throw new Payment401Exception("");
        if (paymentRequestDTO.getAmount() == 1000) throw new Payment403Exception("");

        resp.setSuccess(paymentRequestDTO.getAmount() > 0 && paymentRequestDTO.getAmount() <= 2000);
        if (resp.getSuccess()) resp.setTransactionId(UUID.randomUUID().toString());

        return resp;
    }
}
