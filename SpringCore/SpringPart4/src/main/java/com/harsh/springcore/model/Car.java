package com.harsh.springcore.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("Car bean is created");
    }
}
