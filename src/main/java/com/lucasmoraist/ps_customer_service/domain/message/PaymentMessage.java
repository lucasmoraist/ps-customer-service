package com.lucasmoraist.ps_customer_service.domain.message;

import com.lucasmoraist.ps_customer_service.domain.model.Payee;
import com.lucasmoraist.ps_customer_service.domain.model.Payer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentMessage(
        UUID transactionId,
        Payer payer,
        Payee payee,
        BigDecimal amount,
        LocalDateTime executionDateTime
) {

}
