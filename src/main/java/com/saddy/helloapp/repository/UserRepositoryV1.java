package com.saddy.helloapp.repository;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryV1 extends JpaRepository<UserEntity,Long> {
    Page<UserEntity> findAllByActiveTrue(Pageable pageable);
    Page<UserEntity> findByActiveTrueAndNameContainingIgnoreCaseOrActiveTrueAndEmailContainingIgnoreCase(
            String name,
            String email,
            Pageable pageable
    );
}
