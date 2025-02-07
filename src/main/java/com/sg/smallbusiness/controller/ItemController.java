/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.controller;


import com.sg.smallbusiness.dao.ItemDao;
import com.sg.smallbusiness.models.Item;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tranlamxuanhong
 */
@Controller
public class ItemController {
    
    @Autowired
    ItemDao itemDao;
    
    public static String Upload_Directory = System.getProperty("user.dir") + "/src/main/resources/static/images";
    
    
    @GetMapping("homepage")
    public String getAllItems(Model model) {
        List<Item> allItems = itemDao.getAllItem();
        model.addAttribute("allItems", allItems);
        return "homepage";
    }
    
    
    @GetMapping("Inventory")
    public String displayNewCreatedItems(Model model) {
        
        List<Item> listItems = itemDao.getItemsCreatedToday();
        model.addAttribute("Inventory", listItems);
        
        return "Inventory";
    }
    
    
    @PostMapping("addItem")
    public String addItem(HttpServletRequest request,  MultipartFile file) throws IOException {
        String itemName = request.getParameter("title");
        String price = request.getParameter("price");
        
        Path path = Paths.get(Upload_Directory, file.getOriginalFilename());
        
        //copy file image in images folder
        Files.write(path, file.getBytes());
        
        
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(Integer.parseInt(price));
        item.setImageName(file.getOriginalFilename());
        
        
        itemDao.addItem(item);
        
        
        return "redirect:/Inventory";
    }
    
    
    
    

    
}
