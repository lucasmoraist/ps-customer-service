package com.lucasmoraist.ps_customer_service.infrastructure.api.config.usecase;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.gateway.NotificationGateway;
import com.lucasmoraist.ps_customer_service.application.usecases.message.PaymentExecutionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentUseCase {

    @Bean
    public PaymentExecutionHandler paymentExecutionHandler(
            CustomerPersistence customerPersistence,
            NotificationGateway notificationGateway
    ) {
        return new PaymentExecutionHandler(customerPersistence, notificationGateway);
    }

}
