package com.harsh.springcore.basics.model;

public class Car {

    String brandName;
    int price;

    public Car() {
        System.out.println("Car object is created..");
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

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", price=" + price +
                '}';
    }
}
