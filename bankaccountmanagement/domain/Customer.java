/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Group 2
 */

@Entity
public class Customer extends AbstractEntity{
    
    private String name;
    
    @OneToMany(mappedBy="customer")
    private Collection<Account> accounts;

    public Customer() {
        super();
        //JPA, efficient solution No?
    }

    public Customer(String name, Collection<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", accounts=" + accounts + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.accounts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.accounts, other.accounts)) {
            return false;
        }
        return true;
    }
    
    
}
