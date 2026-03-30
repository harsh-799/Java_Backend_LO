package com.harsh.springcore.model;

public class LPUVerto {

    Course course;

    public LPUVerto(Course course) {
        this.course = course;
    }

    public void purchaseCourse() {
        if (course.buyCourse())
            System.out.println("Transaction: Success ✅");
        else
            System.out.println("Transaction: Failed");
    }
}
