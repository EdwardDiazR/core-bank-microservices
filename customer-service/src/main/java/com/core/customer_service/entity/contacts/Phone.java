package com.core.customer_service.entity.contacts;

import com.core.customer_service.entity.Customer;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class Phone {

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private String phoneNumber;
    private boolean isPrincipal;
    private String category;

}
