package com.lucasmoraist.ps_customer_service.infrastructure.database.repository;

import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.PaymentKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentKeysRepository extends JpaRepository<PaymentKeyEntity, UUID> {
    Optional<PaymentKeyEntity> findByKeyValue(String keyValue);
}
