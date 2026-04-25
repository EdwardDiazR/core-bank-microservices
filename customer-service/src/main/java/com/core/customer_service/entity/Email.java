package com.core.customer_service.models;

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
