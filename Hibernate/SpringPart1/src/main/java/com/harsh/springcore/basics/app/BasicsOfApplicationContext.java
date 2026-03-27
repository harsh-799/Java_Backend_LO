package com.harsh.springcore.basics.app;

import com.harsh.springcore.basics.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicsOfApplicationContext {

    public static void creatingApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // Car carObj = context.getBean("carkiid"); // 🧾 getBean() retuns object type so we need tio type cast it.
        Car carObj = (Car) context.getBean("carkiid");
        carObj.setBrandName("Toyata");
        carObj.setPrice(10000);

        System.out.println(carObj); // ✅ Car{brandName='Toyata', price=10000}
    }
    public static void main(String[] args) {
        creatingApplicationContext();
    }
}
