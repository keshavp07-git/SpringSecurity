package com.keshav.SpringSecurity.service;

import com.keshav.SpringSecurity.model.Users;
import com.keshav.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// To register user in DB (Service)
@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public Users register(Users user){
        return repo.save(user);
    }

}
