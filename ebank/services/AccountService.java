/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.services;

import com.ensi.ilsi.ebank.entities.Account;
import com.ensi.ilsi.ebank.repository.AccountRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */
@Service
public class AccountService {

  private final AccountRepository accountRepository;
  
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
  
  public Account create( Account account){
    return accountRepository.saveAndFlush(account);
  }
  
  public List<Account> findAll(){
    return accountRepository.findAll();
  }
  
  public void deleteById(Long id){
    accountRepository.deleteById(id);
  }
  
  public Account findById(Long id){
      return accountRepository.findById(id).get();
  }
  
}
