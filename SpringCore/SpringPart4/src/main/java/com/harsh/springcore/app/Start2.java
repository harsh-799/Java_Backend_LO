package com.harsh.springcore.app;

import com.harsh.springcore.config.Appconfig1;
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
    public static void main(String[] args) {
        primaryConceptInComponentWay();
    }
}
