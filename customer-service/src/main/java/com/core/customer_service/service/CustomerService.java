package com.core.customer_service.service;

import com.core.customer_service.DTOs.CreatePersonCustomerDTO;
import com.core.customer_service.entity.Customer;
import com.core.customer_service.entity.PersonCustomer;
import com.core.customer_service.enums.CustomerType;
import com.core.customer_service.events.CustomerCreatedEvent;
import com.core.customer_service.interfaces.ICustomerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public CustomerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public PersonCustomer createPersonCustomer(CreatePersonCustomerDTO customerDto) {

        LocalDateTime now = LocalDateTime.now();

        String firstName = toUpper(customerDto.firstName());
        String middleName = toUpper(customerDto.middleName() != null ? customerDto.middleName() : "");
        String lastName = toUpper(customerDto.lastName());
        String secondLastName = toUpper(customerDto.secondLastName() != null ? customerDto.secondLastName() : "");



        PersonCustomer customer = PersonCustomer.builder()
                .type(CustomerType.PERSON)
                .nationalId(customerDto.nationalId())
                .nationality(customerDto.nationality())
                .passport(!customerDto.passport().isEmpty() ? toUpper(customerDto.passport()) : "")
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .secondLastname(secondLastName)
                .contacts(customerDto.contact())
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


        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent(customer.getFirstName());
        kafkaTemplate.send("USER_CREATED",  customerCreatedEvent.toString());


        return customer;
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
