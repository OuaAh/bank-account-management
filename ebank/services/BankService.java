/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.services;

import com.ensi.ilsi.ebank.entities.Bank;
import com.ensi.ilsi.ebank.repository.BankRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */
@Service
public class BankService {
    public final BankRepository bankRepository ;
    
    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository ;
    }
    
    public Bank create(Bank bank){
        return bankRepository.save(bank);
    }
    
    public List<Bank>findAll(){
        return bankRepository.findAll();
    }
    
    public Bank findById(long id){
        return bankRepository.findById(id).get() ;
    }
}
