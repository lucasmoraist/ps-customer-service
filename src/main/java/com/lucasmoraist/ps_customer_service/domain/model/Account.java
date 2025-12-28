package com.lucasmoraist.ps_customer_service.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Account(
        UUID id,
        BigDecimal balance
) {

}
