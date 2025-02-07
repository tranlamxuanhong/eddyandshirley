/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.controller;


import com.sg.smallbusiness.dao.FileDao;
import com.sg.smallbusiness.models.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author tranlamxuanhong
 */
@Controller
public class FileController {
    @Autowired
    FileDao fileDao;
    
    public static String Upload_Directory = System.getProperty("user.dir") + "/src/main/resources/static/images";
    
    @GetMapping("FileUpload")
    public String displayUploadForm() {
        return "FileUpload";
    }
    
    @PostMapping("uploadFile")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        
        Path path = Paths.get(Upload_Directory, file.getOriginalFilename());
        
        //copy file image in images folder
        Files.write(path, file.getBytes());
        
        File image = new File();
        image.setName(file.getOriginalFilename());
        image.setPath(path.toString());
        
        fileDao.addFile(image);
        
        return "FileUpload";
    }
    
    
    

}
