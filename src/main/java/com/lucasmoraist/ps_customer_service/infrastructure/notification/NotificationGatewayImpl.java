package com.lucasmoraist.ps_customer_service.infrastructure.notification;

import com.lucasmoraist.ps_customer_service.application.gateway.NotificationGateway;
import com.lucasmoraist.ps_customer_service.domain.message.PaymentMessage;
import com.lucasmoraist.ps_customer_service.infrastructure.queue.producer.CustomerProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Log4j2
@Component
@RequiredArgsConstructor
public class NotificationGatewayImpl implements NotificationGateway {

    private final CustomerProducer producer;

    @Override
    public void sendNotification(PaymentMessage paymentMessage) {
        log.info("Sending notification for payment message: {}", paymentMessage);
        producer.sendMessage(withPayload(paymentMessage)
                .build()
        );
    }

}
