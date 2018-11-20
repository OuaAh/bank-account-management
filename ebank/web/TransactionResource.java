/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.web;

import com.ensi.ilsi.ebank.entities.Transaction;
import com.ensi.ilsi.ebank.services.TransactionService;
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
@RequestMapping("/transactions")
public class TransactionResource {
    
    public final TransactionService transactionService ; 
    
    public TransactionResource(TransactionService transactionService){
        this.transactionService = transactionService ;
    }
    
    @GetMapping
    public List<Transaction>findAll(){
        return transactionService.findAll();
    }
    
    @GetMapping("/{id}")
    public Transaction findById(@PathVariable Long cin){
    return transactionService.findById(cin);
    }
    
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }
}
