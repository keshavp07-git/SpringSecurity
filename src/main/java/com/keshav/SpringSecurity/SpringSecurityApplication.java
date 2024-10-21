package com.keshav.SpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}

//spring.security.user.name=keshav
//spring.security.user.password=keshav7
//--> by writing like this in application.properties files we can change the username and password
