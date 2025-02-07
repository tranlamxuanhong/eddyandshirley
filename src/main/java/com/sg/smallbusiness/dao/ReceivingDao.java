/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.Receiving;
import java.util.List;

/**
 *
 * @author tranlamxuanhong
 */
public interface ReceivingDao {
    
    List<Receiving> GetAllReceiving();
    
    Receiving addReceiving(Receiving receiving);
    
    
}
