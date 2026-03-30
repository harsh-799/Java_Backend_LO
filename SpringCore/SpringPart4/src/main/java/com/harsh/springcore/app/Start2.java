package com.harsh.springcore.app;

import com.harsh.springcore.config.Appconfig1;
import com.harsh.springcore.model.Course;
import com.harsh.springcore.model.JavaCourse;
import com.harsh.springcore.model.LpuVerto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start2 {

    public static void primaryConceptInComponentWay() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig1.class);

        LpuVerto varun = context.getBean(LpuVerto.class);
        varun.purchaseCourse();

        // 🧰 OUTPUT
        // Java Bean is created
        // Spring Bean is created (It's created not because of @Primary it's because of Singleton scope that's all bean created at the time of Class loading)
        // Java course is purchased
        // Transaction: Success ✅

        // AFTER CONVERTING IT INTO PROTOTYPE NOW SEE
        // 🧰 OUTPUT
        // Java Bean is created
        // Java course is purchased
        // Transaction: Success ✅

    }

    public static void importantConceptInComponentWay() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig1.class);

        LpuVerto varunPaney = context.getBean(LpuVerto.class);
        varunPaney.purchaseCourse();

        LpuVerto kartik = context.getBean(LpuVerto.class);
        System.out.println(kartik.getCourse()); // ✅ com.harsh.springcore.model.JavaCourse
        // Well i don't think you need to be shocked as we learnt from our Previous concept that for singleton bean only one bean is created and no matter if it's assigned to N references all the N references gonna have same object. SO to get DIff for everyone we need to mark it's scope as prototype

        // After marking it the LpuVerto as Prototype

        LpuVerto harsh = context.getBean(LpuVerto.class);
        System.out.println(harsh.getCourse()); // ✅ com.harsh.springcore.model.JavaCourse
        // WTF How it's again showing getCourse() as the old one it should show null right since by using prototype every bean should be new bean when it's called off. Correct thinking
        // 🧳 But you missed an edge case LpuVerto is new for every ref but what about the bean that's related to course i mean for the JavaCOurses and the SpringCOurse they're still Working as SIngleton so we need to mark them as prototype

        /* SO final OUTPUT After doing all correcttions */

        LpuVerto verto = context.getBean(LpuVerto.class);
        System.out.println(verto.getCourse()); // ❌ UnsatisfiedDependencyException because There are two beans of the same type Courses in container and SPring is confused whom to consider and since we removed primary so it's more tough for it.

        // Wait how it's showing two beans of same type even we marked them as prototype so there should be no bean unless we call it right?

        // ANSWER TO IT:
        // 👉 You are mixing “bean definition” with “bean instance”
        // Spring always knows ALL beans at startup — regardless of scope

        /*
        🧩 What happens at startup

        Spring scans:

        @Component
        public class JavaCourse implements Course {}

        @Component
        public class SpringCourse implements Course {}

        👉 It registers:

        javaCourse → type Course
        springCourse → type Course

        ✔ These are bean definitions (not objects yet)

        ⚡ Important Difference
        | Thing           | Meaning                       |
        | --------------- | ----------------------------- |
        | Bean Definition | Spring knows this bean exists |
        | Bean Instance   | Actual object (`new`)         |

         */


    }
    public static void main(String[] args) {
        // primaryConceptInComponentWay();
        importantConceptInComponentWay();
    }
}
