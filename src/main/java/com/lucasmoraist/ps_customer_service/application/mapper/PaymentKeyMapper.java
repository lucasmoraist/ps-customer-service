package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.domain.model.PaymentKey;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.PaymentKeyEntity;

public final class PaymentKeyMapper {

    private PaymentKeyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PaymentKeyEntity toEntity(PaymentKey paymentKey) {
        return new PaymentKeyEntity(
                null,
                paymentKey.keyValue(),
                null
        );
    }

}
