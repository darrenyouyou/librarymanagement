package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @CrossOrigin(origins = "*", exposedHeaders = "Authorization")
    public ResponseEntity<User> registerUser(@RequestParam String phone, @RequestParam String password) {
        User user = userService.registerUser(phone, password);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        String jwtToken = JwtGenerator.generateJwtToken(user.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtToken); // 添加JWT令牌到响应头
        return ResponseEntity.ok().headers(headers).body(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*", exposedHeaders = "Authorization")
    public ResponseEntity<User> loginUser(@RequestParam String phone, @RequestParam String password) {
        User user = userService.login(phone, password);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else {
            String jwtToken = JwtGenerator.generateJwtToken(user.getId());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwtToken); // 添加JWT令牌到响应头
            return ResponseEntity.ok().headers(headers).body(user);
        }
    }
}
