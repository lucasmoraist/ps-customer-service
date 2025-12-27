package com.lucasmoraist.ps_customer_service.domain.model;

import java.util.UUID;

public record PaymentKey(
        UUID id,
        String keyValue
) {

}
