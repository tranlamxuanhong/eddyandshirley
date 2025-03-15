/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Item;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tranlamxuanhong
 */
@Repository
public class ItemDaoDB implements ItemDao {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Autowired
    ReceivingDao receivingDaoDB;

    @Override
    public List<Item> getAllItem() {
        String QUERY_ALL_ITEM = "SELECT * FROM ITEM;";
        
        return jdbc.query(QUERY_ALL_ITEM, new itemMapper());
    }

    @Override
    public Item addItem(Item item) {
        
        int totalQuantity = 0;
        
        //get the date of today
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        item.setCreatedDate(date);
        item.setTotalQuantity(totalQuantity);
        
        String ADD_ITEM = "INSERT INTO Item(ItemName, price, createdDate, imageName, totalQuantity) VALUES(?,?,?,?,?);";
        jdbc.update(ADD_ITEM,
               item.getItemName(),
                item.getPrice(),
                item.getCreatedDate(),
                item.getImageName(),
                item.getTotalQuantity());
        
        
        int itemId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        item.setItemId(itemId);
        
        return item;
        
    }

    @Override
    public void updateItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItemById(int id) {
        String DELETE_Receiving = "DELETE From receiving WHERE itemId = ?;";
        jdbc.update(DELETE_Receiving, id);
        
        String DELETE_ITEM = "DELETE FROM Item WHERE itemId = ?;";
        jdbc.update(DELETE_ITEM, id);
        
    }

    @Override
    public Item getItemById(int id) {
        try{
            final String get_item_by_id = "SELECT * FROM ITEM WHERE itemId = ?;";
            return jdbc.queryForObject(get_item_by_id, new itemMapper(), id);
        } catch(DataAccessException ex){
            return null;
        }
    }
    
    @Override
    public List<Item> getItemsCreatedToday () {
            
        String QUERY_ITEMS_CREATED_TODAY = "SELECT * FROM ITEM WHERE createdDate = CURDATE();";
        
        return jdbc.query(QUERY_ITEMS_CREATED_TODAY, new itemMapper());
    }

    @Override
    public void updateTotalQuantity(int quantity, int id) {
        
        //get new receiving object
        //get receiving quantity
        //get totalQuantity from item
        
        
        //String updateTotalQuantity = "Update Item SET totalQuantity = ? WHERE itemId = ?;";
        
        Item item = this.getItemById(id);
        int itemQuantity = item.getTotalQuantity();
        int newItemQuantity = itemQuantity + quantity;
        String update_quantity = "UPDATE Item SET totalQuantity = ? WHERE itemId = ?;";
        
        jdbc.update(update_quantity, newItemQuantity, id);        
    }
    
   
    public static final class itemMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int index)  throws SQLException {
            
            Item item = new Item();
            item.setItemId(rs.getInt("itemId"));
            item.setItemName(rs.getString("itemName"));
            item.setPrice(rs.getFloat("price"));
            item.setCreatedDate(rs.getDate("createdDate"));
            item.setImageName(rs.getString("imageName"));
            item.setTotalQuantity(rs.getInt("totalQuantity"));
            
            return item;
        }
    }
       
}
