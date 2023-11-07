/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 *
 * @author Malt34
 */
public class Trabajador {
    private String cod_trabajador;
    private String nombre_tr;
    private String num_telefono;
    private Boolean gerente;
    
    
    public Trabajador(){
        this.cod_trabajador = "";
        this.nombre_tr = "";
        this.num_telefono = "";
        this.gerente = false;
    }
    
    //Constructor
    public Trabajador(String new_cod, String new_nombre, String new_numero, Boolean new_gerente) {
        this.cod_trabajador = new_cod;
        this.nombre_tr = new_nombre;
        this.num_telefono = new_numero;
        this.gerente = new_gerente;
    }
    
    //Sets
    public void setCodTrabajador(String new_cod) {
        this.cod_trabajador = new_cod;
    }

    public void setNombreTr(String new_nombre) {
        this.nombre_tr = new_nombre;
    }

    public void setNumTelefono(String new_numero) {
        this.num_telefono = new_numero;
    }

    public void setGerente(Boolean new_gerente) {
        this.gerente = new_gerente;
    }
    
    
    //Gets
    public String getCodTrabajador() {
        return this.cod_trabajador;
    }

    public String getNombreTr() {
        return this.nombre_tr;
    }

    public String getNumTelefono() {
        return this.num_telefono;
    }

    public Boolean getGerente() {
        return this.gerente;
    }
    
    
    //toString
    @Override
    public String toString() {
        String cadena = "";
        cadena = "Trabajador: " + this.getCodTrabajador() + "\n";
        cadena += "\tNombre: " + this.getNombreTr() + "\n";
        cadena += "\tNumero de telefono: " + this.getNombreTr() + "\n";
        
        if(this.getGerente() == true){
            cadena += "\tEs gerente\n";
        }
        else{
            cadena += "\tNo es gerente\n";
        }
        
        return cadena;
    }
}
