package com.harsh.springcore.model;

public class Engine {

    String engineBrand;

    public Engine() {
        System.out.println("Engine bean is created");
    }

    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }



}
