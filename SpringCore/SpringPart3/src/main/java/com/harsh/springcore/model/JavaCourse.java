package com.harsh.springcore.model;

public class JavaCourse implements Course{

    public JavaCourse() {
        System.out.println("Java course Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Java Course is purchased");
        return true;
    }
}
