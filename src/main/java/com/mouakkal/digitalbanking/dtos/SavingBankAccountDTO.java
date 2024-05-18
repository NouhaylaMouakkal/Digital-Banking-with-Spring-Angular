package com.mouakkal.digitalbanking.dtos;
import com.mouakkal.digitalbanking.enumeration.AccountStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance;
    private Date createAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private CustomerDTO customer;
    private double interestRate;
}