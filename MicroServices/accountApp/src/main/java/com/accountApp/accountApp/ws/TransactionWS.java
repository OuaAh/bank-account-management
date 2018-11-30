/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountApp.accountApp.ws;

import com.accountApp.accountApp.service.TransactionService;
import com.commonApp.dto.TransactionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(API + "/transaction")
public class TransactionWS {
	
	@Autowired
  private TransactionService transactionService;

 
  @GetMapping
  public List<TransactionDto> findAll(){
    return transactionService.findAll();
  }
  
  @GetMapping("/{id}")
  public TransactionDto findById(@PathVariable("id") Long id){
    return transactionService.findById(id);
  }
  
  @PostMapping("/create")
  public TransactionDto createTransaction(@RequestBody TransactionDto transaction){
    return transactionService.createTransaction(transaction);
  }
  
}
