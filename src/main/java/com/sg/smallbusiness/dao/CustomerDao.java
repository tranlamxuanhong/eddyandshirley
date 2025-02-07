/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Customer;
import java.util.List;

/**
 *
 * @author tranlamxuanhong
 */
public interface CustomerDao {
    
    List<Customer> getAllCustomer();
    
    Customer addCustomer(Customer customer);
    
    Customer getCustomerById(int id);
    
    void updateCustomer(Customer customer);
    
    void deleteCustomerById(int id);
    
}
