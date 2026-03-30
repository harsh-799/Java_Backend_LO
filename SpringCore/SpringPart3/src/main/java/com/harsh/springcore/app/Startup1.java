package com.harsh.springcore.app;

import com.harsh.springcore.config.AppConfig1;
import com.harsh.springcore.config.AppConfig2;
import com.harsh.springcore.config.AppConfig3;
import com.harsh.springcore.model.Car;
import com.harsh.springcore.model.Demo;
import com.harsh.springcore.model.LPUVerto;
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

    public static void injectingRef() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        Car carObj = context.getBean("car1",Car.class);

        // Before injecting the values
        System.out.println(carObj.getEngine()); // ✅ null

        // After injecting concept
        System.out.println(carObj.getEngine()); // ✅ com.harsh.springcore.model.Engine@a514af7

    }

    public static void injectingIntoConstructor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);

        Car car = context.getBean("car",Car.class);
        System.out.println(car.getBrandName() + " " + car.getEngine());

        // OUTPUT
        // Engine bean is created
        // Tata Punch com.harsh.springcore.model.Engine@694abbdc


    }

    public static void injectIntoConstructorStep2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);

        Car car = context.getBean("mybean",Car.class);

        // 🧰 OUTPUT
        // Engine bean is created



    }

    public static void injectingAmbiguitiesIntroToPrimary() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        LPUVerto verto1 = context.getBean("verto", LPUVerto.class);
        verto1.purchaseCourse();

        // 🧰 OUTPUT (WHEN THE springcourse() bean is commented)
        // Java course Bean is created
        // Java Course is purchased
        // Transaction: Success ✅

        // When we uncommented it it raised the exception UnsatisfiedDependencyException: Error creating bean with name 'verto' defined in com.harsh.springcore.config.AppConfig3: Unsatisfied dependency expressed through method 'verto' parameter 0: No qualifying bean of type 'com.harsh.springcore.model.Course' available: expected single matching bean but found 2: javaCourse,springCourse.

        // TO fix that use @Primary Annotation to the bean which should be executed when there's ambiguity condition

        // 🧰 OUTPUT (Nothing is commented now)
        // Spring Course Bean is created
        // Java course Bean is created
        // Spring Course is Purchased
        // Transaction: Success ✅

    }

    public static void injectingAmbiguitiesIntroToQualifier() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        LPUVerto verto2 = context.getBean("verto2", LPUVerto.class);
        verto2.purchaseCourse();

        // 🧰 OUTPUT
        // Spring Course Bean is created
        // Java course Bean is created
        // Spring Course is Purchased
        // Transaction: Success ✅
    }

    public static void main(String[] args) {
        // beanScopes();
        // injectingValues();
        // injectingRef();
        // injectingIntoConstructor();
        // injectIntoConstructorStep2();
        // injectingAmbiguitiesIntroToPrimary();
        injectingAmbiguitiesIntroToQualifier();
    }
}
