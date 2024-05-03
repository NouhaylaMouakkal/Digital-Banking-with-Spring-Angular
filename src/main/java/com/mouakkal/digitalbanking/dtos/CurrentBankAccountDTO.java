package com.mouakkal.digitalbanking.dtos;


import com.mouakkal.digitalbanking.entities.AccountOperation;
import com.mouakkal.digitalbanking.entities.AccountStatus;
import com.mouakkal.digitalbanking.entities.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdat;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overdraft;
}
