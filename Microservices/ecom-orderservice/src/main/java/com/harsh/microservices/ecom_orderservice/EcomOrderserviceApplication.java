package com.harsh.microservices.ecom_orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcomOrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomOrderserviceApplication.class, args);
	}

}
