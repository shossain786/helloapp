package com.saddy.helloapp.service;

import com.saddy.helloapp.exception.DuplicateEmailException;
import com.saddy.helloapp.exception.InvalidUserException;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.model.UserV2;
import com.saddy.helloapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        if (user.getAge() > 100) {
            throw new InvalidUserException("Age must be greater than 100");
        }
        if ("saddam.tech@in.com".equals(user.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }
        return userRepository.save(user);
    }

//    get all users
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }
}
