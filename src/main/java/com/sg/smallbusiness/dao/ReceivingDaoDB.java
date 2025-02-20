/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Receiving;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tranlamxuanhong
 */
@Repository
public class ReceivingDaoDB implements ReceivingDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Receiving> GetAllReceiving() {
        
        String  QUERY_ALL_RECEIVING = 
                "SELECT receivingDate, receivingQuantity, itemName FROM receiving INNER JOIN Item ON receiving.itemId = Item.itemId"
                + " WHERE receivingDate = CURDATE();";
        
        return jdbc.query(QUERY_ALL_RECEIVING, new receivingMapper()) ;
    }

    @Override
    public Receiving addReceiving(Receiving receiving) {
        //get the date of today
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        receiving.setReceivingDate(date);
        String sql = "INSERT INTO receiving(itemId, receivingQuantity, receivingDate) VALUES(?,?,?);";
        
        jdbc.update(sql,
                receiving.getItemId(),
                receiving.getQuantity(),
                receiving.getReceivingDate());
        
        
        int receivingId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        receiving.setReceivingId(receivingId);
        
        return receiving;
        
    }
    
    public static final class receivingMapper implements RowMapper<Receiving> {
        
        public Receiving mapRow (ResultSet rs, int index) throws SQLException {
            
            Receiving receiving = new Receiving();
            
            //receiving.setReceivingId(rs.getInt("receivingId"));
            receiving.setReceivingDate(rs.getDate("receivingDate"));
            //receiving.setItemId(rs.getInt("itemId"));
            receiving.setItemName(rs.getString("itemName"));
            receiving.setQuantity(rs.getInt("receivingQuantity"));
          
            return receiving;
        
    }
    }
    
}
