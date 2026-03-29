package com.harsh.springcore.app;

import com.harsh.springcore.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LandingPage2 {

    public static void ambiguity() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Student student0 = (Student) context.getBean("stud0");
    }
    public static void main(String[] args) {
        ambiguity();
    }
}
