package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.application.dto.CustomerDTO;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.api.web.request.CustomerRequest;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.CustomerEntity;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.DocumentEntity;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.PaymentKeyEntity;

import java.util.ArrayList;

public final class CustomerMapper {

    private CustomerMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Customer toDomain(CustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getDocuments()
                        .stream()
                        .map(DocumentMapper::toDomain)
                        .toList(),
                entity.getPaymentKeys()
                        .stream()
                        .map(PaymentKeyMapper::toDomain)
                        .toList()
        );
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

    public static CustomerDTO toDto(CustomerRequest request) {
        return new CustomerDTO(
                request.name(),
                request.email(),
                request.password(),
                request.documents()
                        .stream()
                        .map(DocumentMapper::toDto)
                        .toList(),
                request.paymentKeys()
                        .stream()
                        .map(PaymentKeyMapper::toDto)
                        .toList()
        );
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(
                null,
                customer.name(),
                customer.email(),
                customer.password(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        if (customer.documents() != null) {
            customerEntity.setDocuments(customer.documents().stream().map(d -> {
                DocumentEntity de = DocumentMapper.toEntity(d);
                de.setCustomer(customerEntity);
                return de;
            }).toList());
        }

        if (customer.paymentKeys() != null) {
            customerEntity.setPaymentKeys(customer.paymentKeys().stream().map(p -> {
                PaymentKeyEntity pe = PaymentKeyMapper.toEntity(p);
                pe.setCustomer(customerEntity);
                return pe;
            }).toList());
        }

        return customerEntity;
    }

}
