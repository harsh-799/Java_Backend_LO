package com.harsh.springcore.part2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SpringCourse implements Course {

    public SpringCourse() {
        System.out.println("Spring Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Spring Course is purchased");
        return true;
    }
}
