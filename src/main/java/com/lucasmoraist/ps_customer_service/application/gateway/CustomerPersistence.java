package com.lucasmoraist.ps_customer_service.application.gateway;

import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.util.UUID;

public interface CustomerPersistence {
    Customer save(Customer customer);
    Customer findByEmail(String email);
    Customer findById(UUID id);
}
