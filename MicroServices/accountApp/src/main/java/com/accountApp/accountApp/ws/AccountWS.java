/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountApp.accountApp.ws;

import com.accountApp.accountApp.service.AccountService;
import com.commonApp.dto.AccountDto;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.commonApp.utils.Web.API;

/**
 *
 * @author groupe 2
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/account")
public class AccountWS {
	@Autowired
  private  AccountService accountService;

 
  @GetMapping
  public List<AccountDto> findAll(){
    return accountService.findAll();
  }
  
  @PostMapping("/create")
  public AccountDto createAccount(@RequestBody AccountDto account){
    return accountService.createAccount(account);
  }
  
  @DeleteMapping("/delete/{id}")
  public void deleteAccount (@PathVariable("id") Long id){
    accountService.deleteAccount(id);
  }
  
  
  
}
