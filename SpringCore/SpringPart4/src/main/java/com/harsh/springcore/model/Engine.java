package com.harsh.springcore.model;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("Engine bean is created");
    }
}
