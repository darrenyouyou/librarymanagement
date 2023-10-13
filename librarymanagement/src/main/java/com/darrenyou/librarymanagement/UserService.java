package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    String salt = "N6woWXGs8NFXnfLwe7XtaQ==";

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String phone, String password) {
        User existingUser = userRepository.findByPhone(phone);
        if (existingUser != null) {
            return null;
        }

        String hashedPassword = PasswordHasher.hashPassword(password, salt);

        User user = new User();
        user.setPhone(phone);
        user.setPassword(hashedPassword);
        return userRepository.saveAndFlush(user);
    }

    public User login(String phone, String password) {
        User user = userRepository.findByPhone(phone);
        if (user != null) {
            String hashedPassword = PasswordHasher.hashPassword(password, salt);
            if (user.getPassword().equals(hashedPassword)) {
                return user;
            }
        }
        return null;
    }
}
