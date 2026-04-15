package com.spring.security.basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
🔐 Step 3: First Custom Config (Disable CSRF)

Till now:

👉 Spring Security is auto-configuring everything
👉 You have zero control

Now we take first control
 */

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}

/*
💥 What just happened?

You told Spring:
“Don’t apply CSRF protection”
 */