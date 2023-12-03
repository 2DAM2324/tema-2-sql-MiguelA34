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
import modelo.Conexion;

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
    private Conexion conexion;
    
    public Controlador(ArrayList<Cliente> new_clientes, ArrayList<Animal> new_animales, ArrayList<Zona> new_zona, ArrayList<Trabajador> new_trabajador){
        clientes = new_clientes;
        animales = new_animales;
        zonas = new_zona;
        trabajadores = new_trabajador;
        conexion = new Conexion();
        ImportarBaseDatos();
    }
    
    public Conexion getConexion(){
        return conexion;
    }
    
    public void ImportarBaseDatos(){
        conexion.ImportarClientes(clientes);
        conexion.ImportarTrabajadores(trabajadores);
        conexion.ImportarZonas(trabajadores, zonas);
        conexion.ImportarAnimales(animales, zonas);
        conexion.ImportarVer(animales, clientes);
    }
    
    public void AgregarCliente(Cliente cli){
        conexion.AgregarCliente(cli);
    }
    
    public void AgregarAnimal(Animal an){
        conexion.AgregarAnimal(an);
    }
    
    public void AgregarTrabajador(Trabajador tr){
        conexion.AgregarTrabajador(tr);
    }
    
    public void AgregarZona(Zona zn){
        conexion.AgregarZona(zn);
    }
    
    public void AgregarVer(Cliente cli, Animal an){
        conexion.AgregarVer(cli, an);
    }
    
    
    public void EliminarCliente(Cliente cli){
        conexion.EliminarCliente(cli);
    }
    
    public void EliminarAnimal(Animal an){
        conexion.EliminarAnimal(an);
    }
}