package com.harsh.springcore.config;

import com.harsh.springcore.model.Course;
import com.harsh.springcore.model.JavaCourse;
import com.harsh.springcore.model.LPUVerto;
import com.harsh.springcore.model.SpringCourse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig3 {

    // @Bean
    public LPUVerto verto(Course course) { // 📈 Now the Step2 which we learn earlier, Now here's a catch now tell me how this course will know that it should call to which bean as both mean is of type Course only so it'll be ambiguity case
        return new LPUVerto(course);
    }

    // 👑 Now the next concept is @Qualifier we use this basically when we want to specifically inject some beans like in XML
    @Bean
    public LPUVerto verto2(@Qualifier("javaCourse") Course course) {
        return new LPUVerto(course);
    }

    /* IN XML It's equiavalent to
    <bean id="javaCourse" class="JavaCourse"/>
    <bean id="springCourse" class="SpringCourse"/>

    <bean id="verto1" class="LPUVerto">
        <constructor-arg ref="springCourse"/>
    </bean>

    💬 So it;s basically
    @Qualifier is used to explicitly tell Spring which specific bean to inject when multiple beans of the same type are available.
     */

    @Bean
    public JavaCourse javaCourse() {
        return new JavaCourse();
    }

    @Bean
    public SpringCourse springCourse() {
        return new SpringCourse();
    }
}
