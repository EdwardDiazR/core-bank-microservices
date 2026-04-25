package com.core.customer_service.DTOs;

import com.core.customer_service.models.Contact;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

public record CreatePersonCustomerDTO(
        String firstName,
        @Nullable String middleName,
        String lastName,
        @Nullable String secondLastName,
        char gender,
        LocalDate dob,
        Contact contact
        ) {
}
