package com.harsh.springcore.app;

import com.harsh.springcore.config.Appconfig;
import com.harsh.springcore.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {

    public static void beanCreationUsingComponent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        // 🧰 OUTPUT
        // Car bean is created

        // Now to make Spring handle any class object we need to mark that class using 🗣️ @Component
        // ❓ But How Will Spring Find It?
        // So for that we need to mark @ComponentScan(package name)
        // this means: Spring, go inside this package and find all @Component classes”

        /* 🔁 Compare with Old Way
        | Old (`@Bean`)     | New (`@Component`)    |
        | ----------------- | --------------------- |
        | You create object | Spring creates object |
        | Manual config     | Automatic scanning    |
        | More control      | Less code             |

         */
    }

    public static void autowiringConceptInComponentWay() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        // 🧰 OUTPUT
        // Car bean is created
        // Engine bean is created

        Car car = context.getBean(Car.class);
        System.out.println(car.getEngine()); // ✅   null

        // Confused why? As We can see in output the bean is created still why it's still showing as Null.
        // Reason is simple: Even if there is bean created in the container but the Car really knows that there's bean inside container of engine type and link me to that.
        // SO there's issue in linking connection so for that just use 🗣️ @Autowired

        // 🧠 One-Line Truth
        // Beans existing ≠ Beans connected
        // @Autowired = connection

        System.out.println(car.getEngine()); // ✅ com.harsh.springcore.model.Engine@5bfa9431

    }

    public static void autowiringInConsructor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        // 🧰  OUTPUT
        // Engine bean is created
        // Engine bean injected into the Car bean
    }

    public static void autowiringInSetters() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);



    }


    public static void main(String[] args) {
        // beanCreationUsingComponent();
        // autowiringConceptInComponentWay();
        autowiringInConsructor();

    }
}
