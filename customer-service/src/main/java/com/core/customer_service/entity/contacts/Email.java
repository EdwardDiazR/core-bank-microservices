package com.core.customer_service.entity.contacts;

import com.core.customer_service.entity.Customer;
import jakarta.persistence.*;

public class Email {

    private String email;
    private boolean isPrincipal;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
