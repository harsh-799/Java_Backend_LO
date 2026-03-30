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
    public static void main(String[] args) {
        beanCreationUsingComponent();

    }
}
