package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.AccountOperation;
import com.mouakkal.digitalbanking.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountIdOrderByDateDesc(String accountId, Pageable pageable);
}