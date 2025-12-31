package com.lucasmoraist.ps_customer_service.infrastructure.database.persistence;

import com.lucasmoraist.ps_customer_service.application.gateway.PaymentKeysPersistence;
import com.lucasmoraist.ps_customer_service.infrastructure.database.repository.PaymentKeysRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class PaymentKeysPersistenceImpl implements PaymentKeysPersistence {

    private final PaymentKeysRepository repository;

    public PaymentKeysPersistenceImpl(PaymentKeysRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public UUID getCustomerIdByPaymentKey(String paymentKey) {
        return this.repository.findByKeyValue(paymentKey)
                .orElseThrow(() -> new RuntimeException("Payment key not found"))
                .getCustomer().getId();
    }

}
