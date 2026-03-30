package com.harsh.springcore.config;

import com.harsh.springcore.model.Car;
import com.harsh.springcore.model.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public Car car() {
        return new Car("Tata Punch",engine());
    }

    /* SImilar to this in XML WAY

    <bean id="engine" class="Engine" />
    <bean id="car" class="Car">
        <constructor-arg name="engine" ref="engine"/>
        <constructor-arg name="brandName" value="Tata Punch"/>
    </bean>
    */

    @Bean
    public Engine engine() {
        return new Engine();
    }
}
