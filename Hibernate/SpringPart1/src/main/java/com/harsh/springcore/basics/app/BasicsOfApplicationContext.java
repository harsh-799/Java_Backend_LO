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

    public static void seeingWhenObjectIsCreatedByContainer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 🧑‍🔬 We're not callling any Object By id till now we're just loading the beans.xml at the application startup to just to see when the object is created at the time of Calling by id or at the running of ApplicationContext.

        // ✅ Car object is created..
        // ✅ Engine Object created.

        // 🩹 SO it'll get called when the Application context is init and the number of object created depending upon how many beans is declared over there.

        // 🩹 Even if we repeat two beans with same id it'll be creatiing two times not just one time.
    }
    public static void main(String[] args) {
        // creatingApplicationContext(); 📌 See we' have commented it
        seeingWhenObjectIsCreatedByContainer();
    }
}
