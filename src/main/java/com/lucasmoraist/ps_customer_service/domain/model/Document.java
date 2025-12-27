package com.lucasmoraist.ps_customer_service.domain.model;

import com.lucasmoraist.ps_customer_service.domain.enums.DocumentType;

import java.util.UUID;

public record Document(
        UUID id,
        DocumentType type,
        String number
) {

}
