package com.core.customer_service.interfaces;

import com.core.customer_service.DTOs.CreatePersonCustomerDTO;
import com.core.customer_service.entity.PersonCustomer;

public interface ICustomerService {

    PersonCustomer createPersonCustomer(CreatePersonCustomerDTO personCustomerDTO);
}
