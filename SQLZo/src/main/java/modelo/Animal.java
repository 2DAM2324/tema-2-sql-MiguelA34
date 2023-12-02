/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author elect
 */
public class Animal {
    private String cod_animal;
    private String nombre_ani;
    private int anio_nac_ani;
    private String clase;
    private String nombre_cientifico;
    private ArrayList<Cliente> v_clientes_vistos;
    private Zona zona_habitada;
    
    
    public Animal() {
        this.cod_animal = "";
        this.nombre_ani = "";
        this.anio_nac_ani = 0;
        this.clase = "";
        this.nombre_cientifico = "";
        this.v_clientes_vistos = new ArrayList<>();
        this.zona_habitada = new Zona();
    }
    
    //Constructor
    public Animal(String new_cod, String new_nombre, int new_anio, String new_clase, String new_nombre_cientifico, ArrayList<Cliente> new_v_clientes, Zona new_zona) {
        this.cod_animal = new_cod;
        this.nombre_ani = new_nombre;
        this.anio_nac_ani = new_anio;
        this.clase = new_clase;
        this.nombre_cientifico = new_nombre_cientifico;
        this.v_clientes_vistos = new_v_clientes;
        this.zona_habitada = new_zona;
    }
    
    
    //Sets
    public void setCodAnimal(String new_cod) {
        this.cod_animal = new_cod;
    }

    public void setNombreAni(String new_nombre) {
        this.nombre_ani = new_nombre;
    }

    public void setAnioNacNni(int new_anio) {
        this.anio_nac_ani = new_anio;
    }

    public void setClase(String new_clase) {
        this.clase = new_clase;
    }

    public void setNombreCientifico(String new_nombre) {
        this.nombre_cientifico = new_nombre;
    }
    
    public void setZonaHabitada(Zona new_zona){
        this.zona_habitada = new_zona;
    }
    
    public void setVClientesVistos(ArrayList<Cliente> new_v_clientes){
        this.v_clientes_vistos = new_v_clientes;
    }
    
    public void setCliente(Cliente new_cliente){
        this.v_clientes_vistos.add(new_cliente);
    }
    
    
    //Gets
    public String getCodAnimal() {
        return this.cod_animal;
    }

    public String getNombreAni() {
        return this.nombre_ani;
    }

    public int getAnioNacAni() {
        return this.anio_nac_ani;
    }

    public String getClase() {
        return this.clase;
    }

    public String getNombreCientifico() {
        return this.nombre_cientifico;
    }
    
    public Zona getZonaHabitada(){
        return this.zona_habitada;
    }
    
    public ArrayList<Cliente> getVClientesVistos(){
        return this.v_clientes_vistos;
    }
    
    public Cliente getCliente(int posicion){
        Cliente aux_cli = this.v_clientes_vistos.get(posicion);
        return aux_cli;
    }
    
    
    //toString
    @Override
    public String toString() {
        String cadena = "";
        String cadena1 = "";
        cadena = "Animal: " + this.getCodAnimal() + "\n";
        cadena += "\tNombre: " + this.getNombreAni() + "\n";
        cadena += "\tAnio nacimiento: " + this.getAnioNacAni() + "\n";
        cadena += "\tClase: " + this.getClase()+ "\n";
        cadena += "\tNombre científico: " + this.getNombreCientifico()+ "\n";
        
        cadena1 = "\tZona: " + this.getZonaHabitada().getIdZona() + "\n";
        
        return cadena + cadena1;
    }
}
