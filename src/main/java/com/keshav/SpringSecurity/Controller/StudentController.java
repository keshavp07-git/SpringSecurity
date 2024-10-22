package com.keshav.SpringSecurity.Controller;

import com.keshav.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
   private List<Student> students = new ArrayList<>(List.of(new Student(
           1, "Keshav",90),
           new Student(2 , "Harsh",80)
   )); // Hard coded values for student's data as database

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students; //give student's data
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    //***** With this method we will get Csrf-Token so that we can put data
    // it will provide token using HttpServletRequest.
    // We will typecast because it return Objects so we have to do it. and Typecast to CsrfToken
    // Then we will hit localhost:8080/csrf-token to get csrf token.
    // and we have to enter that token in X-Csrf-Token in Postman header option.
    // with our post request for saving data for same url which we are hitting to save *****
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
         students.add(student);
         return student; // add student's data
    }
}
