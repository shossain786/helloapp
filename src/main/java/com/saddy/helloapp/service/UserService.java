package com.saddy.helloapp.service;

import com.saddy.helloapp.exception.DuplicateEmailException;
import com.saddy.helloapp.exception.InvalidUserException;
import com.saddy.helloapp.model.UserV2;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void createUser(UserV2 user){
        String existingEmail = "saddam.tech@in.com";

        if (user.getAge() > 100) {
            throw new InvalidUserException("Age must be greater than 100");
        }
        if (existingEmail.equals(user.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }
    }
}
