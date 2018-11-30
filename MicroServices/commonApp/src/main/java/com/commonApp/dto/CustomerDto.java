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
public class CustomerDto {

  private Long cin;
  
  private String name ; 
  
  private String email ; 

  private String phone ;

public CustomerDto() {
	super();
	// TODO Auto-generated constructor stub
}

public CustomerDto(Long cin, String name, String email, String phone) {
	super();
	this.cin = cin;
	this.name = name;
	this.email = email;
	this.phone = phone;
}

public Long getCin() {
	return cin;
}

public void setCin(Long cin) {
	this.cin = cin;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
} 
  
  
}
