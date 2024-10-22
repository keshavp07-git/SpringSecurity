package com.keshav.SpringSecurity.repo;

import com.keshav.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username); //using DSL
}
// Step -4 And UserRepo extends Users.java it means it will connect to database and search for credentials in DB