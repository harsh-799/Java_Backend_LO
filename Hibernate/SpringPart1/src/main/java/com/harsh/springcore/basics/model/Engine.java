package com.harsh.springcore.basics.model;

public class Engine {

    String engineName;
    int hp;

    public Engine() {
        System.out.println("Engine Object created.");
    }

    public Engine(String engineName, int hp){
        System.out.println("Engine Para constructor called");
        this.engineName = engineName;
        this.hp = hp;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        System.out.println("Engine Setter Called");
        this.engineName = engineName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineName='" + engineName + '\'' +
                '}';
    }
}
