package com.saddy.helloapp.service;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.repository.UserRepositoryV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static com.saddy.helloapp.specification.UserSpecifications.*;

@Service
public class UserServiceV3 {
    UserRepositoryV2 userRepositoryV2;
    public UserServiceV3(UserRepositoryV2 userRepositoryV2) {
        this.userRepositoryV2 = userRepositoryV2;
    }

    public Page<UserResponse> searchUsers(
            String search, int page, int pageSize, String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        Specification<UserEntity> specification = Specification.where(isActive());
        if (search != null &&  !search.isBlank()) {
            specification = specification.and(
                    nameContains(search).or(
                            emailContains(search)
                    )
            );
        }
        Page<UserEntity> userEntityPage = userRepositoryV2.findAll(specification, pageable);

        return userEntityPage.map(this::toResponse);
    }

    private UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge()
        );
    }
}
