package com.lucasmoraist.ps_customer_service.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Account(
        UUID id,
        String agency,
        String accountNumber,
        String accountType,
        BigDecimal balance
) {

}
