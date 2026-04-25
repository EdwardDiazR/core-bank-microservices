package com.core.customer_service.models;

import jakarta.annotation.Nullable;

import java.time.LocalDate;

public class PersonCustomer extends Customer{


    private String nationalId;

    @Nullable
    private String passport;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastname;
    private LocalDate dob;
    private char gender;
    private boolean isUnderAge;
    private boolean isForeign;


}
