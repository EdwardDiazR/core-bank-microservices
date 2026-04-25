package com.core.customer_service.entity;


import com.core.customer_service.enums.CustomerType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    private Long id;
    private CustomerType type;
    private LocalDateTime createdAt;
    private String profileStatus;
    private String riskLevel;
    private Contact contacts;
    private boolean isPEP;
}
