package com.mouakkal.digitalbanking;

import com.mouakkal.digitalbanking.entities.*;
import com.mouakkal.digitalbanking.repositories.AccountOperationRepository;
import com.mouakkal.digitalbanking.repositories.BankAccountRepository;
import com.mouakkal.digitalbanking.repositories.CustomerRepository;
import com.mouakkal.digitalbanking.service.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingApplication.class, args);
    }
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    @Bean
    CommandLineRunner commandLineRunner(BankService bankService){
        return args -> {
            bankService.consulter();
        };
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, AccountOperationRepository accountOperationRepository, BankAccountRepository bankAccountRepository) {
        return args -> {
            // Create customers
            Stream.of("Nouhayla", "Othmane", "imad").forEach(name ->
                    customerRepository.save(Customer.builder()
                            .name(name)
                            .email(name+"@gmail.com")
                            .build()
                    ));

            //Create bank accounts
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = CurrentAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .customer(customer)
                        .balance(Math.random()*9000)
                         .createdat(new Date())
                        .status(AccountStatus.CREATED)
                        .overdraft(500)
                        .build();
                bankAccountRepository.save(currentAccount);

                bankAccountRepository.save(SavingAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .customer(customer)
                        .balance(Math.random()*9000)
                        .createdat(new Date())
                        .status(AccountStatus.CREATED)
                        .rate(5.5)
                        .build()
                );
            });

            // Create account operations
            bankAccountRepository.findAll().forEach(bankAccount -> {
                for (int i = 0; i < 5; i++) {
                    accountOperationRepository.save(AccountOperation.builder()
                            .amount(Math.random()*6000)
                            .date(new Date())
                            .type(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT)
                            .bankAccount(bankAccount)
                            .build()
                    );
                }
            });



        };
    }


}
