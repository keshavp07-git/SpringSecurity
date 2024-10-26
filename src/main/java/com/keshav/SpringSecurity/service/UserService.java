package com.keshav.SpringSecurity.service;

import com.keshav.SpringSecurity.model.Users;
import com.keshav.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
// To register user in DB (Service)
@Service
public class UserService {
    @Autowired
    // Step-1 To BYcrpt the password
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ; // Strength is round , how many times our hash will be converts
    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword())); // User when giving password take the password encrypt it and set iy.
        return repo.save(user); // To the User
    }

}
