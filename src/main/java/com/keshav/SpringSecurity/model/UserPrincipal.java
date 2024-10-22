package com.keshav.SpringSecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
// Step 5 implements all method boolean make to true create constructor of Users
// user.getPassword and user.getUserName replace in getPassword and UserName
public class UserPrincipal implements UserDetails {

    private Users user;
    public UserPrincipal(Users user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER")); // It is used to give role to logged in User who is , admin , user , guest etc .
    }

    @Override
    public String getPassword() {
        return user.getPassword(); //This fetch from DB
    }

    @Override
    public String getUsername() {
        return user.getPassword(); // This fetch from DB
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
