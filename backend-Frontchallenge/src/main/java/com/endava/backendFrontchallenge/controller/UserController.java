package com.endava.backendFrontchallenge.controller;

import com.endava.backendFrontchallenge.model.User;
import com.endava.backendFrontchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") String id) {
        Optional user = userService.findById(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @PostMapping("/save/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/login/{email}/users/{password}")
    public User findByEmail(@PathVariable("email") String email,@PathVariable("password") String password) {
        Optional user = userService.findByName(email,password);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
}
