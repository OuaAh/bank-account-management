/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author groupe 2
 */

@Entity
public class Customer {
  @Id
  private Long cin;
    
  private String name ; 
    
  private String email ; 

  private String phone ; 

  @OneToMany(mappedBy="customer")
    private Collection<Account> accounts;

  public void setAccounts(Collection<Account> accounts) {
    this.accounts = accounts;
  }

  public Collection<Account> getAccounts() {
    return accounts;
  }
  
  public Customer(){
      //JPA
  }

  public Long getCin() {
    return cin;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
  
  public void setCin(Long cin) {
    this.cin = cin;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer{" + "cin=" + cin + ", name=" + name + ", email=" + email + ", phone=" + phone + '}';
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + (int) (this.cin ^ (this.cin >>> 32));
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
    final Customer other = (Customer) obj;
    if (this.cin != other.cin) {
      return false;
    }
    return true;
  }  
    
    
}
