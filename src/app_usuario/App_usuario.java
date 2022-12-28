/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_usuario;

import Entidades.Persona;
import Modelo.Coneccion;
import java.sql.*;
/**
 *
 * @author ERREYES
 */
public class App_usuario {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Persona person1 =  new Persona();
        person1.setCedula("0706557998");
        person1.setNombre("JUAN JOSE");
        
        Persona person2 =  new Persona();
        person2.setCedula("0426354789");
        person2.setNombre("ANA VICTORIA");
        
        
        Coneccion conn = new Coneccion().conectar();
      
        
        // persona 1
        
        if (conn.ejecutar("INSERT INTO usuario (cedula,nombre) VALUES('"+person1.getCedula()+"','"+person1.getNombre()+"')")) {
            System.out.println("Ejecución INSERT correcta persona 1!");
        } else {
            System.out.println("Ocurrió un problema al ejecutar!");
        }     
        
       // persona 2 
        
        if (conn.ejecutar("INSERT INTO usuario (cedula,nombre) VALUES('"+person2.getCedula()+"','"+person2.getNombre()+"')")) {
            System.out.println("Ejecución INSERT correcta! persona 2");
        } else {
            System.out.println("Ocurrió un problema al ejecutar!");
        }   
        
        
 
        ResultSet resultados = conn.consultar("SELECT * FROM usuario");  
         
        if (resultados != null) {
            try {
                System.out.println("CEDULA       NOMBRE");
                System.out.println("--------------------------------");
                while (resultados.next()) {
                    System.out.println(""+resultados.getString("cedula")+"       "+resultados.getString("nombre"));
                }
            } catch (SQLException e) {
            }
        }
        
        person1 = null;
        person2= null;
        System.runFinalization();
        
        
    }
    
}
