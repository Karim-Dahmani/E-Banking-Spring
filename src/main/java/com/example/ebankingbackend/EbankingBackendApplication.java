package com.example.ebankingbackend;

import com.example.ebankingbackend.dtos.BankAccountDTO;
import com.example.ebankingbackend.dtos.CurrentBankAccountDTO;
import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.dtos.SavingBankAccountDTO;
import com.example.ebankingbackend.entities.*;
import com.example.ebankingbackend.enums.AccountStatus;
import com.example.ebankingbackend.enums.OperationType;
<<<<<<< HEAD
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;
=======
import com.example.ebankingbackend.exceptions.BankAccountNotFoundException;
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40
import com.example.ebankingbackend.repositories.AccountOperationRepository;
import com.example.ebankingbackend.repositories.BankAccountRepository;
import com.example.ebankingbackend.repositories.CustomerRepository;
import com.example.ebankingbackend.service.BankAccountService;
import com.example.ebankingbackend.service.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    @Bean
<<<<<<< HEAD
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            Stream.of("youness","Karim","Mohammed").forEach(name->{
                CustomerDTO customer=new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer->{
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDTO bankAccount:bankAccounts){
                for (int i = 0; i <10 ; i++) {
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDTO){
                        accountId=((SavingBankAccountDTO) bankAccount).getId();
                    } else{
                        accountId=((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
    }
    //@Bean
    CommandLineRunner commandLineRunner(BankService bankService) {
=======
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40
        return args -> {
            Stream.of("youness","mohammed","aya").forEach(name->{
                Customer customer=new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomer().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAcount(Math.random()*90000,9000,customer.getId());
                    bankAccountService.saveSavingBankAcount(Math.random()*134556,5.5,customer.getId());
                    List<BankAccount> bankAccounts=bankAccountService.bankAccountList();
                    for (BankAccount bankAccount:bankAccounts){
                           for( int i=0;i<10;i++){
                        bankAccountService.credit(bankAccount.getId(), 10000+Math.random()*123000,"Credit");
                        bankAccountService.debit(bankAccount.getId(),1000+Math.random()*9000,"debit");
                           }}
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }catch (BankAccountNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        };
    }
//@Bean
        CommandLineRunner start (CustomerRepository customerRepository,
                BankAccountRepository bankAccountRepository,
                AccountOperationRepository accountOperationRepository){
            return args -> {
                Stream.of("youness", "karim", "kapera").forEach(name -> {
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setEmail(name + "@gmail.com");
                    customerRepository.save(customer);
                });
                customerRepository.findAll().forEach(cust -> {
                    CurrentAccount currentAccount = new CurrentAccount();
                    currentAccount.setId(UUID.randomUUID().toString());
                    currentAccount.setBalance(Math.random() * 90000);
                    currentAccount.setCreatedAt(new Date());
                    currentAccount.setStatus(AccountStatus.CREATED);
                    currentAccount.setCustomer(cust);
                    currentAccount.setOverDraft(9000);
                    bankAccountRepository.save(currentAccount);

                    SavingAccount savingAccount = new SavingAccount();
                    savingAccount.setId(UUID.randomUUID().toString());
                    savingAccount.setBalance(Math.random() * 90000);
                    savingAccount.setCreatedAt(new Date());
                    savingAccount.setStatus(AccountStatus.CREATED);
                    savingAccount.setCustomer(cust);
                    savingAccount.setInterestRate(5.5);
                    bankAccountRepository.save(savingAccount);

                });
                bankAccountRepository.findAll().forEach(acc -> {
                    for (int i = 0; i < 10; i++) {
                        AccountOperation accountOperation = new AccountOperation();
                        accountOperation.setOperationDate(new Date());
                        accountOperation.setAmount(Math.random() * 12000);
                        accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                        accountOperation.setBankAccount(acc);
                        accountOperationRepository.save(accountOperation);

                    }

                });

            };
        }
    }