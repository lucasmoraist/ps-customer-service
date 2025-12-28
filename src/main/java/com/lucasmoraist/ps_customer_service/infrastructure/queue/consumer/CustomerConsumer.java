package com.lucasmoraist.ps_customer_service.infrastructure.queue.consumer;

import com.lucasmoraist.ps_customer_service.application.usecases.message.PaymentExecutionHandler;
import com.lucasmoraist.ps_customer_service.domain.message.PaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class CustomerConsumer {

    private final PaymentExecutionHandler paymentExecutionHandler;

    @Bean
    public Consumer<Message<PaymentMessage>> fromPaymentService() {
        return paymentExecutionHandler::execute;
    }

}
