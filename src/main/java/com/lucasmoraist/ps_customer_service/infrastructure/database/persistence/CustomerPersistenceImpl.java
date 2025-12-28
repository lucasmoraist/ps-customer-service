package com.lucasmoraist.ps_customer_service.infrastructure.database.persistence;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.mapper.CustomerMapper;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.CustomerEntity;
import com.lucasmoraist.ps_customer_service.infrastructure.database.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class CustomerPersistenceImpl implements CustomerPersistence {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(Customer customer) {
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));

        this.repository.save(entity);
    }

}
