package com.saddy.helloapp.repository;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepositoryV2 extends JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity> {
}
