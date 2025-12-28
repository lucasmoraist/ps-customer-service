package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.domain.model.Account;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.AccountEntity;

public final class AccountMapper {

    private AccountMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Account toDomain(AccountEntity account) {
        return new Account(
                account.getId(),
                account.getBalance()
        );
    }

    public static AccountEntity toEntity(Account account) {
        return new AccountEntity(
                null,
                account.balance()
        );
    }

}
