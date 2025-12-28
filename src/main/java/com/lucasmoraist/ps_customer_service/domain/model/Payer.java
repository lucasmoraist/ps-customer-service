package com.lucasmoraist.ps_customer_service.domain.model;

import java.util.UUID;

public record Payer(
        UUID id,
        String name,
        String agency,
        String accountNumber,
        String accountType
) {

}
