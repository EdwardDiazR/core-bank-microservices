package com.core.customer_service.models;


import com.core.customer_service.enums.CustomerType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    private Long id;
    private CustomerType type;
    private LocalDateTime createdAt;
    private String status;
    private String riskLevel;
    private Contact contacts;
    private boolean isPEP;
}
