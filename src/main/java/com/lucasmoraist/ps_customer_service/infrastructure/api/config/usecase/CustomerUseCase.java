package com.lucasmoraist.ps_customer_service.infrastructure.api.config.usecase;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.gateway.PaymentKeysPersistence;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.CreateCustomerCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.FindPayeeByPaymentKeyCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerPersistence customerPersistence;
    private final PaymentKeysPersistence paymentKeysPersistence;

    @Bean
    public CreateCustomerCase createCustomerCase() {
        return new CreateCustomerCase(customerPersistence);
    }

    @Bean
    public FindPayeeByPaymentKeyCase findPayeeByPaymentKeyCase() {
        return new FindPayeeByPaymentKeyCase(customerPersistence, paymentKeysPersistence);
    }

}
