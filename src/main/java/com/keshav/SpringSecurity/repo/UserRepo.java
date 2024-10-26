package com.keshav.SpringSecurity.repo;

import com.keshav.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
