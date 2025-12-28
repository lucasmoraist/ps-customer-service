package com.lucasmoraist.ps_customer_service.infrastructure.config.usecase;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.CreateCustomerCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.ListCustomersCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCase {

    @Bean
    public CreateCustomerCase createCustomerCase(CustomerPersistence customerPersistence) {
        return new CreateCustomerCase(customerPersistence);
    }

    @Bean
    public ListCustomersCase listCustomersCase(CustomerPersistence customerPersistence) {
        return new ListCustomersCase(customerPersistence);
    }

}
