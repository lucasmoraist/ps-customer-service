package com.lucasmoraist.ps_customer_service.infrastructure.database.persistence;

import com.lucasmoraist.ps_customer_service.application.gateway.CustomerPersistence;
import com.lucasmoraist.ps_customer_service.application.mapper.CustomerMapper;
import com.lucasmoraist.ps_customer_service.domain.exceptions.EmailException;
import com.lucasmoraist.ps_customer_service.domain.exceptions.NotFoundException;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.CustomerEntity;
import com.lucasmoraist.ps_customer_service.infrastructure.database.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class CustomerPersistenceImpl implements CustomerPersistence {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        log.debug("Saving customer: {}", customer);
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));

        this.repository.findByEmail(customer.email())
                .ifPresent(c -> {
                    log.error("Email already exists: {}", c.getEmail());
                    throw new EmailException("Email already exists");
                });

        CustomerEntity entitySaved = this.repository.save(entity);
        log.debug("Customer saved with id: {}", entity.getId());
        return CustomerMapper.toDomain(entitySaved);
    }

    @Override
    public Customer findById(UUID id) {
        return this.repository.findById(id)
                .stream()
                .map(CustomerMapper::toDomain)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
    }

    @Override
    public void updateBalance(Customer payer, Customer payee, BigDecimal amount) {
        log.debug("Updating balance: payer={}, payee={}, amount={}", payer.id(), payee.id(), amount);
        CustomerEntity payerEntity = CustomerMapper.toEntity(payer);
        CustomerEntity payeeEntity = CustomerMapper.toEntity(payee);

        payerEntity.withdraw(amount);
        payeeEntity.transfer(amount);

        this.repository.save(payerEntity);
        this.repository.save(payeeEntity);
    }

}
