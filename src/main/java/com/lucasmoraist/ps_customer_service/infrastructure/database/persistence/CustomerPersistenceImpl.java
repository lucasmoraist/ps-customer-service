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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class CustomerPersistenceImpl implements CustomerPersistence {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void save(Customer customer) {
        log.debug("Saving customer: {}", customer);
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));

        this.repository.save(entity);
        log.debug("Customer saved with id: {}", entity.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        log.debug("Finding all customers");
        return this.repository.findAll()
                .stream()
                .map(CustomerMapper::toDomain)
                .toList();
    }

}
