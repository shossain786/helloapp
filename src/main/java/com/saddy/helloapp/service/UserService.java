package com.saddy.helloapp.service;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.exception.DuplicateEmailException;
import com.saddy.helloapp.exception.InvalidUserException;
import com.saddy.helloapp.exception.UserNotFoundException;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.model.UserPatchRequest;
import com.saddy.helloapp.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

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

//    day 10: get user by id
    public UserEntity getUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found with id " + id);
        }
        return user.get();
    }

//    Update user
    public UserEntity updateUser(Long id, UserEntity user){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setEmail(user.getEmail());

        return userRepository.save(userEntity);
    }
    public UserEntity patchUser(Long id, UserPatchRequest  userPatchRequest){
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        if (userPatchRequest.getName() != null) {
            user.setName(userPatchRequest.getName());
        }

        if (userPatchRequest.getAge() != null) {
            user.setAge(userPatchRequest.getAge());
        }
        if (userPatchRequest.getEmail() != null) {
            user.setEmail(userPatchRequest.getEmail());
        }

        return userRepository.save(user);
    }

//    get users with pages, sorting
    public Page<UserResponse> getUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        Page<UserEntity> users = userRepository.findAll(pageable);
//        return userRepository.findAll(pageable);
        return  users.map(this::toResponse);

    }

    private UserResponse toResponse(UserEntity userEntity){
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge()
        );
    }

//    get by id with dto control
public UserResponse getUserById14(Long id){
    UserEntity user = userRepository.findById(id).orElseThrow(
            () -> new UserNotFoundException("User not found with id: " + id)
    );

    return toResponse(user);
}
}
