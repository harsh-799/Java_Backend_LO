package com.harsh.springcore.model;

public class SpringBootCourse implements Courses{

    public SpringBootCourse() {
        System.out.println("SpringBoot bean is created ");
    }

    @Override
    public boolean buyCourse(int price) {
        System.out.println("SpringBoot course is purchased at "+price);
        return true;
    }
}
