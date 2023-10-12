package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<User> registerUser(@RequestParam String phone, @RequestParam String password) {
        User newUser = userService.registerUser(phone, password);
        return ResponseEntity.ok(newUser);
    }
}
