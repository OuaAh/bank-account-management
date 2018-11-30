/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankApp.bankApp.service;
import com.commonApp.dto.BankDto;
import com.bankApp.bankApp.domain.Bank;
import com.bankApp.bankApp.repository.BankRepository;
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
public class BankService {
  private final BankRepository bankRepository;

  public BankService(BankRepository bankRepository) {
    this.bankRepository = bankRepository;
  }
  
  public List<BankDto> findAll(){
    return bankRepository.findAll()
            .stream()
            .map(BankService::mapToDto)
            .collect(Collectors.toList());
  }
  
  public BankDto createBank(BankDto bank){
    return mapToDto(bankRepository.saveAndFlush(new Bank(bank.getId(), bank.getName())));
  }
  
  public BankDto findById(Long id){
    return mapToDto(bankRepository.getOne(id));
  }
  
  public void deleteBank(Long id){
    bankRepository.deleteById(id);
  }
  
  public static BankDto mapToDto(Bank bank){
    return new BankDto(bank.getId(), bank.getName());
  }
}
