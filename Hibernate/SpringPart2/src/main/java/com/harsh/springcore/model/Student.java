package com.harsh.springcore.model;

public class Student {
    Courses courses;

    public Student() {
        System.out.println("Student bean is created");
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public void purchaseCourse(int price) {
        boolean status = courses.buyCourse(price);

         if (status)
             System.out.println("Transaction Success");
         else
             System.out.println("Transaction Failed");
    }
}
