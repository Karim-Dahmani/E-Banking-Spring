package com.example.ebankingbackend.web;

<<<<<<< HEAD
import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
import com.example.ebankingbackend.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
=======
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
<<<<<<< HEAD
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
=======

public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<Customer>customers(){
        return bankAccountService.listCustomer();
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40
    }
}
