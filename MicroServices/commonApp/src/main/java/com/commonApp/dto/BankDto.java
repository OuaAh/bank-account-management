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
public class BankDto {

  private Long id;
  
  private String name;

public BankDto() {
	super();
	// TODO Auto-generated constructor stub
}

public BankDto(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
  
  

}
