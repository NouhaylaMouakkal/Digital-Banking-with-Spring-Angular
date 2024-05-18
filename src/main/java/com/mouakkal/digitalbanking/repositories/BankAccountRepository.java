package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    List<BankAccount> findByCustomer(Optional<Customer> customer);
}
