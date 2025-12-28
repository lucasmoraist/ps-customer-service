package com.lucasmoraist.ps_customer_service.application.gateway;

import com.lucasmoraist.ps_customer_service.domain.enums.PaymentStatus;
import com.lucasmoraist.ps_customer_service.domain.message.PaymentMessage;

public interface NotificationGateway {
    void sendNotification(PaymentMessage paymentMessage, PaymentStatus status);
}
