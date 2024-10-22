package com.keshav.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public UserDetailsService userDetailsService(){ // We can simply return the Object and our Job can be done but
        // Due to this is interface we cant do that but returning
        // which implements UserDetailsService job will be done because
        // InMemoryUserDetailsManager is a class so we return object of it.
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("abc")
                .password("a123")
                .roles("USER")
                .build();

        // We are able to create the object and store into these variable user1 and user 2 because InMemoryUserDetailsManager  implements UserDetails and it extends
        //UserDetailsService.

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("def")
                .password("b123")
                .roles("ADMIN")
                .build();

    return new InMemoryUserDetailsManager(user1,user2); // Here we pass varagrs because everything in those variable
    }
}

