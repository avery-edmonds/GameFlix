package com.example.gameflix.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF for Postman testing
                .csrf(AbstractHttpConfigurer::disable)

                // Allow unauthenticated access to these endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().authenticated()
                )

                // Disable form login (optional, since you're using JSON API)
                .formLogin(AbstractHttpConfigurer::disable)

                // Disable HTTP Basic (optional too)
                .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
