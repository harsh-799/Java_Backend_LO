package com.harsh.springcore.part2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LpuVerto {
    Course course;

    @Value("LPU VERTO") // We can set the value like we used to do in XML but remember this won't trigger the setter related stuffs.
    String vertoName;

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

    public String getVertoName() {
        return vertoName;
    }

    public void setVertoName(String vertoName) {
        this.vertoName = vertoName;
    }
}
