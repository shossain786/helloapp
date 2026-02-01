package com.saddy.helloapp.repository;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryV1 extends JpaRepository<UserEntity,Long> {
    Page<UserEntity> findAllByActiveTrue(Pageable pageable);
    Page<UserEntity> findByActiveTrueAndNameContainingIgnoreCaseOrActiveTrueAndEmailContainingIgnoreCase(
            String name,
            String email,
            Pageable pageable
    );

    @Query(
    """
        SELECT u FROM UserEntity u
                WHERE u.active = true
                  AND (
                    :search IS NULL
                    OR LOWER(u.name) LIKE LOWER(CONCAT('%', :search, '%'))
                    OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%'))
                  )
    """
    )
    Page<UserEntity> searchActiveUsers(@Param("search") String search, Pageable pageable);
}
