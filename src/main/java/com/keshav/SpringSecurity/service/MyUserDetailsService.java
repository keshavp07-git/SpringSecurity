package com.keshav.SpringSecurity.service;

import com.keshav.SpringSecurity.model.UserPrincipal;
import com.keshav.SpringSecurity.model.Users;
import com.keshav.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// This file will process and check is credentials is in DB or Correct
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo ; // Automatically Connect with UserRepo // Step 2
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username); // Finding by Username
        if(user == null) {
            System.out.println("User Not Found"); // It is for console
            throw new UsernameNotFoundException("User Not Found"); // It is for our machine
        }
        return new UserPrincipal(user);
// if We found Username then we want our data but UserDetails is an Interface we can't simply create object
// and get user details , there are 2 Option search for class which implement UserDetails or create class
// so we create class.
    }
}
