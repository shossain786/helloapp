package com.saddy.helloapp.repository;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByIdAndActiveTrue(Long id);
    Page<UserEntity> findAllByActiveTrue(Pageable pageable);
}
