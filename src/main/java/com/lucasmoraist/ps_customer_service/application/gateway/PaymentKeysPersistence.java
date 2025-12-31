package com.lucasmoraist.ps_customer_service.application.gateway;

import java.util.UUID;

public interface PaymentKeysPersistence {
    UUID getCustomerIdByPaymentKey(String paymentKey);
}
