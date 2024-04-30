package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    Optional<Object> findAllById(String uuid);
}
