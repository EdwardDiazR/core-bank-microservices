package com.core.customer_service.entity.contacts;

import com.core.customer_service.entity.Customer;
import jakarta.persistence.*;

public class Email {

    private String email;
    private boolean isPrincipal;
    private String category;

    @JoinColumn(name = "customer_id")
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Customer customer;
}
