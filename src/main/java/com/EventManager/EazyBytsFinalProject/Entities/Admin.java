package com.EventManager.EazyBytsFinalProject.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Admins")
public class Admin {
    @Id
    private String username;
    private String password;
    private String email;
    private ArrayList<Events> events;
    private Boolean isloggedin;

    public Boolean getIsloggedin() {
        return isloggedin;
    }

    public void setIsloggedin(Boolean isloggedin) {
        this.isloggedin = isloggedin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Events> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Events> events) {
        this.events = events;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
