package com.harsh.springcore.config;

import com.harsh.springcore.model.Car;
import com.harsh.springcore.model.Demo;
import com.harsh.springcore.model.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig1 {

    @Bean
    public Car car() {
        Car car = new Car();
        car.setBrandName("Tata Punch"); // 🔑 We're injecting into the property here using setter
        return car;
    }

    // ✔️ Since now we need to inject a bean into property so we are creating a bean for it
    @Bean
    public Engine engine() {
        return new Engine();
    }

    @Bean
    public Car car1() {
        Car car = new Car();
        car.setEngine(engine());
        return car;
    }

    /* 🧠 THIS IS EQUIVALENT TO XML
    *
    * <bean id="engine" class="Engine"/>
    * <bean id="car1" class="Car">
    *   <property name="engine" ref="engine"/>
    * </bean>
    * */


    @Bean
    @Scope(value = "prototype") // 🪢 Now to Declare any scope as Prototype we use this
    public Demo demo() {
        return new Demo();
    }
}
