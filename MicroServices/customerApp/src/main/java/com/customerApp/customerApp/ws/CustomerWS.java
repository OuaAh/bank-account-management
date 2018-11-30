/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerApp.customerApp.ws;

import com.commonApp.dto.CustomerDto;
import com.customerApp.customerApp.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author groupe 2
 */
@RestController
@RequestMapping("/customer")
public class CustomerWS {
  private final CustomerService customerService;

  public CustomerWS(CustomerService customerService) {
    this.customerService = customerService;
  }
  
  @GetMapping
  public List<CustomerDto> findAll(){
    return customerService.findAll();
  }
  
  @GetMapping("find/{id}")
  public CustomerDto findByCin(@PathVariable("id") Long cin){
    return customerService.findByCin(cin);
  }
  
  @DeleteMapping("delete/{id}")
  public void deleteCustomer(@PathVariable("id") Long cin){
    customerService.deleteByCin(cin);
  }
  
  @PostMapping("/create")
  public CustomerDto createCustomer(@RequestBody CustomerDto customer){
    return customerService.createCustomer(customer);
  }
}
