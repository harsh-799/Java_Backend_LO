package com.harsh.springcore.app;

import com.harsh.springcore.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LandingPage2 {

    public static void ambiguity() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Student student0 = (Student) context.getBean("stud0");
    }

    public static void autowiringUsingConstructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1a.xml");
        Student student1 = (Student) context.getBean("stud1");
        // OUTPUT
        // SpringBoot bean is created
        // Injected inside Student bean

    }

    public static void lazyInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

    }
    public static void main(String[] args) {
        // ambiguity();
        // autowiringUsingConstructor();
        lazyInit();
    }
}
