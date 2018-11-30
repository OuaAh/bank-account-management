/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountApp.accountApp.service;

import com.accountApp.accountApp.domain.Transaction;
import com.accountApp.accountApp.domain.enumeration.TransactionType;
import com.accountApp.accountApp.repository.AccountRepository;
import com.accountApp.accountApp.repository.TransactionRepository;
import com.commonApp.dto.TransactionDto;
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
public class TransactionService {
    
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository ;
    
    public TransactionService(TransactionRepository transactionRepository,AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
    
    public TransactionDto createTransaction(TransactionDto transaction){
        if(transaction.getType().equals(TransactionType.withdrawal)){
            if(transaction.getAccount().getBalance() < transaction.getAmount()){
               System.err.println("Insufficient amount !");
               return null;
            }
            else{
                com.accountApp.accountApp.domain.Account account = accountRepository.findById(transaction.getAccount().getId()).get();
                account.setBalance(account.getBalance()-transaction.getAmount());
                accountRepository.saveAndFlush(account);
                return mapToDto(transactionRepository.save(
                new Transaction(transaction.getId(), transaction.getDateOperation(), transaction.getAmount(), TransactionType.withdrawal, AccountService.dtoToMap(transaction.getAccount()))));
        
            }
        }
        else{
            com.accountApp.accountApp.domain.Account account = accountRepository.findById(transaction.getAccount().getId()).get();
            account.setBalance(account.getBalance()+transaction.getAmount());
            accountRepository.saveAndFlush(account);
            return mapToDto(transactionRepository.save(
                new Transaction(transaction.getId(), transaction.getDateOperation(), transaction.getAmount(), TransactionType.deposit, AccountService.dtoToMap(transaction.getAccount()))));
        
        }
        
    }
    
    public List<TransactionDto>findAll(){
        return transactionRepository.findAll()
                .stream()
                .map(TransactionService::mapToDto)
                .collect(Collectors.toList());
    }
    
    public TransactionDto findById(long id){
        return mapToDto(transactionRepository.getOne(id));
    }
    
    public static TransactionDto mapToDto(Transaction transaction){
      return new TransactionDto(transaction.getId(), transaction.getDateOperation(), transaction.getAmount(), transaction.getType().name(), AccountService.mapToDto(transaction.getAccount()));
    }
        
}
