package com.lucasmoraist.ps_customer_service.application.usecases.message;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.gateway.NotificationGateway;
import com.lucasmoraist.ps_customer_service.domain.message.PaymentMessage;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import org.springframework.messaging.Message;

import java.util.UUID;

public class PaymentExecutionHandler {

    private final CustomerPersistence customerPersistence;
    private final NotificationGateway notificationGateway;

    public PaymentExecutionHandler(CustomerPersistence customerPersistence, NotificationGateway notificationGateway) {
        this.customerPersistence = customerPersistence;
        this.notificationGateway = notificationGateway;
    }

    public void execute(Message<PaymentMessage> paymentMessage) {
        PaymentMessage payload = paymentMessage.getPayload();

        UUID payerId = payload.payer().id();
        UUID payeeId = payload.payee().id();

        Customer payer = this.customerPersistence.findById(payerId);
        Customer payee = this.customerPersistence.findById(payeeId);
        
        this.customerPersistence.updateBalance(payer, payee, payload.amount());
        this.notificationGateway.sendNotification(payload);
    }

}
