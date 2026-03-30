package com.harsh.springcore.model;

public class Car {
    String brandName;
    Engine engine;

    public Car() {
        System.out.println("Car bean is created");
    }

    // SInce we'll learn now constructor injection so creating parameter constructor for it.
    public Car(String brandName, Engine engine) {
        this.brandName = brandName;
        this.engine = engine;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
