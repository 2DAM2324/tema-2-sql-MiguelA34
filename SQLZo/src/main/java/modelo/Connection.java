/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author elect
 */
public class Connection {
    public void AbrirConecction(){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void InsertarClientes(){
        String sent = "INSERT INTO producto (nombre, precio) VALUES (?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.prepareStatement(sent);
            
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
    }
}
