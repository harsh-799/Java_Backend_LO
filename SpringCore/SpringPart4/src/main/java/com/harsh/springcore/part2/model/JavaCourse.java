package com.harsh.springcore.part2.model;

import org.springframework.stereotype.Component;

@Component
public class JavaCourse implements Course {

    public JavaCourse() {
        System.out.println("Java Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Java course is purchased");
        return true;
    }
}
