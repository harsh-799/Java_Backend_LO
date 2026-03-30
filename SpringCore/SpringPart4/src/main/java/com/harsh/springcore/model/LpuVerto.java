package com.harsh.springcore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LpuVerto {
    Course course;

    @Autowired // 🦸‍♂️ Now this will get confused which bean to inject since in container there are two beans of same type course: Java Bean and Spring Bean. SO here is ambiguity so to overcome this we have used @Primary
    // 📞 Now in XML/JC Way we used to Primary concept similary here also we gonna use @Primary to the those class which we want to be Primary bean in case of ambiguities.
    public LpuVerto(Course course) {
        this.course = course;
    }

    public void purchaseCourse() {
        if (course.buyCourse())
            System.out.println("Transaction: Success ✅");
        else
            System.out.println("Transaction: Failed");
    }
}
