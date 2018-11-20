/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.ensi.ilsi.bankaccountmanagement.domain.Transaction;
import tn.ensi.ilsi.bankaccountmanagement.repository.TransactionRepository;
import tn.ensi.ilsi.bankaccountmanagement.rest.dto.TransactionDto;

/**
 *
 * @author x555ld
 */

@Service
@Transactional
public class TransactionService {
    
        
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository=transactionRepository;
    }
    
    public TransactionDto create(TransactionDto transactionDto) {
        log.debug("Request to create Customer : {}", transactionDto);
        return mapToDto(
                        new Transaction(
                                //transactionDto.getAmount(),
                                //transactionDto.getTransactionType(),
                                //AccountService.mapToDto(transactionDto.getAccount())
                            )
        );
    }

    public List<TransactionDto> findAll() {
        log.debug("Request to get all Customers");
        return this.transactionRepository.findAll()
                .stream()
                .map(CustomerService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TransactionDto findById(Long id) {
        log.debug("Request to get Customer : {}", id);
        return this.transactionRepository.findById(id).map(TransactionService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);

        Transaction transaction = this.transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        this.transactionRepository.save(transaction);
    }

    public static TransactionDto mapToDto(Transaction transaction) {
        if (transaction != null) {
            return new TransactionDto(
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getTransactionType(),
                    AccountService.mapToDto(transaction.getAccount())
            );
        }
        return null;
    }
    
}
