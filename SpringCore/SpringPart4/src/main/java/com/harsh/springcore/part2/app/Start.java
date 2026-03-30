package com.harsh.springcore.part2.app;


import com.harsh.springcore.part2.model.LpuVerto;
import com.harsh.springcore.part2.config.Appconfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {

    public static void qualifierConceptInComponentWay() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig5.class);

        LpuVerto verto = context.getBean(LpuVerto.class);

        // Java Bean is created
        // Spring Bean is created

        // NOw the question is where to place Qualifier answer is simple:
        // 🧠 What is “injection point”?
        //
        // 👉 Wherever Spring is injecting dependency:
        //
        // constructor
        // setter
        // field

        // 📈 The example we did is inject using Constructor so we defined it in constrcutor
    }

    public static void main(String[] args) {
        qualifierConceptInComponentWay();

    }
}
