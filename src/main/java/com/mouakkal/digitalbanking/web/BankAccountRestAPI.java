package com.mouakkal.digitalbanking.web;

import com.mouakkal.digitalbanking.dtos.*;
import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.exceptions.BalanceNotSufficientException;
import com.mouakkal.digitalbanking.exceptions.BankAccountNotFoundException;
import com.mouakkal.digitalbanking.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(path = "/accounts/{id}")
    public BankAccountDTO getBankAccount(@PathVariable(name = "id") String accountId){
        return bankAccountService.getBankAccoount(accountId);
    }

    @GetMapping(path = "/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountsList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.AccountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                               @RequestParam(name = "page",defaultValue = "0") int page,
                                               @RequestParam(name = "size",defaultValue = "5") int size){
        return bankAccountService.getAccountHistory(accountId,page,size);
    }

    @PostMapping(path = "/accounts/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO){
        this.bankAccountService.debit(debitDTO.getAccountId(),debitDTO.getAmount(),debitDTO.getDescription());
        return debitDTO;
    }

    @PostMapping(path = "/accounts/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO){
        this.bankAccountService.debit(creditDTO.getAccountId(),creditDTO.getAmount(),creditDTO.getDescritpion());
        return creditDTO;
    }

    @GetMapping(path = "/accounts/{customerid}")
    public List<BankAccount> getaccountsCustomer(@PathVariable Long customerid){
        return this.bankAccountService.getaccountsCustomer(customerid);
    }


    @PostMapping(path = "/accounts/transfert")
    public void transfert(@RequestBody TransfertRequestDTO transfertRequestDTO){
        this.bankAccountService.transfert(transfertRequestDTO.getAccountSource(),transfertRequestDTO.getAccountDestination(),transfertRequestDTO.getAmount());
    }
}