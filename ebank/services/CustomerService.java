/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.ebank.services;

import com.ensi.ilsi.ebank.entities.Customer;
import com.ensi.ilsi.ebank.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */
@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  
  public Customer createCustomer(Customer customer){
    return customerRepository.saveAndFlush(customer);
  }
  
  public List<Customer> findAll(){
    return customerRepository.findAll();
  }
  
  public Customer findByCin(Long cin){
    return customerRepository.findById(cin).get();
  }
  
  public void deleteById(Long cin){
     customerRepository.deleteById(cin);
  }
  
}