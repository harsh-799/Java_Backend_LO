package com.harsh.springcore.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class JavaCourse implements Course{

    public JavaCourse() {
        System.out.println("Java Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Java course is purchased");
        return true;
    }
}
