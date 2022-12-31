package Modelo;
import java.sql.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yasmany
 */
public class Coneccion {
    public static final String URL = "jdbc:mysql://localhost:3306/bdusuario";
    public static final String USER = "root";
    public static final String CLAVE = "root";
    
    private Connection conexion;
    
    public Coneccion conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            setConexion(DriverManager.getConnection(URL, USER, CLAVE));
            if(getConexion() != null){
                System.out.println("Conexion Exitosa!");
            }else{
                System.out.println("Conexion Fallida!");                
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return this;
    }
     
  public Connection getConexion() {
	return conexion;
    }    
    public void setConexion(Connection conexion) {
            this.conexion = conexion;
    }  
    
  
    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            return false;
        }        return true;
    }
    
    public ResultSet consultar(String sql) {
          ResultSet resultado;
          try {
              Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
              resultado = sentencia.executeQuery(sql);
          } catch (SQLException e) {
              return null;
          }        return resultado;
      }
    
}
