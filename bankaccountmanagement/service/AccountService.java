/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.ensi.ilsi.bankaccountmanagement.repository.AccountRepository;
import tn.ensi.ilsi.bankaccountmanagement.domain.Account;
import tn.ensi.ilsi.bankaccountmanagement.rest.dto.AccountDto;

/**
 *
 * @author x555ld
 */

@Service
@Transactional
public class AccountService {
    
    private final Logger log = LoggerFactory.getLogger(AccountService.class);
    
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
  
    
    public AccountDto create(AccountDto accountDto) {
        log.debug("Request to create account : {}", accountDto);
        return mapToDto(
                this.accountRepository.save(
                        dtoToMap(accountDto)
                )
            );
    }

    public List<AccountDto> findAll() {
        log.debug("Request to get all Accounts");
        return this.accountRepository.findAll()
                .stream()
                .map(AccountService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AccountDto findById(Long id) {
        log.debug("Request to get Account : {}", id);
        return this.accountRepository.findById(id).map(AccountService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete account : {}", id);

        Account transaction = this.accountRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        this.accountRepository.save(transaction);
    }

    public static AccountDto mapToDto(Account account) {
        if (account != null) {
            return new AccountDto(
                    account.getId(),
                    account.getBalance(),
                    CustomerService.mapToDto(account.getCustomer()),
                    account.getTransactions().stream().map(TransactionService::mapToDto).collect(Collectors.toList())
            );
        }
        return null;
    }
    
    public static Account dtoToMap(AccountDto accountDto) {
        if (accountDto != null) {
            return new Account(
                    accountDto.getBalance(),
                    CustomerService.dtoToMap(accountDto.getCustomer()),
                    accountDto.getTransactions().stream().map(TransactionService::dtoToMap).collect(Collectors.toList())
            );
        }
        return null;
    }
    
}

//    public void deposit(Long id, BigDecimal amount) {
//        log.debug("Request to deposit" + amount +" in account : {}", id);
//        Optional<Account> account=findById(id);
//        if(account.isPresent()){
//            //new TransactionService(new TransactionRepository).create(deposit);
//            account.get().setBalance(amount);
//            create(account.get());
//        }
//    }
