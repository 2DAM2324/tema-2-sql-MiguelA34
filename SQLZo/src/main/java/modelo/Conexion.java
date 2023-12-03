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
    
    /**
     * @brief método que abre la conexión con la base de datos
     */
    public void AbrirConexion(){
        try {
            String url = "jdbc:sqlite:zoo.db";
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }
    
    /**
     * @brief método que cierra la conexión con la base de datos
     */
    public void CerrarConexion(){
        try {
            conn.close();
            conn = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * @brief método que importa los clientes de la base de datos
     * @param clientes, donde se van a guardar los clientes
     */
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
    
    /**
     * @brief método que importa los animales de la base de datos
     * @param animales, donde se van a guardar los animales
     * @param zonas, de aqui se extrae la zona en la que habita un animal
     * @pre se tienen que importar primero las zonas
     */
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
    
    /**
     * @brief método que importa los zonas de la base de datos
     * @param zonas, donde se van a guardar los zonas
     * @param trabajadores, de aqui se extrae la trabajadores en la que se encarga de una zona
     * @pre se tienen que importar primero las trabajadores
     */
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
                
                if(resultado.getInt(3) == 0){
                    zn.setCapacidad(0);
                }
                else{
                    zn.setCapacidad(Integer.valueOf(resultado.getString(3)));
                }
                
                if(resultado.getFloat(4) == 0.0){
                    zn.setSuperficie(0.0);
                }
                else{
                    zn.setSuperficie(Double.parseDouble(resultado.getString(4)));
                }
                
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
    
    /**
     * @brief método que importa los trabajadores de la base de datos
     * @param trabajadores, donde se van a guardar los trabajadores
     */
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
    
    /**
     * @brief método que importa la relacion N:M de la base de datos
     * @param animales, donde se van a guardar los clientes vistos
     * @param clientes, donde se van a guardar los animales vistos
     * @pre se tienen que importar primero los animales y los clientes
     */
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
    
    /**
     * @brief método que agrega un cliente a la base de datos
     * @param cliente, el cliente que se va a insertar
     */
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
    
    /**
     * @brief método que agrega un animal a la base de datos
     * @param animal, el animal que se va a insertar
     */
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
    
    /**
     * @brief método que agrega un trabajador a la base de datos
     * @param trabajador, el trabajador que se va a insertar
     */
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
    
    /**
     * @brief método que agrega un zona a la base de datos
     * @param zona, el zona que se va a insertar
     */
    public void AgregarZona(Zona zona){
        String sent = "INSERT INTO zonas (id, bioma, capacidad, superficie, trabajador) VALUES (?, ?, ?, ?, ?);";
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
    
    /**
     * @brief método que agrega la relacion N:M a la base de datos
     * @param cliente, el cliente que se va a insertar
     * @param animal, el animal que se va a insertar
     */
    public void AgregarVer(Cliente cliente, Animal animal){
        String sent = "INSERT INTO ver (cliente, cod_animal) VALUES (?, ?);";
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
    
    /**
     * @brief método que elimina un cliente a la base de datos
     * @param cliente, el cliente que se va a elimina
     */
    public void EliminarCliente(Cliente cliente){
        String sent = "DELETE FROM clientes WHERE dni = ?;";
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
    
    /**
     * @brief método que elimina un animal a la base de datos
     * @param animal, el animal que se va a elimina
     */
    public void EliminarAnimal(Animal animal){
        String sent = "DELETE FROM animales WHERE codigo = ?;";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, animal.getCodAnimal());
            
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
    
    /**
     * @brief método que elimina un trabajador a la base de datos
     * @param trabajador, el trabajador que se va a elimina
     */
    public void EliminarTrabajador(Trabajador trabajador){
        String sent = "DELETE FROM trabajadores WHERE codigo = ?;";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, trabajador.getCodTrabajador());
            
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
    
    /**
     * @brief método que elimina un zona a la base de datos
     * @param zona, el zona que se va a elimina
     */
    public void EliminarZonas(Zona zona){
        String sent = "DELETE FROM zonas WHERE id = ?;";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, zona.getIdZona());
            
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
    
    /**
     * @brief método que elimina una relacion N:M a la base de datos
     * @param an, el animal que se va a elimina
     * @param cli, el cliente que se va a elimina
     */
    public void EliminarVer(Animal an, Cliente cli){
        String sent = "DELETE FROM ver WHERE cod_animal = ? AND cliente = ?;";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, an.getCodAnimal());
            sentencia.setString(2, cli.getDNI());
            
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
    
    /**
     * @brief método que modifica una cliente a la base de datos
     * @param cli, el cliente que se va a modifica
     */
    public void ModificarCliente(Cliente cli){
        String sent = "UPDATE clientes SET nombre = ?, anio_nac = ? WHERE dni = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, cli.getNombreCli());
            sentencia.setInt(2, cli.getAnioNac());
            sentencia.setString(3, cli.getDNI());
            
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
    
    /**
     * @brief método que modifica una animal a la base de datos
     * @param an, el animal que se va a modifica
     */
    public void ModificarAnimal(Animal an){
        String sent = "UPDATE animales SET nombre = ?, clase = ?, nombre_cientifico = ?, anio_nac = ? WHERE codigo = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, an.getNombreAni());
            sentencia.setString(2, an.getClase());
            sentencia.setString(3, an.getNombreCientifico());
            sentencia.setInt(4, an.getAnioNacAni());
            sentencia.setString(5, an.getCodAnimal());
            
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
    
    /**
     * @brief método que modifica la zona de un animal a la base de datos
     * @param zn, la zona que se va a modificar
     * @param an, el animal que va a ser modificado
     */
    public void ModificarZonaHabitada(Animal an, Zona zn){
        String sent = "UPDATE animales SET id_zona = ? WHERE codigo = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, zn.getIdZona());
            sentencia.setString(2, an.getCodAnimal());
            
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
    
    /**
     * @brief método que modifica una trabajador a la base de datos
     * @param tr, el trabajador que se va a modifica
     */
    public void ModificarTrabajador(Trabajador tr){
        String sent = "UPDATE trabajadores SET nombre = ?, numero_telefono = ?, gerente = ? WHERE codigo = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, tr.getNombreTr());
            sentencia.setString(2, tr.getNumTelefono());
            if(tr.getGerente() == true){
                sentencia.setString(3, "si");
            }
            else{
                sentencia.setString(3, "no");
            }
            sentencia.setString(4, tr.getCodTrabajador());
            
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
    
    /**
     * @brief método que modifica una zona a la base de datos
     * @param zn, el zona que se va a modifica
     */
    public void ModificarZona(Zona zn){
        String sent = "UPDATE zonas SET bioma = ?, capacidad = ?, superficie = ? WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, zn.getBioma());
            sentencia.setInt(2, zn.getCapacidad());
            Float num = (float) Double.valueOf(zn.getSuperficie()).floatValue();
            sentencia.setString(4, zn.getIdZona());
            
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
    
    /**
     * @brief método que modifica la trabajdor de un zona a la base de datos
     * @param zn, la zona que se va a modificar
     * @param tr, el trabajdor que va a ser modificado
     */
    public void ModificarTrabajadorEncargado(Zona zn, Trabajador tr){
        String sent = "UPDATE zonas SET trabajador = ? WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conn.prepareStatement(sent);
            
            sentencia.setString(1, tr.getCodTrabajador());
            sentencia.setString(2, zn.getIdZona());
            
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