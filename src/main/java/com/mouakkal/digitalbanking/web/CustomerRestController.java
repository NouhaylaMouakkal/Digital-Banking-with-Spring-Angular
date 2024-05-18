package com.mouakkal.digitalbanking.web;

import com.mouakkal.digitalbanking.dtos.CustomerDTO;
import com.mouakkal.digitalbanking.entities.BankAccount;
import com.mouakkal.digitalbanking.exceptions.CustomerNotFoundException;
import com.mouakkal.digitalbanking.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping(path = "/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }
    @GetMapping(path = "/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword" , defaultValue = "") String keyword){
        return bankAccountService.searchCustomers(keyword);
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long Customerid) throws Exception {
        return bankAccountService.getCustomer(Customerid);
    }

    // signifie que les données du customer vont etre recuperer a partir des données de la requete en format JSON
    @PostMapping(path = "/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable(name="customerId") Long customerId,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping(path = "/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        bankAccountService.deleteCustomer(customerId);
    }

}
