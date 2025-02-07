/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tranlamxuanhong
 */
@Controller
public class TransactionController {
    
    @GetMapping("Transaction")
    public String displayTransaction(Model model) {
        
        String name = "Gigi";
        
        model.addAttribute("name", name);
        
        return "transaction";
    }
    
}
