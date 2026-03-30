package com.harsh.springcore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    Engine engine;

    public Car() {
        System.out.println("Car bean is created");
    }

    public Engine getEngine() {
        return engine;
    }


    // THis is the example of AutoWiring Using Setters
    // “Spring will call the setter method and pass the required dependency
    // 🔥 What Spring Does Internally
    // Spring runs something like this:
    // Car car = new Car();
    // car.setEngine(engine);

    // 🔁 Exact XML Equivalent
    // <bean id="car" class="Car">
    //     <property name="engine" ref="engine"/>
    // </bean>
    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // New concept:
    // Autowiring can be done in three ways:
    // 1️⃣. Injecting into fields
    // 2️⃣. Injecting into the constructor
    // 3️⃣. Injecting using the setter (The XML one is equivalent to this)

    // 🧽 FOR THE 1️⃣ One
    // As in XML one first the bean used to be created and then setter method used to be invoked to inject the value/bean but that's not the case here For 1️⃣ one here it directly injects the value without calling the setter.

    // 🧽 The XML one is same as here Way 3️⃣

}
