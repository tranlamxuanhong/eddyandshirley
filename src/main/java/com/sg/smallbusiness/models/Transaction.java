/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.models;

import java.util.Objects;


/**
 *
 * @author tranlamxuanhong
 */

public class Transaction {
    
    private int transactionId;
    private int customerId;
    private int totalBillPerTransaction;
    private String transactionDate;

    public int getTransactionId() {
        return transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalBillPerTransaction() {
        return totalBillPerTransaction;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalBillPerTransaction(int totalBillPerTransaction) {
        this.totalBillPerTransaction = totalBillPerTransaction;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.transactionId;
        hash = 29 * hash + this.customerId;
        hash = 29 * hash + this.totalBillPerTransaction;
        hash = 29 * hash + Objects.hashCode(this.transactionDate);
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
        final Transaction other = (Transaction) obj;
        if (this.transactionId != other.transactionId) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.totalBillPerTransaction != other.totalBillPerTransaction) {
            return false;
        }
        if (!Objects.equals(this.transactionDate, other.transactionDate)) {
            return false;
        }
        return true;
    }
    
    
    
}
