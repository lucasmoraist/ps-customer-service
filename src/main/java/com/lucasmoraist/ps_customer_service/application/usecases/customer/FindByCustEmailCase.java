package com.lucasmoraist.ps_customer_service.application.usecases.customer;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;

public class FindByCustEmailCase {

    private final CustomerPersistence customerPersistence;

    public FindByCustEmailCase(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    public Customer execute(String email) {
        return customerPersistence.findByEmail(email);
    }

}
