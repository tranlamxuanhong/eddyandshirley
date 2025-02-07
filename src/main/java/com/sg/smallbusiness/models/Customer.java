/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.models;

import java.util.Objects;
import javax.persistence.Entity;


/**
 *
 * @author tranlamxuanhong
 */

public class Customer {
    private int customerId;
    private String customerName;
    private int phoneNumber;
    private String emailAddress;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.customerId;
        hash = 53 * hash + Objects.hashCode(this.customerName);
        hash = 53 * hash + this.phoneNumber;
        hash = 53 * hash + Objects.hashCode(this.emailAddress);
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
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        return true;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    
    
}
