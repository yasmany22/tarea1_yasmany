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
 * @author Yasmany
 */
public class App_usuario {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Coneccion conn = new Coneccion().conectar();
        
        Persona person1 =  new Persona();
      
        
        /*person1.setCedula("0698541245");
        person1.setUsuario("OSCAR");
        person1.setContrasenia("12345*.");
        person1.setEstado(1);// lo toma como valor entero*/
        
        person1.setCedula("0458745632");
        person1.setUsuario("JUAN JOSE");
        person1.setContrasenia("25FT5*.");
        person1.setEstado(1);// lo toma como valor entero
        
        Persona person2 =  new Persona();
        /*person2.setCedula("070698512");
        person2.setUsuario("Sofia");
        person2.setContrasenia("154DRF*g_@");
        person2.setEstado(0);*/
        person2.setCedula("524874521");
        person2.setUsuario("Luisa");
        person2.setContrasenia("1DkyhykRF*g_@");
        person2.setEstado(0);
        
        // insert CRUD
        try {
            // persona 1
            if (conn.ejecutar("INSERT INTO usuario (usuario,contrasenia,estado,cedula) VALUES('"+person1.getUsuario()+"','"+person1.getContrasenia()+"',"+person1.getEstado()+",'"+person1.getCedula()+"')")) {
                System.out.println("Ejecución INSERT correcta persona 1!");
            } else {
                System.out.println("Ocurrió un problema al ejecutar!");
            } 
            
        } catch (Exception e) {
        }
            
       
        try {
            // persona 2
           if (conn.ejecutar("INSERT INTO usuario (usuario,contrasenia,estado,cedula) VALUES('"+person2.getUsuario()+"','"+person2.getContrasenia()+"',"+person2.getEstado()+",'"+person2.getCedula()+"')")) {
               System.out.println("Ejecución INSERT correcta persona 2!");
           } else {
               System.out.println("Ocurrió un problema al ejecutar!");
           }   
        } catch (Exception e) {
        }
      
        ResultSet resultados = conn.consultar("SELECT * FROM usuario");  
         
        // el valor es leido como booleano en java con el método resultados.getBoolean()
        if (resultados != null) {
            try {
                System.out.println("  ID       USUARIO       CONTRASENIA         ESTADO       CEDULA    ");
                System.out.println("-------------------------------------------------------------------------------------------");
                while (resultados.next()) {
                    System.out.println(""+resultados.getInt("id")+"        "+resultados.getString("usuario")+"       "+resultados.getString("contrasenia")+"       "+resultados.getBoolean("estado")+"       "+resultados.getString("cedula"));
                }
            } catch (SQLException e) {
            }
        }
        
        person1 = null;
        person2= null;
        System.runFinalization();
    }
}
