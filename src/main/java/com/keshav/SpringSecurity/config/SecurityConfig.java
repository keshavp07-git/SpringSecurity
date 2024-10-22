package com.keshav.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //This enables custom config
@EnableWebSecurity // This enable Web Security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()). // Disable csrf Token
                authorizeHttpRequests(request -> request.anyRequest().authenticated()). // Authentication Purpose
                httpBasic(Customizer.withDefaults()). // Allow Application to Test in Postman,
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
        // This enables us to work without CSRF Token This make http STATELESS so everytime new session ID Generated.


    }
}