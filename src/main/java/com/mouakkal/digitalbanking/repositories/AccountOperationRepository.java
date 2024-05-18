package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    public List<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId);
    public Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}