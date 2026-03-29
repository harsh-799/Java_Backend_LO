package com.harsh.springcore.app;

import com.harsh.springcore.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LandingPage {

    public static void earlierWayUsingProperty() {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans0.xml");
       Student student0 = (Student) context.getBean("student0");
       student0.purchaseCourse(5000);

       /* 🗂️ OUTPUT
       * Java bean is created
       * Student bean is created
       * Java course is purchased at 5000
       * Transaction Success
       */
    }

    public static void earlierWayUsingConstructor() {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
       Student student1 = (Student) context.getBean("student1");
       student1.purchaseCourse(3000);

       /* 🗂️ OUTPUT
       * SpringBoot bean is created
       * Injected inside Student bean
       * SpringBoot course is purchased at 3000
       * Transaction Success
        */

    }

    public static void main(String[] args) {
        // earlierWayUsingProperty();
        earlierWayUsingConstructor();
    }
}
