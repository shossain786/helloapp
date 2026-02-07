package com.saddy.helloapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

public class UserPatchRequest {
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
