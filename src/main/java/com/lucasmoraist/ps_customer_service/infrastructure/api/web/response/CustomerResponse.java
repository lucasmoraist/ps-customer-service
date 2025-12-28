package com.lucasmoraist.ps_customer_service.infrastructure.api.web.response;

import com.lucasmoraist.ps_customer_service.domain.model.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        String name,
        String agency,
        String accountNumber,
        String accountType,
        BigDecimal balance
) {
    public CustomerResponse(UUID custId, Customer customer) {
        this(
                custId,
                customer.name(),
                customer.account().agency(),
                customer.account().accountNumber(),
                customer.account().accountType(),
                customer.account().balance()
        );
    }
}
