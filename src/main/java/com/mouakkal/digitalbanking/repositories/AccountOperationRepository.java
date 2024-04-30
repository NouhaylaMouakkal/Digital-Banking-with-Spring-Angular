package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.AccountOperation;
import com.mouakkal.digitalbanking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
