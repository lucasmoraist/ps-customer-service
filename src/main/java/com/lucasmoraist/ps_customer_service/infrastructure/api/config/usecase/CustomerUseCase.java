package com.lucasmoraist.ps_customer_service.infrastructure.api.config.usecase;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.CreateCustomerCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.FindByCustEmailCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.ListCustomersCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerPersistence customerPersistence;

    @Bean
    public CreateCustomerCase createCustomerCase() {
        return new CreateCustomerCase(customerPersistence);
    }

    @Bean
    public ListCustomersCase listCustomersCase() {
        return new ListCustomersCase(customerPersistence);
    }

    @Bean
    public FindByCustEmailCase findByCustEmailCase() {
        return new FindByCustEmailCase(customerPersistence);
    }

}
