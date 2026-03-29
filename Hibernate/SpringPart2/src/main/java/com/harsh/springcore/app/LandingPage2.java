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

    public static void getbeanNewLearning() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        // Earlier we need to expicitly do the type conversion, but getBean() have many overrrided methods
        // Student student = (Student) context.getBean("Student"); // Earlier way

        //🔥 Types of getBean() Methods

        // ✅ 1. getBean(String name) (Doiing till now the above one)

        // ✅ 2. getBean(String name, Class<T> requiredType)
        Student student1 = context.getBean("stud",Student.class);

        // Student bean is created
        // Student bean is created

        // ✅ 3. getBean(Class<T> requiredType)
        Student student2 = context.getBean(Student.class);
        // it'll go to the XML file and look for the bean which belngs to the Student.class make sure you have single bean otherwise Ambiguity case.
    }

    public static void innerBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        Student student3 = context.getBean("stud", Student.class);
        student3.purchaseCourse(5000);

        /*
        Java bean is created
        Injected inside Student bean
        Java course is purchased at 5000
        Transaction Success
         */

    }
    public static void main(String[] args) {
        // ambiguity();
        // autowiringUsingConstructor();
        // lazyInit();
        // getbeanNewLearning();
        innerBean();
    }
}
