package com.harsh.springcore.part2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LpuVerto {
    Course course;

    @Autowired
    public LpuVerto(@Qualifier("springCourse") Course course) {
        this.course = course;
    }

    public void purchaseCourse() {
        if (course.buyCourse())
            System.out.println("Transaction: Success ✅");
        else
            System.out.println("Transaction: Failed");
    }

    public String getCourse() {
        return course.getClass().getName();
    }
}
