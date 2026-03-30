package com.harsh.springcore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired // 🧨 @Autowired is used to automatically inject a dependency by matching its type with a bean available in the Spring IoC containe
    Engine engine;

    public Car() {
        System.out.println("Car bean is created");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
