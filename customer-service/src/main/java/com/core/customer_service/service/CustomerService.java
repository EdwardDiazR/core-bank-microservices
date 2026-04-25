package com.core.customer_service.service;

import com.core.customer_service.DTOs.CreatePersonCustomerDTO;
import com.core.customer_service.entity.Customer;
import com.core.customer_service.entity.PersonCustomer;
import com.core.customer_service.enums.CustomerType;
import com.core.customer_service.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    public CustomerService() {
    }

    public PersonCustomer createPersonCustomer(CreatePersonCustomerDTO customerDto) {

        LocalDateTime now = LocalDateTime.now();

        String firstName = toUpper(customerDto.firstName());
        String middleName = toUpper(customerDto.middleName() != null ? customerDto.middleName() : "");
        String lastName = toUpper(customerDto.lastName());
        String secondLastName = toUpper(customerDto.secondLastName() != null ? customerDto.secondLastName() : "");

        assert customerDto.passport() != null;

        return PersonCustomer.builder()
                .type(CustomerType.PERSON)
                .nationalId(customerDto.nationalId())
                .passport(!customerDto.passport().isEmpty() ? toUpper(customerDto.passport()) : "")
                .firstName(firstName)
                .middleName(middleName)
                .secondLastname(secondLastName)
                .gender(customerDto.gender())
                .age(calculateAge(customerDto.dob()))
                .dob(customerDto.dob())
                .contacts(customerDto.contact())
                .isUnderAge(customerDto.isUnderAge())
                .isForeign(false) //Temporalmente NO
                .isDeceased(false)
                .isPEP(customerDto.isPEP())
                .createdAt(now)
                .profileStatus("ACTIVE")
                .build();
    }

    public String toUpper(String value) {
        if (value.isEmpty()) {
            return "";
        } else {
            return value.trim().toUpperCase();
        }
    }

    public int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears();
    }
}
