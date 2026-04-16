package com.spring.security.basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/labours").permitAll() // This means /labours end point doesn't require auth NOTE: Don't think RequestMatchers means /labour/any endPoint like /labour/hi, /labour/bye will work it explictly mean to /labour
                        .anyRequest().authenticated() // whereas anyRequest other than that needs to be authenticated
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // Since till now we were able to Use the Backend with Single User Now we're declaring more than 1 user.

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
                .withUsername("Kartik")
                .password("{noop}12345")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("Builder")
                .password("{noop}builder")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);

    }
}

/*
💥 What just happened?

You told Spring:
“Don’t apply CSRF protection”
 */