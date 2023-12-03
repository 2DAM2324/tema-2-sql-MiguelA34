/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

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
    
    public void ImportarClientes(ArrayList<Cliente> clientes){
        String cons = "SELECT * FROM clientes";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                Cliente cli = new Cliente();
                cli.setDNI(resultado.getString(1));
                cli.setNombreCli(resultado.getString(2));
                cli.setAnioNac(Integer.valueOf(resultado.getString(3)));
                clientes.add(cli);
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
    
    public void ImportarAnimales(ArrayList<Animal> animales, ArrayList<Zona> zonas){
        String cons = "SELECT * FROM animales";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                Animal an = new Animal();
                an.setCodAnimal(resultado.getString(1));
                an.setNombreAni(resultado.getString(2));
                an.setClase(resultado.getString(3));
                an.setNombreCientifico(resultado.getString(4));
                an.setAnioNacNni(Integer.valueOf(resultado.getString(5)));
                String zona = resultado.getString(6);
                for(Zona zn : zonas){
                    if(zn.getIdZona().equals(zona)){
                        an.setZonaHabitada(zn);
                    }
                }
                animales.add(an);
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
    
    public void ImportarZonas(ArrayList<Trabajador> trabajadores, ArrayList<Zona> zonas){
        String cons = "SELECT * FROM zonas";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                Zona zn = new Zona();
                zn.setIdZona(resultado.getString(1));
                zn.setBioma(resultado.getString(2));
                zn.setCapacidad(Integer.valueOf(resultado.getString(3)));
                zn.setSuperficie(Double.parseDouble(resultado.getString(4)));
                String trabajador = resultado.getString(5);
                for(Trabajador tr : trabajadores){
                    if(tr.getCodTrabajador().equals(trabajador)){
                        zn.setTrabajadorEncargado(tr);
                    }
                }
                zonas.add(zn);
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
    
    public void ImportarTrabajadores(ArrayList<Trabajador> trabajadores){
        String cons = "SELECT * FROM trabajadores";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                Trabajador tr = new Trabajador();
                tr.setCodTrabajador(resultado.getString(1));
                tr.setNombreTr(resultado.getString(2));
                tr.setNumTelefono(resultado.getString(3));
                String gerente = resultado.getString(4);
                if(gerente.equals("si")){
                    tr.setGerente(true);
                }
                else{
                    tr.setGerente(false);
                }
                trabajadores.add(tr);
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
    
    public void ImportarVer(ArrayList<Animal> animales, ArrayList<Cliente> clientes){
        String cons = "SELECT * FROM ver";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                String cliente = resultado.getString(1);
                String animal = resultado.getString(2);
                for(Cliente cli : clientes){
                    if(cli.getDNI().equals(cliente)){
                        for(Animal an : animales){
                            if(an.getCodAnimal().equals(animal)){
                                cli.getVAnimales().add(an);
                                an.getVClientesVistos().add(cli);
                            }
                        }
                    }
                }
                
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
    
    public void AgregarCliente(Cliente cliente){
        String sent = "INSERT INTO clientes (dni, nombre, anio_nac) VALUES (?, ?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, cliente.getDNI());
            sentencia.setString(2, cliente.getNombreCli());
            sentencia.setInt(3, cliente.getAnioNac());
            
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
    
    public void AgregarAnimal(Animal animal){
        String sent = "INSERT INTO animales (codigo, nombre, clase, nombre_cientifico, anio_nac, id_zona) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, animal.getCodAnimal());
            sentencia.setString(2, animal.getNombreAni());
            sentencia.setString(3, animal.getClase());
            sentencia.setString(4, animal.getNombreCientifico());
            sentencia.setInt(5, animal.getAnioNacAni());
            sentencia.setString(6, animal.getZonaHabitada().getIdZona());
            
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
    
    public void AgregarTrabajador(Trabajador trabajador){
        String sent = "INSERT INTO trabajadores (codigo, nombre, numero_telefono, gerente) VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, trabajador.getCodTrabajador());
            sentencia.setString(2, trabajador.getNombreTr());
            sentencia.setString(3, trabajador.getNumTelefono());
            if(trabajador.getGerente() == true){
                sentencia.setString(4, "si");
            }
            else{
                sentencia.setString(4, "no");
            }
            
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
    
    public void AgregarZona(Zona zona){
        String sent = "INSERT INTO zonas (id, bioma, capacidad, superficie, trabajador) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, zona.getIdZona());
            sentencia.setString(2, zona.getBioma());
            sentencia.setInt(3, zona.getCapacidad());
            Float num = (float) Double.valueOf(zona.getSuperficie()).floatValue();
            sentencia.setFloat(4, num);
            sentencia.setString(5, zona.getTrabajadorEncargado().getCodTrabajador());
            
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
    
    public void AgregarVer(Cliente cliente, Animal animal){
        String sent = "INSERT INTO ver (cliente, cod_animal) VALUES (?, ?)";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, cliente.getDNI());
            sentencia.setString(2, animal.getCodAnimal());
            
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
    
        
    public void EliminarCliente(Cliente cliente){
        String sent = "REMOVE FROM clientes WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, cliente.getDNI());
            
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
