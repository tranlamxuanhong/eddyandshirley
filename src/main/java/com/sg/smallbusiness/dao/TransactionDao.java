/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Transaction;
import java.util.List;

/**
 *
 * @author tranlamxuanhong
 */
public interface TransactionDao {
    
    List<Transaction> getAllTransaction();
    
    Transaction addTransaction(Transaction transaction);
    
    void deleteTransactionById (int id);
    
    void updateTransaction (Transaction transaction);
    
    Transaction getTransactionById(int id);
    
    
}
