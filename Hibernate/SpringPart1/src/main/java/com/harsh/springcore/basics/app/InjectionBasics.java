package com.harsh.springcore.basics.app;

import com.harsh.springcore.basics.model.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionBasics {

    public static void injectingValue() {
    //     Now suppose if we want to add some values inside the engine property for eg engineName.
    //     The normal way is to initialized the value inside the class itself String engineName  = "bmwMotors";
    //     Another way get the created object from Spring and then use setters to set the value.
    //     🛑 Now Drawbacks in case 2 is: All Engine object will have same engine i.e bmwMotors
    //     🛑 And Drawback in case 3 is: Suppose if we know the engineName at the time creation and we wanna to set at there itself instead of adding it manually after getting the object.

        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");

        Engine eng1 = (Engine) context.getBean("engine1");
        System.out.println(eng1.getEngineName()); // BMW Motors (If value is not setted then it would have returned NULL but here it's not returning that means value setted successfully)

        Engine eng2 = (Engine) context.getBean("engine2");
        System.out.println(eng2.getEngineName()); // JCB Automotive

        /* All Output
        Engine Object created.
        Engine Setter Called
        Engine Object created.
        Engine Setter Called
        BMW Motors
        JCB Automotive

        Means this injecting value internally calls the setter taht's why setter is getting called.
         */
    }
    public static void main(String[] args) {
        injectingValue();
    }
}
