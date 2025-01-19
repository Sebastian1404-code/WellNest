package com.example.PoliHack.controller;

import com.example.PoliHack.model.user.User;
import com.example.PoliHack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public boolean loginUser(@RequestBody User user) {
        return userService.authenticateUser(user.getNickname(), user.getPassword());
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/register")
    public boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
