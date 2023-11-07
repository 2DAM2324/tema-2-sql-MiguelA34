/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.util.ArrayList;

/**
 *
 * @author Malt34
 */
public class Zona {
    private String id_zona;
    private String bioma;
    private int capacidad;
    private Double superficie;
    private ArrayList<Animal> v_animales_habitan;
    private Trabajador trabajador_encargado;
    
    
    public Zona() {
        this.id_zona = "";
        this.bioma = "";
        this.capacidad = 0;
        this.superficie = 0.0;
        this.v_animales_habitan = new ArrayList<>();
        this.trabajador_encargado = new Trabajador();
    }
    
    //Constructor
    public Zona(String new_id, String new_bioma, int new_capacidad, Double new_superficie, ArrayList<Animal> new_v_animales, Trabajador new_trabajador) {
        this.id_zona = new_id;
        this.bioma = new_bioma;
        this.capacidad = new_capacidad;
        this.superficie = new_superficie;
        this.v_animales_habitan = new_v_animales;
        this.trabajador_encargado = new_trabajador;
    }
    
    
    //Sets
    public void setIdZona(String new_id) {
        this.id_zona = new_id;
    }

    public void setBioma(String new_bioma) {
        this.bioma = new_bioma;
    }

    public void setCapacidad(int new_capacidad) {
        this.capacidad = new_capacidad;
    }

    public void setSuperficie(Double new_superficie) {
        this.superficie = new_superficie;
    }
    
    public void setTrabajadorEncargado(Trabajador new_trabajador){
        this.trabajador_encargado = new_trabajador;
    }
    
    public void setVAnimalesHabitan(ArrayList<Animal> new_v_animales){
        this.v_animales_habitan = new_v_animales;
    }
    
    public void setAnimalHabita(Animal new_animal){
        this.v_animales_habitan.add(new_animal);
    }
    
    
    //Gets
    public String getIdZona() {
        return this.id_zona;
    }

    public String getBioma() {
        return this.bioma;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public Double getSuperficie() {
        return this.superficie;
    }
    
    public Trabajador getTrabajadorEncargado(){
        return this.trabajador_encargado;
    }
    
    public ArrayList<Animal> getVAnimalesHabitan(){
        return this.v_animales_habitan;
    }
    
    public Animal getAnimalHabita(int posicion){
        Animal aux_an = this.v_animales_habitan.get(posicion);
        return aux_an;
    }
    
    //toString
    @Override
    public String toString() {
        String cadena = "";
        String cadena1 = "";
        
        cadena = "Zona: " + this.getIdZona() + "\n";
        cadena += "\tBioma: " + this.getBioma() + "\n";
        cadena += "\tCapacidad: " + this.getCapacidad()+ "\n";
        cadena += "\tSuperficie: " + this.getSuperficie()+ "\n";
        
        cadena1 = "\tTrabajador asignado: " + this.getTrabajadorEncargado().getCodTrabajador() + "\n";
        
        return cadena + cadena1;
    }

    

    
    
}
