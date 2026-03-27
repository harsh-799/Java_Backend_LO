package com.harsh.springcore.basics.model;

public class Engine {

    String engineName;

    public Engine() {
        System.out.println("Engine Object created.");
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineName='" + engineName + '\'' +
                '}';
    }

}
