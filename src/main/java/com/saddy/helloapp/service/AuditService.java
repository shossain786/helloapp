package com.saddy.helloapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAudit() {
        System.out.println("saveAudit");
        if(true) {
            throw new RuntimeException("saveAudit");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void inner() {
        System.out.println("inner");
    }
}
