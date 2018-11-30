/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountApp.accountApp.service;


import com.accountApp.accountApp.domain.Account;
import com.accountApp.accountApp.repository.AccountRepository;
import com.commonApp.dto.AccountDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */
@Service
@Transactional
public class AccountService {

  private final AccountRepository accountRepository;
  
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
  
  public AccountDto createAccount( AccountDto account){
    return mapToDto(accountRepository.saveAndFlush(new Account(account.getId(), account.getBalance(), account.getBankId(), account.getCustomerId() )));
  }
  
  public List<AccountDto> findAll(){
    return accountRepository.findAll()
            .stream()
            .map(AccountService::mapToDto)
            .collect(Collectors.toList());
  }
  
  public void deleteAccount(Long id){
    accountRepository.delete(accountRepository.getOne(id));
  }
  
  public static AccountDto mapToDto(Account account){
    return new AccountDto(account.getId(), account.getBalance() ,account.getBankId() ,account.getCustomerId());
  }
  
  public static Account dtoToMap(AccountDto account){
    return new Account(account.getId(), account.getBalance() ,account.getBankId() ,account.getCustomerId());
  }
}
