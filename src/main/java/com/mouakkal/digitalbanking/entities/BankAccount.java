package com.mouakkal.digitalbanking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE", length = 4)
public class BankAccount {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Date createdat;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String Currency ;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount", fetch=FetchType.LAZY)
    private List<AccountOperation> accountOperations;
}
