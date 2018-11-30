package com.accountApp.accountApp.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


/**
 *
 * @author groupe2
 */

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id 
  @NotNull
  @GeneratedValue(strategy = GenerationType.AUTO )
  private Long id;
  
  @NotNull
  private Long balance;
  
  @OneToMany(mappedBy= "account")
  @JsonManagedReference(value = "transaction")
    private Collection<Transaction> transactions;
  
  @NotNull
  private Long bankId;

  @NotNull
  private Long customerId;

  public Collection<Transaction> getTransactions() {
    return transactions;
  }
  
  public Account() {
    //JPA
  }

  public Account(Long id, Long balance, Long bankId, Long customerId) {
    this.id = id;
    this.balance = balance;
    this.bankId = bankId;
    this.customerId = customerId;
    transactions=Collections.emptySet();
  }

  public void setBalance(Long balance) {
    this.balance = balance;
  }

  public void setTransactions(Collection<Transaction> transactions) {
    this.transactions = transactions;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.id);
    hash = 83 * hash + Objects.hashCode(this.balance);
    return hash;
  }

  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getBankId() {
    return bankId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Long getId() {
    return id;
  }

  public long getBalance() {
    return balance;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" + "id=" + id + ", balance=" + balance + '}';
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
    if (this.id != other.id) {
      return false;
    }
    if (this.balance != other.balance) {
      return false;
    }
    return true;
  }
  
  
  
  
}
