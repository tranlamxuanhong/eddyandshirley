/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Item;
import java.util.List;

/**
 *
 * @author tranlamxuanhong
 */
public interface ItemDao {
    
    List<Item> getAllItem();
    
    Item addItem(Item item);
    
    void updateItem(Item item);
    
    void deleteItemById(int id);
    
    Item getItemById(int id);
    
    List<Item> getItemsCreatedToday();
    
    void updateTotalQuantity(int quantity, int id);
    
    
}
