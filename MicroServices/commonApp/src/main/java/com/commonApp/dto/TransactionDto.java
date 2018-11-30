/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commonApp.dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author groupe 2
 */
@Data
@AllArgsConstructor
public class TransactionDto {

  private Long id;
  
  private Date dateOperation;
  
  private Long amount;
  
  private String type ;
  
  private AccountDto account;

public TransactionDto() {
	super();
	// TODO Auto-generated constructor stub
}

public TransactionDto(Long id, Date dateOperation, Long amount, String type, AccountDto account) {
	super();
	this.id = id;
	this.dateOperation = dateOperation;
	this.amount = amount;
	this.type = type;
	this.account = account;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getDateOperation() {
	return dateOperation;
}

public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}

public Long getAmount() {
	return amount;
}

public void setAmount(Long amount) {
	this.amount = amount;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public AccountDto getAccount() {
	return account;
}

public void setAccount(AccountDto account) {
	this.account = account;
}
  
  
  
}
