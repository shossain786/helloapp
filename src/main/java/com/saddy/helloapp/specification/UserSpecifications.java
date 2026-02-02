package com.saddy.helloapp.specification;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<UserEntity> isActive() {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get("active")));
    }

    public static Specification<UserEntity> nameContains(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<UserEntity> emailContains(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email + "%");
    }
}
