package com.harsh.springcore.model;

public class JavaCourse implements Courses{

    public JavaCourse() {
        System.out.println("Java bean is created");
    }

    @Override
    public boolean buyCourse(int price) {
        System.out.println("Java course is purchased at "+ price);
        return true;
    }
}
