package com.harsh.springcore.model;

public class Student {
    Courses courses;

    // public Student() {
    //     System.out.println("Student bean is created");
    // }
    // Need to comment this otherwise ambiguity case was not happening because instead of parameterized constructor it was referring to this non constrcutor parameterised constrcutor.

    public Student(Courses courses) {
        System.out.println("Injected inside Student bean");
        this.courses = courses;
    }

    // Remember no use of setter in this case beacuse we'll be using COnstructor injection.

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
