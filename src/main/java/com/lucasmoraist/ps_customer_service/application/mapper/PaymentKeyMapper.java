package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.domain.model.PaymentKey;
import com.lucasmoraist.ps_customer_service.infrastructure.api.web.request.PaymentKeyRequest;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.PaymentKeyEntity;

public final class PaymentKeyMapper {

    private PaymentKeyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PaymentKey toDto(PaymentKeyRequest paymentKeyRequest) {
        return new PaymentKey(
                null,
                paymentKeyRequest.keyValue(),
                null
        );
    }

    public static PaymentKeyEntity toEntity(PaymentKey paymentKey) {
        return new PaymentKeyEntity(
                null,
                paymentKey.keyValue(),
                null
        );
    }

}
