/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


/**
 *
 * @author MSI
 */
public class Personal {
    
    private int idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String fecha;
    private String sexo;

    public Personal() {
    }

    public Personal(int idPersona, String nombre, String apellido, String correo, String fecha, String sexo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha = fecha;
        this.sexo = sexo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int calcularEdad(){
        int edad = 0;
        /*
        System.out.println(Integer.valueOf(fecha.substring(0, 4)));
        System.out.println(Integer.valueOf(fecha.substring(5, 7)));
        System.out.println(Integer.valueOf(fecha.substring(8, 10)));
       */
        LocalDate f_nacimiento = LocalDate.of(Integer.valueOf(fecha.substring(0, 4)),
                                              Integer.valueOf(fecha.substring(5, 7)),
                                              Integer.valueOf(fecha.substring(8, 10)));
        
        LocalDate f_actual = LocalDate.now();
        
        Period periodo = Period.between(f_nacimiento, f_actual);
        
        edad = periodo.getYears();
        return edad;
    }

    @Override
    public String toString() {
        return "Personal{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fecha=" + fecha + ", sexo=" + sexo + '}';
    }
      
    
}
