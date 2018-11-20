/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.rest.dto;

import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author x555ld
 */
public class AccountDto {
    private Long id;
    
    private BigDecimal balance;
    
    private CustomerDto customer;
    
    private Collection<TransactionDto> transactions;

    public AccountDto() {
        // JACKSON
    }

    public AccountDto(Long id, BigDecimal balance, CustomerDto customer, Collection<TransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.customer = customer;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public Collection<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public void setTransactions(Collection<TransactionDto> transactions) {
        this.transactions = transactions;
    }   
    
}
