package com.harsh.microservices.ecom_paymentservice.controllers;

import com.harsh.microservices.ecom_paymentservice.dto.PaymentRequestDTO;
import com.harsh.microservices.ecom_paymentservice.dto.PaymentResponseDTO;
import com.harsh.microservices.ecom_paymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> handlePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.processPayments(paymentRequestDTO));
    }
}
