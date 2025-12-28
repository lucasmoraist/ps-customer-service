package com.lucasmoraist.ps_customer_service.application.usecases.customer;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.util.UUID;

public class FindByCustIdCase {

    private final CustomerPersistence customerPersistence;

    public FindByCustIdCase(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    public Customer execute(UUID id) {
        return this.customerPersistence.findById(id);
    }

}
