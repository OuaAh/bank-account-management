/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ensi.ilsi.bankaccountmanagement.domain.Customer;

/**
 *
 * @author x555ld
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}