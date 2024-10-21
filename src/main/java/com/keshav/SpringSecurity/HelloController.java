package com.keshav.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(){
       return "Welcome to Site"; // Created this controller and secured by Spring Security Dependencies.
    }
}
