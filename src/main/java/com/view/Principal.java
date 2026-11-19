/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.data.Conexion;

public class Principal {
    
    public static void main(String[] args){
        
        Conexion miConexion = new Conexion();
        
        miConexion.conectar();
    }
    
    
}
