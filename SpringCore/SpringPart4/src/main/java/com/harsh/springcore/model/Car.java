package com.harsh.springcore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

     // 🧨 @Autowired is used to automatically inject a dependency by matching its type with a bean available in the Spring IoC containe
    Engine engine;

    public Car() {
        System.out.println("Car bean is created");
    }

    // Now we gonna inject the engine using the constructor this will help us to inject the value at the time of the Bean creation only as earlier we were injecting it after the bean creation using setters.

    @Autowired
    public Car(Engine engine) {
        System.out.println("Engine bean injected into the Car bean");
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
