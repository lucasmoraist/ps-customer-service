package com.lucasmoraist.ps_customer_service.domain.model;

import java.util.List;
import java.util.UUID;

public record Customer(
        UUID id,
        String name,
        String email,
        String password,
        Account account,
        List<Document> documents,
        List<PaymentKey> paymentKeys
) {

}
