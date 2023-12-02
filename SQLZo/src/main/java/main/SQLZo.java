/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.io.IOException;
import controlador.Controlador;
import org.xml.sax.SAXException;
import vista.Ventana1;
import java.io.IOException;

/**
 *
 * @author elect
 */
public class SQLZo {

    public static void main(String[] args) {
        try{
            Ventana1 ventana = new Ventana1();
            ventana.setVisible(true);
        }
        catch(IOException ioe){
            System.out.println("Error! ");
            ioe.printStackTrace();
        }
        catch(ClassNotFoundException ce){
            System.out.println("Error! ");
            ce.printStackTrace();
        }
        catch(SAXException se){
            System.out.println("Error! ");
            se.printStackTrace();
        }
    }
}
