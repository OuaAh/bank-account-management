/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankApp.bankApp.ws;

import com.bankApp.bankApp.service.BankService;
import com.commonApp.dto.BankDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/bank")
public class BankWS {
  private final BankService bankService;

  public BankWS(BankService bankService) {
    this.bankService = bankService;
  }
  
  @GetMapping
  public List<BankDto> findAll(){
    return bankService.findAll();
  }
  
  @GetMapping("/{id}")
  public BankDto findById(@PathVariable("id") Long id){
    return bankService.findById(id);
  }
  
  @PostMapping("/create")
  public BankDto createBank(@RequestBody BankDto bank){
    return bankService.createBank(bank);
  }
  
  @DeleteMapping("/delete/{id}")
  public void deleteBank(@PathVariable("id") Long id){
    bankService.deleteBank(id);
  }
  
}
