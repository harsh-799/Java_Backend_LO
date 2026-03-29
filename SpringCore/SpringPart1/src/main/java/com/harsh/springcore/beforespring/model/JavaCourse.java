package com.harsh.springcore.beforespring.model;

public class JavaCourse implements Courses {

    public JavaCourse() {
        System.out.println("Java Course Object is Created");
    }

    @Override
    public boolean buycourses(int amount) {
        System.out.println("Java course is purchased of amount "+ amount);
        return true;
    }
}
