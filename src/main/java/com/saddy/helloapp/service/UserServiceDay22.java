package com.saddy.helloapp.service;

import com.saddy.helloapp.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceDay22 {
    private final AuditService auditService;

    public UserServiceDay22(AuditService auditService){
        this.auditService = auditService;
    }

    @Transactional
    public void outer() {
        System.out.println("outer");
        auditService.inner();
    }

    public void createUser(UserEntity user){
        // userRepository.save(user);      // Transaction A
        auditService.saveAudit(); // // Transaction B (REQUIRES_NEW)
    }
}


/*
    saveAudit() fails

    - Audit transaction rolls back

    - User transaction still commits

    ✔ Two independent transactions

 */