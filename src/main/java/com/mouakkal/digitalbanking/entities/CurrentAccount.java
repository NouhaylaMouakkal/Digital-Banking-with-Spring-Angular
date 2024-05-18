package com.mouakkal.digitalbanking.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("CA")
@Data @AllArgsConstructor @NoArgsConstructor
public class CurrentAccount extends  BankAccount{
    private double overDraft;
}