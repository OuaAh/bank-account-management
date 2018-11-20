/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.rest.dto;

import java.util.Collection;

/**
 *
 * @author x555ld
 */
public class CustomerDto {
    
    private Long id;
    
    private String name;
    
    private Collection<AccountDto> accounts;

    public CustomerDto() {
        // JACKSON
    }

    public CustomerDto(Long id, String name, Collection<AccountDto> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<AccountDto> getAccounts() {
        return accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(Collection<AccountDto> accounts) {
        this.accounts = accounts;
    }
    
    
    
}
