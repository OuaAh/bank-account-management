/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankApp.bankApp.repository;

import com.bankApp.bankApp.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author groupe 2
 */

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
  
    
}
