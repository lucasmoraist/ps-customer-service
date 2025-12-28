package com.lucasmoraist.ps_customer_service.application.gateway;

import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.util.List;

public interface CustomerPersistence {
    void save(Customer customer);
    List<Customer> findAll();
}
