/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.smallbusiness.dao;

import com.sg.smallbusiness.models.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tranlamxuanhong
 */
@Repository
public class FileDaoDB implements FileDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public File addFile(File file) {
        
        String ADD_FILE = "INSERT INTO File(name, path) VALUES(?,?);";
        
        jdbc.update(ADD_FILE,
                file.getName(),
                file.getPath());
        
        int fileId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        file.setId(fileId);
        
        return file;

        
    }
    
    public static final class fileMapper implements RowMapper<File> {
        @Override
        public File mapRow(ResultSet rs, int index)  throws SQLException {
            
            File file = new File();
            file.setId(rs.getInt("fileId"));
            file.setName(rs.getString("name"));
            file.setPath(rs.getString("path"));
            
            return file;
        }
    }
    
}
