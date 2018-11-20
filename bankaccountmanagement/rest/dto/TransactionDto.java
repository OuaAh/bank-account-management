/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.rest.dto;

import java.math.BigDecimal;
import tn.ensi.ilsi.bankaccountmanagement.domain.enumeration.TransactionType;

/**
 *
 * @author x555ld
 */
public class TransactionDto {
    
    private long id;
    
    private BigDecimal amount;
    
    private TransactionType transactionType;
    
    private AccountDto account;

    public TransactionDto() {
        // JACKSON
    }

    public TransactionDto(long id, BigDecimal amount, TransactionType transactionType, AccountDto account) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }    
}
