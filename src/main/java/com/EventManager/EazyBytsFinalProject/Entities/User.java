package com.EventManager.EazyBytsFinalProject.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Users")
public class User {
    private String username;
    private String Password;
    private String email;
    private ArrayList<Events> register_Events;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Events> getRegister_Events() {
        return register_Events;
    }

    public void setRegister_Events(ArrayList<Events> register_Events) {
        this.register_Events = register_Events;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
