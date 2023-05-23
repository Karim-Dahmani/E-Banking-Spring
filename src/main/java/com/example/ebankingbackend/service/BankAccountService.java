package com.example.ebankingbackend.service;

<<<<<<< HEAD
import com.example.ebankingbackend.dtos.*;
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.example.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws
            CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws
            CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException,
            BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;

    void transfer(String accountIdSource, String accountIdDestination, double amount) throws
            BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccountDTO> bankAccountList();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

=======
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface BankAccountService  {
    public Customer  saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAcount(double initalBalance, double overdraft, Long customerId)throws ClassNotFoundException;
    SavingAccount saveSavingBankAcount(double initalBalance, double  interestRate, Long customerId)throws ClassNotFoundException;
    List<Customer> listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException;
    void credit(String accountId,double amount,String description)throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException;

    List <BankAccount> bankAccountList();
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40
}
