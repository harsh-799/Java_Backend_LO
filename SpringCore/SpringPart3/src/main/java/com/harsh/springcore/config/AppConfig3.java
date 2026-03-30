package com.harsh.springcore.config;

import com.harsh.springcore.model.Course;
import com.harsh.springcore.model.JavaCourse;
import com.harsh.springcore.model.LPUVerto;
import com.harsh.springcore.model.SpringCourse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig3 {

    @Bean
    public LPUVerto verto(Course course) { // 📈 Now the Step2 which we learn earlier, Now here's a catch now tell me how this course will know that it should call to which bean as both mean is of type Course only so it'll be ambiguity case
        return new LPUVerto(course);
    }

    @Bean
    public JavaCourse javaCourse() {
        return new JavaCourse();
    }

    @Bean
    @Primary
    public SpringCourse springCourse() {
        return new SpringCourse();
    }
}
