package com.lucasmoraist.ps_customer_service.application.usecases.customer;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.gateway.PaymentKeysPersistence;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.domain.model.Payee;

import java.util.UUID;

public class FindPayeeByPaymentKeyCase {

    private final CustomerPersistence customerPersistence;
    private final PaymentKeysPersistence paymentKeysPersistence;

    public FindPayeeByPaymentKeyCase(CustomerPersistence customerPersistence, PaymentKeysPersistence paymentKeysPersistence) {
        this.customerPersistence = customerPersistence;
        this.paymentKeysPersistence = paymentKeysPersistence;
    }

    public Payee execute(String paymentKey) {
        UUID customerId = this.paymentKeysPersistence.getCustomerIdByPaymentKey(paymentKey);
        Customer customer = this.customerPersistence.findById(customerId);
        return new Payee(
                customer.id(),
                customer.name(),
                customer.account().agency(),
                customer.account().accountNumber(),
                customer.account().accountType()
        );
    }

}
