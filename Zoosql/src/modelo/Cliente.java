/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Malt34
 */
public class Cliente {
    private int anio_nac;
    private String dni;
    private String nombre_cli;
    private ArrayList<Animal> v_animales_vistos;

    
    public Cliente() {
        this.anio_nac = 0;
        this.dni = "";
        this.nombre_cli = "";
        this.v_animales_vistos = new ArrayList<>();
    }
    
    //Constuctor por parámetros
    public Cliente(int new_anio, String new_dni, String new_nombre, ArrayList<Animal> new_v_animales) {
        this.anio_nac = new_anio;
        this.dni = new_dni;
        this.nombre_cli = new_nombre;
        this.v_animales_vistos = new_v_animales;
    }

    
    //Sets
    public void setAnioNac(int new_anio) {
        this.anio_nac = new_anio;
    }

    public void setDNI(String new_dni) {
        this.dni = new_dni;
    }

    public void setNombreCli(String new_nombre) {
        this.nombre_cli = new_nombre;
    }
    
    public void setVAnimales(ArrayList<Animal> new_v_animales){
        this.v_animales_vistos = new_v_animales;
    }

    public void setAnimal(Animal new_animal){
        this.v_animales_vistos.add(new_animal);
    }
    
    
    //Gets
    public int getAnioNac() {
        return this.anio_nac;
    }

    public String getDNI() {
        return this.dni;
    }

    public String getNombreCli() {
        return this.nombre_cli;
    }
    
    public ArrayList<Animal> getVAnimales(){
        return this.v_animales_vistos;
    }
    
    public Animal getAnimal(int posicion){
        Animal aux_an = this.v_animales_vistos.get(posicion);
        return aux_an;
    }
    

    //toString
    @Override
    public String toString() {
        String cadena1 = "";
        String cadena2 = "";
        cadena1 = "Cliente: " + this.getDNI() + "\n";
        cadena1 += "\tNombre: " + this.getNombreCli() + "\n";
        cadena1 += "\tAnio nacimiento: " + this.getAnioNac()+ "\n";
        
        return cadena1 + cadena2;
    }
}
