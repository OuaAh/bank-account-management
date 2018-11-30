/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankApp.bankApp.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author groupe 2
 */

@Entity
@Table (name= "bank")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Bank implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotNull
  @Column(name="name")
  private String name;

  //private List<Long> accountIds;
  
  public Bank() {
    //JPA
  }

  public Bank(Long id, String name) {
    this.id = id;
    this.name = name;
    //accountIds=Collections.emptyList();
  }
  

  /*public Collection<Long> getAccountIds() {
    return accountIds;
  }

  public void setAccountIds(List<Long> accountIds) {
    this.accountIds = accountIds;
  }
  */
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 79 * hash + Objects.hashCode(this.id);
    hash = 79 * hash + Objects.hashCode(this.name);
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
    final Bank other = (Bank) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Bank{" + "id=" + id + ", name=" + name + '}';
  }
  
  
}
