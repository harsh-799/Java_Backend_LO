package com.harsh.springcore.config;

import com.harsh.springcore.model.Car;
import com.harsh.springcore.model.Demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig1 {

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    @Scope(value = "prototype") // 🪢 Now to Declare any scope as Prototype we use this
    public Demo demo() {
        return new Demo();
    }
}
