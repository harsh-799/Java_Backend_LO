package com.harsh.springcore.model;

public class SpringCourse implements Course{

    public SpringCourse() {
        System.out.println("Spring Course Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Spring Course is Purchased");
        return true;
    }
}
