package com.lucasmoraist.ps_customer_service.application.usecases.customer;

import com.lucasmoraist.ps_customer_service.application.dto.CustomerDTO;
import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.mapper.CustomerMapper;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;

public class CreateCustomerCase {

    private final CustomerPersistence customerPersistence;

    public CreateCustomerCase(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    public Customer execute(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toDomain(customerDTO);
        return this.customerPersistence.save(customer);
    }

}
