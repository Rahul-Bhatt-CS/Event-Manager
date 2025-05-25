package com.EventManager.EazyBytsFinalProject.Controllers;


import com.EventManager.EazyBytsFinalProject.Database.EventsRepository;
import com.EventManager.EazyBytsFinalProject.Database.MDBRepository;
import com.EventManager.EazyBytsFinalProject.Database.MDBUserRepository;
import com.EventManager.EazyBytsFinalProject.Entities.Admin;
import com.EventManager.EazyBytsFinalProject.Entities.Events;
import com.EventManager.EazyBytsFinalProject.Entities.User;
import com.EventManager.EazyBytsFinalProject.Services.NewAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MainController {
    @Autowired
    private NewAdminService newaAdminService;
    @Autowired
    private MDBRepository repo;
    @Autowired
    private EventsRepository eventrepo;
    @Autowired
    private MDBUserRepository userrepo;

    @PostMapping("/newUser")
    public ResponseEntity<?> addnewuser(@RequestBody User user) {
        List<User> adminOptional = userrepo.findByusername(user.getUsername());

        if(adminOptional.isEmpty()){
            User save = userrepo.save(user);
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.badRequest().body("User Already Exists");
    }

    @GetMapping("/userLogin/{username}/{password}")
    public ResponseEntity<?> loginuser(@PathVariable String username,
                                       @PathVariable String password){
        List<User> users = userrepo.findByusername(username);
        if(users.isEmpty()){
            return ResponseEntity.badRequest().body("User not found.");
        }
        if(Objects.equals(users.getFirst().getPassword(), password)){
            userrepo.save(users.getFirst());
            return ResponseEntity.ok().body("Login Successful");
        }
        return ResponseEntity.badRequest().body("Wrong Password");
    }

    @PostMapping("/newAdmin")
    public ResponseEntity<?> addnewadmin(@RequestBody Admin admin) {
        List<Admin> adminOptional = repo.findByusername(admin.getUsername());

        if(adminOptional.isEmpty()){
            return newaAdminService.savedata(admin, repo);
        }
        return ResponseEntity.badRequest().body("User Already Exists");
    }

    @GetMapping("/adminLogin/{username}/{password}")
    public ResponseEntity<?> loginadmin(@PathVariable String username,
                                       @PathVariable String password){
        List<Admin> admins = repo.findByusername(username);
        if(admins.isEmpty()){
            return ResponseEntity.badRequest().body("User not found.");
        }
        if(Objects.equals(admins.getFirst().getPassword(), password)){
            admins.getFirst().setIsloggedin(true);
            repo.save(admins.getFirst() );
            return ResponseEntity.ok().body("Login Successful");
        }
        return ResponseEntity.badRequest().body("Wrong Password");
    }

    @PostMapping("/api/newEvent/{username}")
    public ResponseEntity<?> savenewEvent(@PathVariable String username,
            @RequestBody Events event){
        List<Admin> admins= repo.findByusername(username);
        if(admins.getFirst().getEvents() != null) {
            admins.getFirst().getEvents().add(event);
            repo.save(admins.getFirst());
        }else{
            ArrayList<Events> newevent = new ArrayList<>();
            newevent.add(event);
            admins.getFirst().setEvents(newevent);
            repo.save(admins.getFirst());
        }
        Events save = eventrepo.save(event);
        return ResponseEntity.ok(save);
    }
}
