package com.lucasmoraist.ps_customer_service.application.usecases.customer;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.util.List;

public class ListCustomersCase {

    private final CustomerPersistence customerPersistence;

    public ListCustomersCase(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    public List<Customer> execute() {
        return customerPersistence.findAll();
    }

}
