/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.entities;

import com.ensi.ilsi.ebank.entities.enumeration.TransactionType;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author groupe 2
 */

@Entity
public class Transaction {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private Date dateOperation;
  
  private Long amount;
  
  private TransactionType type ;
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id",insertable = false, updatable = false)
  private Account account;
  
  public Transaction() {
    //JPA
  }
  
  public Long getId() {
    return id;
  }

  public Date getDateOperation() {
    return dateOperation;
  }

  public Long getAmount() {
    return amount;
  }

  public TransactionType getType() {
    return type;
  }

  public Account getAccount() {
    return account;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDateOperation(Date dateOperation) {
    this.dateOperation = dateOperation;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
  
  
  @Override
  public String toString() {
    return "Transaction{" + "id=" + id + ", dateOperation=" + dateOperation + ", amount=" + amount + '}';
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 29 * hash + Objects.hashCode(this.dateOperation);
    hash = 29 * hash + (int) (this.amount ^ (this.amount >>> 32));
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
    final Transaction other = (Transaction) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.amount != other.amount) {
      return false;
    }
    if (!Objects.equals(this.dateOperation, other.dateOperation)) {
      return false;
    }
    return true;
  }

  
  
  
  
}
