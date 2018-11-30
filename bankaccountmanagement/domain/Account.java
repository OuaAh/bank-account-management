/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author GROUP_2
 */

@Entity
@Table(name = "account")
public class Account extends AbstractEntity{
    
    @Column(name = "balance")
    private BigDecimal balance;
    
    @ManyToOne
    private Customer customer; 

    @OneToMany(mappedBy="account")
    @JsonIgnore
    private List<BankTransaction> transactions;

    public Account() {
        super();
        // JPA! super() is better No?
    }

    public Account(BigDecimal balance, Customer customer, List<BankTransaction> transactions) {
        this.balance = balance;
        this.customer = customer;
        this.transactions = transactions;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Collection<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTransactions(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + ", customer=" + 
                customer.getName() + ", transactions=" + transactions + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.customer);
        hash = 83 * hash + Objects.hashCode(this.transactions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.transactions, other.transactions)) {
            return false;
        }
        return true;
    }
    
}
