package com.mouakkal.digitalbanking.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("SA")
@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAccount extends BankAccount{
    private double interestRate;
}
