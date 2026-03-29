package com.harsh.springcore.beforespring.model;

public class SpringBootCourse implements Courses{
    public SpringBootCourse() {
        System.out.println("Spring Boot Course Object is created");
    }

    @Override
    public boolean buycourses(int amount) {
        System.out.println("SpringBoot course is purchased of amount "+ amount);
        return true;
    }
}
