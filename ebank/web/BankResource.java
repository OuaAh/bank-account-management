/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.web;

import com.ensi.ilsi.ebank.entities.Bank;
import com.ensi.ilsi.ebank.services.BankService;
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
@RequestMapping("/banks")
public class BankResource {
    
    public final BankService bankService ; 
    
    public BankResource(BankService bankService){
        this.bankService = bankService ;
    }
    
    @GetMapping
    public List<Bank>findAll(){
        return bankService.findAll();
    }
    
    @GetMapping("/{id}")
    public Bank findById(@PathVariable Long cin){
    return bankService.findById(cin);
    }
    
    @PostMapping
    public Bank create(@RequestBody Bank bank){
        return bankService.create(bank);
    }
    
    
    
}
