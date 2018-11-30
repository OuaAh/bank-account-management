/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.rest.dto;

import java.util.Set;

/**
 *
 * @author GROUP_2
 */
public class CustomerDto {
    
    private Long id;
    
    private String name;
    
    private String email;
    
    private String telephone;
    
    private String cin;
    
    private Set<AccountDto> accounts;

    public CustomerDto() {
        // JACKSON
    }

    public CustomerDto(Long id, String name, String email, String telephone, String cin, Set<AccountDto> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.cin = cin;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCin() {
        return cin;
    }

    public Set<AccountDto> getAccounts() {
        return accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAccounts(Set<AccountDto> accounts) {
        this.accounts = accounts;
    }
      
}
