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
  
}
