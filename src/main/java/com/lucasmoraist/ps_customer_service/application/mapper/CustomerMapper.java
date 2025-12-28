package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.application.dto.CustomerDTO;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.CustomerEntity;

public final class CustomerMapper {

    private CustomerMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Customer toDomain(CustomerDTO customerDTO) {
        return new Customer(
                null,
                customerDTO.name(),
                customerDTO.email(),
                customerDTO.password(),
                customerDTO.documents(),
                customerDTO.paymentKeys()
        );
    }

    public static CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                null,
                customer.name(),
                customer.email(),
                customer.password(),
                customer.documents()
                        .stream()
                        .map(DocumentMapper::toEntity)
                        .toList(),
                customer.paymentKeys()
                        .stream()
                        .map(PaymentKeyMapper::toEntity)
                        .toList()
        );
    }

}
