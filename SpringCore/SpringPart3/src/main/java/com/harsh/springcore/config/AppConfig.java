package com.harsh.springcore.config;

import com.harsh.springcore.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks class as config class (replacement of XML file) Means this class will be storing all beans related stuffs just like beans.xml
public class AppConfig {

    @Bean
    public Car car() {
        return new Car();
    }


    @Bean(name = "customName")
    public Car car1() {
        return new Car();
    }

    // 📝 Confused why we created the Object/Bean?
    // In Java-based configuration, we define beans using @Bean methods.
    // The object is created inside the method because Spring needs to know how to instantiate and manage that bean.
    // This method acts like a factory, and the returned object is registered in the Spring container.”

}
