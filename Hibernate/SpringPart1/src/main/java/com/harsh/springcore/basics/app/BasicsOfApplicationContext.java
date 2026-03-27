package com.harsh.springcore.basics.app;

import com.harsh.springcore.basics.model.Car;
import com.harsh.springcore.basics.model.Engine;
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

    public static void beanScopeSingleton() {
    /*    📘 2. Scope of Beans (SUPER IMPORTANT)
    - “How many objects Spring will create”

    🔹 1. Singleton (Default) ⭐
    👉 Only ONE object in whole application
    🧠 Meaning
    👉 Spring creates only ONE object and reuses it
     */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Car c0 = (Car) context.getBean("carkiid");
        c0.setBrandName("Maruti");

        Car c1 = (Car) context.getBean("carkiid");
        System.out.println(c0.getBrandName()); // ✅ Maruti
        System.out.println(c1.getBrandName()); // ✅ Maruti (See we didn't even setted the brandName of the c1 object still it's showing as Maruti)

        /* OUTPUT ✅
        Car object is created..
        Maruti
        Maruti

        🧙‍♂️ So Using id named as carkiid only 1 object is created by ApplicationContext It doesn't matter how many Ref assignation/creation to it.
         */

        // Case 2: (Using diff ID)
        Car c2 = (Car) context.getBean("carkiid1");
        System.out.println(c2.getBrandName()); // ✅ null

        /*
         🌙 So Conclusion if we use same ID and we create diff Ref to them then all the ref will be pointing to the same object only.
         🌙 If the Id will be diff then the Ref will be diff
         */
    }

    public static void main(String[] args) {
        // creatingApplicationContext(); 📌 See we' have commented it
        // seeingWhenObjectIsCreatedByContainer();
        // beanScopeSingleton();
    }
}
