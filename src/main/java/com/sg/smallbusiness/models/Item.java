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

public class Item {
    
    private int itemId;
    private String itemName;
    private int price;
    private Date createdDate;
    private String imageName;
    

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getImageName() {
        return imageName;
    }

    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.itemId;
        hash = 17 * hash + Objects.hashCode(this.itemName);
        hash = 17 * hash + this.price;
        hash = 17 * hash + Objects.hashCode(this.createdDate);
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
        final Item other = (Item) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.createdDate, other.createdDate)) {
            return false;
        }
        return true;
    }

   
    
    
        
}
