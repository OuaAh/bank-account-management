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
  
}
