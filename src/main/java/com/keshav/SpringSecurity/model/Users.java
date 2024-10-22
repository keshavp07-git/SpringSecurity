package com.keshav.SpringSecurity.model;

// Step 3- This file Users.java will connect UserRepo and UserRepo extends JPA so with this file we will get id , username , password from table from Database ,
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Users {
    @Id
    private int id;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
