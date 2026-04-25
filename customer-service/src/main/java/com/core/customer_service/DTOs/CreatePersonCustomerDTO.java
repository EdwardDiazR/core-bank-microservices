package com.core.customer_service.DTOs;

import com.core.customer_service.entity.Contact;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

public record CreatePersonCustomerDTO(
        String nationalId,
        @Nullable String passport,
        String firstName,
        @Nullable String middleName,
        String lastName,
        @Nullable String secondLastName,
        char gender,
        String nationality,
        LocalDate dob,
        Contact contact,
        boolean isPEP,
        boolean isUnderAge
        ) {
}
