package com.EventManager.EazyBytsFinalProject.Controllers;

import com.EventManager.EazyBytsFinalProject.Database.EventsRepository;
import com.EventManager.EazyBytsFinalProject.Entities.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WebpageController {

    @Autowired
    EventsRepository eventsRepository;

    @GetMapping("/homepage")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signuppage";
    }

    @GetMapping("/login")
    public String login(){
        return "loginpage";
    }

    @GetMapping("/usersignup")
    public String  usersignup(){
        return "userSignup";
    }

    @GetMapping("/userlogin")
    public String userlogin(){
        return "Userloginpage";
    }

    @GetMapping("/dashboard/{username}")
    public String dashboard(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        return "admindashboard";
    }

    @GetMapping("/newEvent/{username}")
    public String newEvent(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        return "newAdminEvent";
    }

    @GetMapping("/events/{username}")
    public String events(@PathVariable String username, Model model){
        List<Events> events = eventsRepository.findAll();
        model.addAttribute("events",events);
        model.addAttribute("username",username);
        return "UserEvents";
    }
}
