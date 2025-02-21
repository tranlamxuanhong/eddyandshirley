/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.controller;

import com.sg.smallbusiness.dao.ItemDao;
import com.sg.smallbusiness.dao.ReceivingDao;
import com.sg.smallbusiness.models.Item;
import com.sg.smallbusiness.models.Receiving;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tranlamxuanhong
 */
@Controller
public class ReceivingController {
    
    @Autowired
    ReceivingDao ReceivingDaoDB;
    
    @Autowired
    ItemDao itemDaoDB;
   
    
    @GetMapping("Receiving")
    public String displayItemsInDropDownList(Model model){
        
        List<Item> allItem = itemDaoDB.getAllItem();
        model.addAttribute("allItem", allItem);
        
        List<Receiving> allReceiving = ReceivingDaoDB.GetAllReceiving();
        model.addAttribute("allReceiving", allReceiving);
        
        return "Receiving";
    }
    
    
    @PostMapping("addReceiving")
    public String addReceiving(HttpServletRequest request) {
        int itemValue = Integer.parseInt(request.getParameter("itemName"));
        int receivingQuantity = Integer.parseInt(request.getParameter("quantity"));
        
        Receiving receiving = new Receiving();
        receiving.setItemId(itemValue);
        
        receiving.setQuantity(receivingQuantity);
        
        
        ReceivingDaoDB.addReceiving(receiving);
        itemDaoDB.updateTotalQuantity(receivingQuantity, itemValue);
        
        return "redirect:/Receiving";
        
    }
    
    
    
}
