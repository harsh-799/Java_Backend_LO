package com.harsh.springcore.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 💥 Without this: UnsatisfiedDependencyException: Error creating bean with name 'lpuVerto' defined in file [C:\VS Codes\WorkSpace\Java_Backend_LO\SpringCore\SpringPart4\target\classes\com\harsh\springcore\model\LpuVerto.class]: Unsatisfied dependency expressed through constructor parameter 0: No qualifying bean of type 'com.harsh.springcore.model.Course' available: expected single matching bean but found 2: javaCourse,springCourse
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
