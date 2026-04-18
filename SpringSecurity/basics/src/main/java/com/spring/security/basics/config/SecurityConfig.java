package com.spring.security.basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                        .requestMatchers("/labour").hasRole("ADMIN")
                        .requestMatchers("/labours").permitAll()
                        .requestMatchers("/register","/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/labour/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/labour/**").hasRole("ADMIN") // Means only admin can hit the endPoint /labour with specified HTTP Request Method
                        .anyRequest().authenticated() // We forgot this Means All others route must need authentication to get accessed
                )
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

/*
💥 What just happened?

You told Spring:
“Don’t apply CSRF protection”
 */