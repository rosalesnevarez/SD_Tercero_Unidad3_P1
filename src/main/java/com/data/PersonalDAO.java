/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Personal;
//import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class PersonalDAO {
    Conexion miConexion = new Conexion();
    
    public List<Personal> consultar () {
        
         List<Personal> lista = new ArrayList<>();
         String sql = "select * from personal ORDER BY idPersona;";
        
         try{
             Connection con = miConexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
              while (rs.next()) {
                  Personal p = new Personal();
                  
                  p.setIdPersona(rs.getInt("idPersona"));
                  p.setNombre(rs.getString("nombre"));
                  p.setApellido(rs.getString("apellido"));
                  p.setCorreo(rs.getString("correo"));
                  p.setFecha(rs.getString("f_nac"));
                  p.setSexo(rs.getString("sexo"));
                  
                  lista.add(p);
              }          
         }catch(SQLException ex){
             System.out.println("Exception: " + ex.toString());
         }
             
         
        return lista;
    }
 
    
    public void guardar(Personal persona){
        
        String sql = "insert into personal" +
                     "(nombre, apellido, correo, f_nac, sexo)" +
                      "values(?,?,?,?,?); ";
        
        try{
            Connection con = miConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCorreo());
            ps.setDate(4, java.sql.Date.valueOf(persona.getFecha()));
            ps.setString(5, persona.getSexo());
            
            ps.executeQuery();
            
        }catch(SQLException ex){
             System.out.println("Exception: " + ex.toString());
        }
        
    }
 
  
    public void eliminar(int idPersona){
        
        String sql = "delete from personal where idPersona = ? ;";
        
        try{
            Connection con = miConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idPersona);
            
            ps.executeUpdate();
            
        }catch(SQLException ex){
             System.out.println("Exception: " + ex.toString());
        }
               
    }
    
    public void actualizar(Personal persona){
        
        String sql = " update personal set " +
                        " nombre = ?, " +
                        " apellido = ?, " +
                        " correo = ?, " +
                        " f_nac= ?, " +
                        " sexo = ? where idPersona = ?;";
        
        try{
            Connection con = miConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCorreo());
            ps.setDate(4, java.sql.Date.valueOf(persona.getFecha()));
            ps.setString(5, persona.getSexo());
            ps.setInt(6, persona.getIdPersona());
            
            System.out.println(ps.toString());
            
            ps.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Registro actualizado","Actualizar",JOptionPane.INFORMATION_MESSAGE);
                    
           // System.out.println("Registro actualizado");
            
        }catch(SQLException ex){
            System.out.println("Exception"+ ex.toString());
        }
        
    }




}
