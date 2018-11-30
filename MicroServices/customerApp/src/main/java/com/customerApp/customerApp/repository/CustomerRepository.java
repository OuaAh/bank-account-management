/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerApp.customerApp.repository;

import com.customerApp.customerApp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author groupe 2
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   
}
