package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        return userRepository.saveAndFlush(user);
    }
}
