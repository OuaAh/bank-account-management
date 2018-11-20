/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.web;

import com.ensi.ilsi.ebank.entities.Account;
import com.ensi.ilsi.ebank.services.AccountService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author groupe 2 
 */
@RestController
@RequestMapping("/accounts")
public class AccountResource {
    
    public final AccountService accountService ; 
    
    public AccountResource(AccountService accountService){
        this.accountService = accountService ;
    }
    
    @GetMapping
    public List<Account>findAll(){
        return accountService.findAll();
    }
    
    @GetMapping("/{id}")
    public Account findById(@PathVariable Long id){
    return accountService.findById(id);
    }
    
    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.create(account);
    }
}
