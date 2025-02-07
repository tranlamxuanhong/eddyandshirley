/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.models;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author tranlamxuanhong
 */

public class Receiving {
    
    private int receivingId;
    private Date receivingDate;
    private int quantity;

    public int getReceivingId() {
        return receivingId;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setReceivingId(int receivingId) {
        this.receivingId = receivingId;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.receivingId;
        hash = 97 * hash + Objects.hashCode(this.receivingDate);
        hash = 97 * hash + this.quantity;
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
        final Receiving other = (Receiving) obj;
        if (this.receivingId != other.receivingId) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.receivingDate, other.receivingDate)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
