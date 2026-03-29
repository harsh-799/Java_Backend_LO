package com.harsh.springcore.beforespring.model;

public class Student {
    Courses course;
    /* Now we can simply assign the courses implementation here like  🌱 Courses course = new Java();
    *  🌱 But that'll be super tightly coupled since for every change we need to explcity change the code from here
    *  🌱 So the inheritance concept is of no use.
    *
    *  🌱 For the Other way see the Student Main method*/

    public Student(Courses course) {
        this.course = course;
    }

    public void buyCourseForEngineering(int amount) {
        if (course.buycourses(amount))
            System.out.println("Transaction: Success ✅");
        else
            System.out.println("Transaction: Failed");
    }
}
