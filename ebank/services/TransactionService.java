/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.services;

import com.ensi.ilsi.ebank.entities.Account;
import com.ensi.ilsi.ebank.entities.Transaction;
import com.ensi.ilsi.ebank.entities.enumeration.TransactionType;
import com.ensi.ilsi.ebank.repository.AccountRepository;
import com.ensi.ilsi.ebank.repository.TransactionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */

@Service
public class TransactionService {
    
    public final TransactionRepository transactionRepository;
    public final AccountRepository accountRepository ;
    
    public TransactionService(TransactionRepository transactionRepository,AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
    
    public Transaction create(Transaction transaction){
        
        if(transaction.getType().equals(TransactionType.withdrawal)){
            if(transaction.getAccount().getBalance() < transaction.getAmount()){
                System.err.println("Insufficient amount !");
                return null ;
            }
            else{
                Account account = accountRepository.findById(transaction.getAccount().getId()).get();
                account.setBalance(account.getBalance()-transaction.getAmount());
                accountRepository.saveAndFlush(account);
            }
        }
        else{
            Account account = accountRepository.findById(transaction.getAccount().getId()).get();
            account.setBalance(account.getBalance()+transaction.getAmount());
            accountRepository.saveAndFlush(account);
        }
        return transactionRepository.save(transaction);
        
    }
    
    public List<Transaction>findAll(){
        return transactionRepository.findAll();
    }
    
    public Transaction findById(long id){
        return transactionRepository.findById(id).get();
    }
        
}
