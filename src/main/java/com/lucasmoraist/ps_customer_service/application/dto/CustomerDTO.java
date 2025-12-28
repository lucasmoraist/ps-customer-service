package com.lucasmoraist.ps_customer_service.application.dto;

import com.lucasmoraist.ps_customer_service.domain.model.Document;
import com.lucasmoraist.ps_customer_service.domain.model.PaymentKey;

import java.util.List;

public record CustomerDTO(
        String name,
        String email,
        String password,
        List<Document> documents,
        List<PaymentKey> paymentKeys
) {

}
