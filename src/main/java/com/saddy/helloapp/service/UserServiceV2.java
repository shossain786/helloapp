package com.saddy.helloapp.service;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.repository.UserRepositoryV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV2 {
    UserRepositoryV1 userRepositoryV1;

    public UserServiceV2(UserRepositoryV1 userRepositoryV1) {
        this.userRepositoryV1 = userRepositoryV1;
    }


    public Page<UserResponse> searchUser(String search, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<UserEntity> users;
        if (search == null || search.isBlank()) {
            users = userRepositoryV1.findAllByActiveTrue(pageable);
        } else {
            users = userRepositoryV1.findByActiveTrueAndNameContainingIgnoreCaseOrActiveTrueAndEmailContainingIgnoreCase(
                    search,
                    search,
                    pageable
            );
        }
        return users.map(this::toResponse);
    }

    private UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge()
        );
    }
}
