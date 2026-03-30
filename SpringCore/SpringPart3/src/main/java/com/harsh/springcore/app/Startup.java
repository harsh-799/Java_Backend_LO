package com.harsh.springcore.app;

import com.harsh.springcore.config.AppConfig;
import com.harsh.springcore.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Startup {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Car car = context.getBean(Car.class); // Here we're getting w/o the ID so the bean will be found like Spring will go to the AppCOnfig.class and search for bean which is related to Car Type if it's there it'll return that bean to here.

        // ⚠️ NOTE: In the AppConfig.class there must be only single bean of this type otherwise spring will confuse and it'll raise ambiguity

        // 2️⃣. FInding Bean Using Bean Default Nmae
        Car car1 = context.getBean("car",Car.class); // Imp Learning: By Default the name of the matter is the default name of the bean.

        car1.setBrandName("Tata");
        System.out.println(car1.getBrandName()); // Tata

        // 3️⃣. Providing custom Name to the bean
        Car car2 = context.getBean("customName",Car.class);
        System.out.println(car2.getBrandName()); // null (Because we haven't setted the value for this bean)

    }
}
