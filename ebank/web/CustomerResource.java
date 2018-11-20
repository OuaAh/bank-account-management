/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.web;

import com.ensi.ilsi.ebank.entities.Customer;
import com.ensi.ilsi.ebank.services.CustomerService;
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
 * @author najm
 */
@RestController
@RequestMapping("/customers")
public class CustomerResource {
    
    public final CustomerService customerService ; 
    
    public CustomerResource(CustomerService customerService){
        this.customerService = customerService ;
    }
    
    @GetMapping
    public List<Customer>findAll(){
        return customerService.findAll();
    }
    
    @GetMapping("/{id}")
    public Customer findByCin(@PathVariable Long cin){
    return customerService.findByCin(cin);
    }
    
    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long cin){
     customerService.deleteById(cin);
  }
}
