package com.lucasmoraist.ps_customer_service.application.gateway;

import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public interface CustomerPersistence {
    Customer save(Customer customer);
    Customer findById(UUID id);
    void updateBalance(Customer payer, Customer payee, BigDecimal amount);
}
