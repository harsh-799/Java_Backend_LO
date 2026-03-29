package com.harsh.springcore.beforespring.app;

import com.harsh.springcore.beforespring.model.Courses;
import com.harsh.springcore.beforespring.model.JavaCourse;
import com.harsh.springcore.beforespring.model.SpringBootCourse;
import com.harsh.springcore.beforespring.model.Student;

public class Launchapp {
    public static void main(String[] args) {

        //  🌱 First go to Student class then come back here
        Courses javaC = new JavaCourse();
        Student student = new Student(javaC);
        student.buyCourseForEngineering(2700);
        //  🌱 Now the Way 2 is we'll create object here and then we'll pass still the concept of spring is getting unused that it manages all Objects as we need to explictly send it. This is already Dependency Injection (DI) — just done manually.

        // Issue:
        // You are still creating objects manually
        // If implementation changes → you must change code here
        // Courses springBootC = new SpringBootCourse();
        // 👉 This is called tight coupling at object creation level

        // 🚀 So what we want is we want spring to totally handle this object creation and manageement and all, and when an object is created and it's entire lifecycle is managed by spring that object is no more called as object it's called as Beans.

    }
}
