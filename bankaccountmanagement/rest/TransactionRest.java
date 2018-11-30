/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static tn.ensi.ilsi.bankaccountmanagement.common.Web.API;
import tn.ensi.ilsi.bankaccountmanagement.rest.dto.BankTransactionDto;
import tn.ensi.ilsi.bankaccountmanagement.service.TransactionService;

/**
 *
 * @author x555ld
 */
@RestController
@RequestMapping(API+"/transactions")
public class TransactionRest {
    
    private final TransactionService transactionService;

    public TransactionRest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<BankTransactionDto> findAll() {
        return this.transactionService.findAll();
    }

    @GetMapping("/{id}")
    public BankTransactionDto findById(@PathVariable Long id) {
        return this.transactionService.findById(id);
    }

    @PostMapping
    public BankTransactionDto deposit(BankTransactionDto accountDto) {
        return this.transactionService.create(accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.transactionService.delete(id);
    }
    
}
