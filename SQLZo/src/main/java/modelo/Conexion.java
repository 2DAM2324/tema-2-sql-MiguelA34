/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author elect
 */
public class Conexion {
    private Connection conn;

    public Conexion() {
        conn = null;
        AbrirConexion();
    }
    
    public void AbrirConexion(){
        try {
            String url = "jdbc:sqlite:zoo.db";
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }
    
    public void CerrarConexion(){
        try {
            conn.close();
            conn = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /*public void InsertarClientes(){
        String sent = "INSERT INTO producto (nombre, precio) VALUES (?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, "patata");
            sentencia.setInt(2, 3);
            
            sentencia.executeUpdate();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            try{
                if (sentencia != null)
                    sentencia.close();
            }
            catch(SQLException sqle2){
                sqle2.printStackTrace();
            }
        }
    }*/
}
