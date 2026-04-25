package com.core.customer_service.controller;

import com.core.customer_service.DTOs.CreatePersonCustomerDTO;
import com.core.customer_service.entity.PersonCustomer;
import com.core.customer_service.interfaces.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final ICustomerService _customerService;
    public CustomerController(ICustomerService customerService){
        _customerService = customerService;
    }


    @GetMapping("company")
    public ResponseEntity<?> createCompanyCustomer(){
        return ResponseEntity.ok("Companyy");
    }

    @PostMapping("person")
    public ResponseEntity<?> createPersonCustomer(@RequestBody  CreatePersonCustomerDTO customerDTO){
        PersonCustomer personCustomer = _customerService.createPersonCustomer(customerDTO);
        return ResponseEntity.ok("Usuario creado");
    }
}
