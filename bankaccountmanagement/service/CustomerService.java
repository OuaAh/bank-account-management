/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.ensi.ilsi.bankaccountmanagement.domain.Customer;
import tn.ensi.ilsi.bankaccountmanagement.repository.CustomerRepository;
import tn.ensi.ilsi.bankaccountmanagement.rest.dto.CustomerDto;

/**
 *
 * @author group2
 */

@Service
@Transactional
public class CustomerService {
    
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto create(CustomerDto customerDto) {
        log.debug("Request to create Customer : {}", customerDto);
        return mapToDto(
                this.customerRepository.save(
                        new Customer(
//                                customerDto.getName(),
//                                customerDto.getAccounts()
//                                .stream()
//                                .map(CustomerService::mapToDto)
//                                .collect(Collectors.toList())
                           )
                )
        );
    }

    public List<CustomerDto> findAll() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAll()
                .stream()
                .map(CustomerService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        log.debug("Request to get Customer : {}", id);
        return this.customerRepository.findById(id).map(CustomerService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);

        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        this.customerRepository.save(customer);
    }

    public static CustomerDto mapToDto(Customer customer) {
        if (customer != null) {
            return new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getAccounts().stream().
                            map(AccountService::mapToDto).collect(Collectors.toList())
            );
        }
        return null;
    }
    
}

