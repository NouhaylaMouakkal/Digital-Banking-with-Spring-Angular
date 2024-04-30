package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
