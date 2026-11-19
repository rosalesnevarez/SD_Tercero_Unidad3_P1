/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class Conexion {
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/appempresa";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    Connection conn = null;
    
    public Connection conectar() {
        
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida");
            
        }catch(Exception ex){
            System.out.println("Exception: " + ex);
        }
        
        return conn;
    }

    
}
