package com.harsh.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 👉 Till now you were doing:
// We used to create object by our self and then we tell to spring to manages it:

// @Bean
// public Car car() {
//     return new Car();
// }

// 🔥 But Now with @Component: We tell spring to manages all the stuffs we'll not do anything.

@Configuration
@ComponentScan("com.harsh.springcore")
public class Appconfig {

    // 🧯 We're not gonna create any @Bean here because bean creation will be automatically handle by Spring
}
