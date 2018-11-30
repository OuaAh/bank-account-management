/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commonApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author groupe 2
 */
@Data
@AllArgsConstructor
public class AccountDto {

  private Long id;
  
  private Long balance;
  
  private Long bankId;

  private Long customerId;
  
  

public AccountDto() {
	super();
	// TODO Auto-generated constructor stub
}

public AccountDto(Long id, Long balance, Long bankId, Long customerId) {
	super();
	this.id = id;
	this.balance = balance;
	this.bankId = bankId;
	this.customerId = customerId;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getBalance() {
	return balance;
}

public void setBalance(Long balance) {
	this.balance = balance;
}

public Long getBankId() {
	return bankId;
}

public void setBankId(Long bankId) {
	this.bankId = bankId;
}

public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
  
  
  
}
