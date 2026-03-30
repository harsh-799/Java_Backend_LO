package com.harsh.springcore.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringCourse implements Course{

    public SpringCourse() {
        System.out.println("Spring Bean is created");
    }

    @Override
    public boolean buyCourse() {
        System.out.println("Spring Course is purchased");
        return true;
    }
}
