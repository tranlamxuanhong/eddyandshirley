/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author tranlamxuanhong
 */
public class CustomerDaoDB implements CustomerDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Customer> getAllCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer addCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerById(int id) {
        
        try {
            final String GET_CUSTOMER_BY_ID = "SELECT * FROM Customer WHERE CustomerId = ?";
            return jdbc.queryForObject(GET_CUSTOMER_BY_ID, new CustomerMapper());
            
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static final class CustomerMapper implements RowMapper<Customer> {
        
        @Override
        public Customer mapRow(ResultSet rs, int index) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setCustomerName(rs.getString("customerName"));
            customer.setPhoneNumber(rs.getInt("phoneNumber"));
            customer.setEmailAddress(rs.getString("emailAddress"));
            
            return customer;
            
        }

        
        
    }
        
}
