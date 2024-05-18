package com.mouakkal.digitalbanking.repositories;

import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByNameContains(String keyword);
}