package com.harsh.springcore.app;

import com.harsh.springcore.config.AppConfig1;
import com.harsh.springcore.model.Car;
import com.harsh.springcore.model.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Startup1 {

    public static void beanScopes() {
        // Here too, We are having scopes
        // 1. Singleton
        // 2. Prototype (Loads only when it's needed)

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        // Before Accessing The bean using the reference
        // 🍀 OUTPUT
        // Car bean is created


        Demo demoObj = context.getBean(Demo.class); // We're not using Any Bean ID to recognize it because there's only One Bean with the Demo.class

        // 🍀 OUTPUT
        // Car bean is created
        // Demo bean is injected

        // 🌈 Now the each time i'll use the Ref that much time it's bean will be created.

        Demo demo1 = context.getBean(Demo.class);
        Demo demo2 = context.getBean(Demo.class);
        Demo demo3 = context.getBean(Demo.class);

        // 🍀 OUTPUT
        // Car bean is created
        // Demo bean is injected
        // Demo bean is injected
        // Demo bean is injected
        // Demo bean is injected

    }

    public static void injectingValues() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        // Now we'll be injecting the value without doing it manually using setter().
        Car car = context.getBean("car",Car.class);
        System.out.println(car.getBrandName());
    }

    public static void main(String[] args) {
        // beanScopes();
        injectingValues();
    }
}
