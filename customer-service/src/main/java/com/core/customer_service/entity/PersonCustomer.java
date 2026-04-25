package com.core.customer_service.models;

import jakarta.annotation.Nullable;

import java.time.LocalDate;

public class PersonCustomer extends Customer{


    private String nationalId;
    @Nullable
    private String passport;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastname;
    private LocalDate dob;
    private char gender;
    private int age;
    private boolean isUnderAge;
    private boolean isForeign;
    private boolean isDeceased;
}
