package com.core.customer_service.entity;

import com.core.customer_service.entity.contacts.Address;
import com.core.customer_service.entity.contacts.Email;
import com.core.customer_service.entity.contacts.Phone;

import java.util.List;

public class Contact {

    private List<Address> addresses;
    private List<Email> emails;
    private List<Phone> phones;
}
