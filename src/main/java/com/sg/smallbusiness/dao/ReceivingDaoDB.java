/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Receiving;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        String  QUERY_ALL_RECEIVING = "SELECT * FROM RECEIVING;";
        
        return jdbc.query("QUERY_ALL_RECEIVING", new receivingMapper()) ;
    }

    @Override
    public Receiving addReceiving(Receiving receiving) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static final class receivingMapper implements RowMapper<Receiving> {
        
        public Receiving mapRow (ResultSet rs, int index) throws SQLException {
            
            Receiving receiving = new Receiving();
            
            receiving.setReceivingDate(rs.getDate("receivingDate"));
            receiving.setReceivingId(rs.getInt("receivingId"));
            receiving.setQuantity(rs.getInt("quantity"));
          
            return receiving;
        
    }
    }
    
}
