package com.keshav.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()).
                authorizeHttpRequests(request -> request.anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

    }
    //Step 1- create Custom Authenticator which will be DB . Go to Service.......
    @Bean
    public AuthenticationProvider authenticationProvider (){ // This is an Interface we can't create object so we have to find a class which extends it,
        //DaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider and then AbstractJaasAuthenticationProvider implements AuthenticationProvider
        // Dao used to authenticate from DB.
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // This is used to connect to database.
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // For this branch we are not using any password encoder. In next we will...
        provider.setUserDetailsService(userDetailsService); // we can use default userDetailsService but we will make our own
        // so we have just make a class of userDetailsService because it is an interface,
        return provider;

    }

}

