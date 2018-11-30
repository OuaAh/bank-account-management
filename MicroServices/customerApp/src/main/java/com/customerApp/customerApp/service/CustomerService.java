/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerApp.customerApp.service;

import com.commonApp.dto.CustomerDto;
import com.customerApp.customerApp.domain.Customer;
import com.customerApp.customerApp.repository.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author groupe 2
 */
@Service
@Transactional
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  
  public List<CustomerDto> findAll(){
    return customerRepository.findAll()
            .stream()
            .map(CustomerService::mapToDto)
            .collect(Collectors.toList());
  }
  
  public CustomerDto createCustomer(CustomerDto customer){
    return mapToDto(customerRepository.saveAndFlush(new Customer(customer.getCin(),customer.getName(),customer.getEmail(),customer.getPhone())));
  }
  
  public CustomerDto findByCin(Long cin){
    return mapToDto(customerRepository.getOne(cin));
  }
  
  public void deleteByCin(Long cin){
    customerRepository.deleteById(cin);
  } 
  
  public static CustomerDto mapToDto(Customer customer){
    return new CustomerDto(customer.getCin(), customer.getName(), customer.getEmail(), customer.getPhone());
  }
        
}
