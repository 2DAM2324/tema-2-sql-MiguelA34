/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import jdk.jfr.SettingControl;
import org.w3c.dom.Text;

import modelo.Animal;
import modelo.Cliente;
import modelo.Trabajador;
import modelo.Zona;
import vista.Ventana1;

import java.util.ArrayList;
import org.xml.sax.SAXException;

import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Result;
import modelo.Connection;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

/**
 *
 * @author elect
 */
public class Controlador {
    private Ventana1 ventana;
    private ArrayList<Cliente> clientes;
    private ArrayList<Animal> animales;
    private ArrayList<Zona> zonas;
    private ArrayList<Trabajador> trabajadores;
    private Connection conexion;
    
    public Controlador(ArrayList<Cliente> new_clientes, ArrayList<Animal> new_animales, ArrayList<Zona> new_zona, ArrayList<Trabajador> new_trabajador){
        clientes = new_clientes;
        animales = new_animales;
        zonas = new_zona;
        trabajadores = new_trabajador;
    }
    
    public void CargarSQL(){
        // Conexion con la base de datos
        try{
        Class.forName("org.sqlite.JDBC");
        }
        catch(Exception E){
            System.out.println("nop");
        }
        
        conexion = null;
        
        try{
            String url = "jdbc:sqlite:/home/ana/prueba.db";
            conexion = DriverManager.getConnection(url);
            
            System.out.println("Conexion establecida olee");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){}
        
        //Consulta a la base de datos
        String cons = "SELECT * FROM producto WHERE precio==3";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conexion.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                System.out.println("producto: "+resultado.getString(1));
                System.out.println("precio: "+resultado.getInt(2));
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if (consulta != null){
                try{
                   consulta.close();
                    resultado.close(); 
                }
                catch(SQLException sqle2){
                    sqle2.printStackTrace();
                }
                
            }
        }
    }
    
    public void CerrarConexion(){
        try{
            if (conexion != null)
                conexion.close();
        }
        catch(SQLException e2){
            System.out.println(e2.getMessage());
        }
    }
}
