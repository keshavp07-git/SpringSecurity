package com.keshav.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
       return "Welcome to Site  " + request.getSession().getId(); // Created this controller and secured by Spring Security Dependencies.
    } // This How we can print session id on localhost page
}
