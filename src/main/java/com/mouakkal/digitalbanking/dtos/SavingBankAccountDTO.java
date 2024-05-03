package com.mouakkal.digitalbanking.dtos;
import com.mouakkal.digitalbanking.entities.AccountStatus;
import lombok.Data;
import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdat;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double rate;
}