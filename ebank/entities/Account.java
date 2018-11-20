/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.entities;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


/**
 *
 * @author groupe2
 */

@Entity
public class Account {
  @Id 
  @NotNull
  @GeneratedValue(strategy = GenerationType.AUTO )
  private Long id;
  
  private Long balance;
  
  @OneToMany(mappedBy= "account")
    private Collection<Transaction> transactions;
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id",insertable = false, updatable = false)
  private Bank bank;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="cin",insertable = false, updatable = false)
  private Customer customer;
  
  public Account() {
    //JPA
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.id);
    hash = 83 * hash + Objects.hashCode(this.balance);
    return hash;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Bank getBank() {
    return bank;
  }

  public Customer getCustomer() {
    return customer;
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
