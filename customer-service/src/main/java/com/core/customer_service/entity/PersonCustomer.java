package com.core.customer_service.entity;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
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
