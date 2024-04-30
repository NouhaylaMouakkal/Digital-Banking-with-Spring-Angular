package com.mouakkal.digitalbanking.service;

import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.entities.CurrentAccount;
import com.mouakkal.digitalbanking.entities.SavingAccount;
import com.mouakkal.digitalbanking.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    public BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("d3c59a00-8695-42b9-b16b-3c153feeded2").orElse(null);
        System.out.println("*****************************");
        System.out.println(bankAccount.getId());
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getStatus());
        System.out.println(bankAccount.getCreatedat());
        System.out.println(bankAccount.getCustomer().getName());
        System.out.println(bankAccount.getClass().getSimpleName());
        if (bankAccount instanceof CurrentAccount){
            System.out.println("Over Darft => "+((CurrentAccount)bankAccount).getOverdraft());
        }else if (bankAccount instanceof SavingAccount){
            System.out.println("Rate => "+((SavingAccount)bankAccount).getRate());
        }

        bankAccount.getAccountOperations().forEach(op ->{
            System.out.println("=======================");
            System.out.println(op.getType()+"\t"+op.getDate()+"\t"+op.getAmount());
        } );
    }

}
