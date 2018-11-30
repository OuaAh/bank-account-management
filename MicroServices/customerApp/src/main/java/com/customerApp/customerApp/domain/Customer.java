/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerApp.customerApp.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author groupe 2
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="cin")
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="cin",unique=true,nullable=false)
  private Long cin;
  
  @NotNull
  private String name ; 
  
  @NotNull
  private String email ; 

  @NotNull
  private String phone ; 

 // private Collection<Long> accountIds;

  public Customer(Long cin, String name, String email, String phone) {
    this.cin = cin;
    this.name = name;
    this.email = email;
    this.phone = phone;
   // accountIds=Collections.emptySet();
  }
/*
  public void setAccounts(Collection<Long> accountIds) {
    this.accountIds = accountIds;
  }

  public Collection<Long> getAccountIds() {
    return accountIds;
  }
  */
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
