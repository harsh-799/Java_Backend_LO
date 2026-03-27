package com.harsh.springcore.basics.model;

public class Car {

    String brandName;
    int price;

    Engine engine;

    public Car() {
        System.out.println("Car object is created..");
    }

    public Car(String brandName, int price, Engine engine) {
        this.brandName = brandName;
        this.price = price;
        this.engine = engine;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }
}
