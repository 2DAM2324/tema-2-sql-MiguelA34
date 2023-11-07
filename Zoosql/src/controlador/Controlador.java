/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import jdk.jfr.SettingControl;
import org.w3c.dom.Text;

import zoo.Animal;
import zoo.Cliente;
import zoo.Trabajador;
import zoo.Zona;
import zoo.Ventana1;

import java.util.ArrayList;
import org.xml.sax.SAXException;

import java.io.File;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

/**
 *
 * @author Malt34
 */
public class Controlador {
    private Ventana1 ventana;
    private ArrayList<Cliente> clientes;
    private ArrayList<Animal> animales;
    private ArrayList<Zona> zonas;
    private ArrayList<Trabajador> trabajadores;
    
    public Controlador(ArrayList<Cliente> new_clientes, ArrayList<Animal> new_animales, ArrayList<Zona> new_zona, ArrayList<Trabajador> new_trabajador){
        clientes = new_clientes;
        animales = new_animales;
        zonas = new_zona;
        trabajadores = new_trabajador;
        ImportarXml();
    }
    
    private void ImportarXml(){
        ImportarClientes();
        ImportarZonas();
        ImportarAnimales();
        ImportarTrabajadores();
        ImportarClientes2();
        ImportarZonas2();
    }
    
    public void ExportarXml(){
        ExportarClientes();
        ExportarAnimales();
        ExportarZonas();
        ExportarTrabajadores();
    }
    
    private void ImportarClientes(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("clientes.xml"));

            NodeList cliente = documento.getElementsByTagName("cliente");

            int anio = 0;
            for(int i = 0; i < cliente.getLength(); i++){
                Node Cliente = cliente.item(i);
                Element elemento = (Element) Cliente;
                Cliente new_cli = new Cliente();

                new_cli.setDNI(elemento.getElementsByTagName("dni").item(0).getChildNodes().item(0).getNodeValue());
                new_cli.setNombreCli(elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue());
                anio = Integer.valueOf(elemento.getElementsByTagName("anio_nacimiento").item(0).getChildNodes().item(0).getNodeValue());
                new_cli.setAnioNac(anio);
                
                clientes.add(new_cli);
            }
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(SAXException saxe){
            saxe.printStackTrace();
        }
    }
    
    private void ImportarTrabajadores(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("trabajadores.xml"));

            NodeList trabajador = documento.getElementsByTagName("trabajador");
            
            String zn_encargada = "";

            for(int i = 0; i < trabajador.getLength(); i++){
                Node Trabajador = trabajador.item(i);
                Element elemento = (Element) Trabajador;
                
                Trabajador new_tr = new Trabajador();

                new_tr.setCodTrabajador(elemento.getElementsByTagName("codigo").item(0).getChildNodes().item(0).getNodeValue());
                new_tr.setNombreTr(elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue());
                new_tr.setNumTelefono(elemento.getElementsByTagName("numero_telefono").item(0).getChildNodes().item(0).getNodeValue());
            
                if((elemento.getElementsByTagName("gerente").item(0).getChildNodes().item(0).getNodeValue()).equals("si")){
                    new_tr.setGerente(true);
                }
                else{
                    new_tr.setGerente(false);
                }
            
                trabajadores.add(new_tr);
            }
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(SAXException saxe){
            saxe.printStackTrace();
        }
    }
    
    private void ImportarZonas(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("zonas.xml"));

            NodeList zona = documento.getElementsByTagName("zona");

            int capacidad = 0;
            double superficie = 0.0;
            
            for(int i = 0; i < zona.getLength(); i++){
                Node Zona = zona.item(i);
                Element elemento = (Element) Zona;

                Zona new_zn = new Zona();
                
                new_zn.setIdZona(elemento.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue());
                new_zn.setBioma(elemento.getElementsByTagName("bioma").item(0).getChildNodes().item(0).getNodeValue());
                
                capacidad = Integer.valueOf(elemento.getElementsByTagName("capacidad").item(0).getChildNodes().item(0).getNodeValue());
                superficie = Double.valueOf(elemento.getElementsByTagName("superficie").item(0).getChildNodes().item(0).getNodeValue());
            
                new_zn.setCapacidad(capacidad);
                new_zn.setSuperficie(superficie);
                
                zonas.add(new_zn);
            }
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(SAXException saxe){
            saxe.printStackTrace();
        }
    }
    
    private void ImportarZonas2() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("zonas.xml"));

            NodeList zona = documento.getElementsByTagName("zona");

            for (int i = 0; i < zona.getLength(); i++) {
                Node zonaNode = zona.item(i);
                Element elemento = (Element) zonaNode;
                
                NodeList animales_h = elemento.getElementsByTagName("animal_que_habita");
                for (int j = 0; j < animales_h.getLength(); j++) {
                    Element animalHabita = (Element) animales_h.item(j);
                    String an_habita = animalHabita.getTextContent();

                    for (Cliente cl : clientes) {
                        if (cl.getDNI().equals(an_habita)) {
                            animales.get(i).setCliente(cl);
                        }
                    }
                }

                String tr_cuidador = elemento.getElementsByTagName("trabajador_que_cuida").item(0).getTextContent();

                for (Zona zn : zonas) {
                    if (zn.getIdZona().equals(tr_cuidador)) {
                        animales.get(i).setZonaHabitada(zn);
                    }
                }
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        }
    }
    
    private void ImportarClientes2(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("clientes.xml"));

            NodeList cliente = documento.getElementsByTagName("cliente");

            String animal_visto = "";
            
            for (int i = 0; i < cliente.getLength(); i++){
                Node Cliente = cliente.item(i);
                Element elemento = (Element) Cliente;
                
                animal_visto = elemento.getElementsByTagName("dni").item(0).getChildNodes().item(0).getNodeValue();
            
                for(Animal an : animales){
                    if(an.getCodAnimal().equals(animal_visto)){
                        clientes.get(i).setAnimal(an);
                    }
                }
            }
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(SAXException saxe){
            saxe.printStackTrace();
        }
    }
    
    private void ImportarAnimales() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("animales.xml"));

            NodeList animal = documento.getElementsByTagName("animal");

            for (int i = 0; i < animal.getLength(); i++) {
                Node animalNode = animal.item(i);
                Element elemento = (Element) animalNode;

                Animal new_an = new Animal();

                new_an.setCodAnimal(elemento.getElementsByTagName("codigo").item(0).getTextContent());
                new_an.setNombreAni(elemento.getElementsByTagName("nombre").item(0).getTextContent());
                new_an.setClase(elemento.getElementsByTagName("clase").item(0).getTextContent());
                new_an.setNombreCientifico(elemento.getElementsByTagName("nombre_cientifico").item(0).getTextContent());

                int anio = Integer.parseInt(elemento.getElementsByTagName("anio_nacimiento").item(0).getTextContent());
                new_an.setAnioNacNni(anio);

                NodeList clientes_v = elemento.getElementsByTagName("cliente_visto");
                for (int j = 0; j < clientes_v.getLength(); j++) {
                    Element clienteVisto = (Element) clientes_v.item(j);
                    String cl_visto = clienteVisto.getTextContent();

                    for (Cliente cl : clientes) {
                        if (cl.getDNI().equals(cl_visto)) {
                            new_an.setCliente(cl);
                        }
                    }
                }

                String zn_habitadda = elemento.getElementsByTagName("zona_habitada").item(0).getTextContent();

                for (Zona zn : zonas) {
                    if (zn.getIdZona().equals(zn_habitadda)) {
                        new_an.setZonaHabitada(zn);
                    }
                }

                animales.add(new_an);
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        }
    }
    
    public void ExportarClientes(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            documento = dom.createDocument(null, "xml", null);
            
            Element raiz = documento.createElement("clientes");
            documento.getDocumentElement().appendChild(raiz);
            
            Element nodoCliente = null;
            Element nodoDatos = null;
            Element nodoAnimalesVistos = null;
            Element nodoAnimalVisto = null;
            Text texto = null;
            String anio = "";
            
            for(Cliente cli : clientes){
                nodoCliente = documento.createElement("cliente");
                raiz.appendChild(nodoCliente);
                
                nodoDatos = documento.createElement("dni");
                nodoCliente.appendChild(nodoDatos);
                texto = documento.createTextNode(cli.getDNI());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("nombre");
                nodoCliente.appendChild(nodoDatos);
                texto = documento.createTextNode(cli.getNombreCli());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("anio_nacimiento");
                nodoCliente.appendChild(nodoDatos);
                anio = Integer.toString(cli.getAnioNac());
                texto = documento.createTextNode(anio);
                nodoDatos.appendChild(texto);
                
                nodoAnimalesVistos = documento.createElement("animales_vistos");
                nodoCliente.appendChild(nodoAnimalesVistos);
                
                for(Animal an : cli.getVAnimales()){
                    nodoAnimalVisto = documento.createElement("animal_visto");
                    nodoAnimalesVistos.appendChild(nodoAnimalVisto);
                    texto = documento.createTextNode(an.getCodAnimal());
                    nodoAnimalVisto.appendChild(texto);
                }
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt%7Dindent-amount", "2");

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("clientes.xml"));

            transformer.transform(source, resultado);
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(TransformerConfigurationException tce){
            tce.printStackTrace();
        }
        catch(TransformerException te){
            te.printStackTrace();
        }
    }
    
    public void ExportarAnimales(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            documento = dom.createDocument(null, "xml", null);
            
            Element raiz = documento.createElement("animales");
            documento.getDocumentElement().appendChild(raiz);
            
            Element nodoAnimal = null;
            Element nodoDatos = null;
            Element nodoClientesVistos = null;
            Element nodoClienteVisto = null;
            Text texto = null;
            String anio = "";
            
            for(Animal ani : animales){
                nodoAnimal = documento.createElement("animal");
                raiz.appendChild(nodoAnimal);
                
                nodoDatos = documento.createElement("codigo");
                nodoAnimal.appendChild(nodoDatos);
                texto = documento.createTextNode(ani.getCodAnimal());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("nombre");
                nodoAnimal.appendChild(nodoDatos);
                texto = documento.createTextNode(ani.getNombreAni());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("clase");
                nodoAnimal.appendChild(nodoDatos);
                texto = documento.createTextNode(ani.getClase());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("nombre_cientifico");
                nodoAnimal.appendChild(nodoDatos);
                texto = documento.createTextNode(ani.getNombreCientifico());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("anio_nacimiento");
                nodoAnimal.appendChild(nodoDatos);
                anio = Integer.toString(ani.getAnioNacAni());
                texto = documento.createTextNode(anio);
                nodoDatos.appendChild(texto);
                
                nodoClientesVistos = documento.createElement("clientes_vistos");
                nodoAnimal.appendChild(nodoClientesVistos);
                
                for(Cliente cl : ani.getVClientesVistos()){
                    nodoClienteVisto = documento.createElement("cliente_visto");
                    nodoClientesVistos.appendChild(nodoClienteVisto);
                    texto = documento.createTextNode(cl.getDNI());
                    nodoClienteVisto.appendChild(texto);
                }
                
                nodoDatos = documento.createElement("zona_habitada");
                nodoAnimal.appendChild(nodoDatos);
                texto = documento.createTextNode(ani.getZonaHabitada().getIdZona());
                nodoDatos.appendChild(texto);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt%7Dindent-amount", "2");

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("animales.xml"));

            transformer.transform(source, resultado);
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(TransformerConfigurationException tce){
            tce.printStackTrace();
        }
        catch(TransformerException te){
            te.printStackTrace();
        }
    }
    
    public void ExportarZonas(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            documento = dom.createDocument(null, "xml", null);
            
            Element raiz = documento.createElement("zonas");
            documento.getDocumentElement().appendChild(raiz);
            
            Element nodoZonas = null;
            Element nodoDatos = null;
            Element nodoAnimalesHabitan = null;
            Element nodoAnimalHabita = null;
            Text texto = null;
            String capacidad = "";
            String superficie = "";
            
            for(Zona zn : zonas){
                nodoZonas = documento.createElement("zona");
                raiz.appendChild(nodoZonas);
                
                nodoDatos = documento.createElement("id");
                nodoZonas.appendChild(nodoDatos);
                texto = documento.createTextNode(zn.getIdZona());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("bioma");
                nodoZonas.appendChild(nodoDatos);
                texto = documento.createTextNode(zn.getBioma());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("capacidad");
                nodoZonas.appendChild(nodoDatos);
                capacidad = Integer.toString(zn.getCapacidad());
                texto = documento.createTextNode(capacidad);
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("superficie");
                nodoZonas.appendChild(nodoDatos);
                superficie = Double.toString(zn.getSuperficie());
                texto = documento.createTextNode(superficie);
                nodoDatos.appendChild(texto);
                
                nodoAnimalesHabitan = documento.createElement("animales_que_habitan");
                nodoZonas.appendChild(nodoAnimalesHabitan);
                
                for(Animal an : zn.getVAnimalesHabitan()){
                    nodoAnimalHabita = documento.createElement("animal_que_habita");
                    nodoAnimalesHabitan.appendChild(nodoAnimalHabita);
                    texto = documento.createTextNode(an.getCodAnimal());
                    nodoAnimalHabita.appendChild(texto);
                }
                
                nodoDatos = documento.createElement("trabajador_que_cuida");
                nodoZonas.appendChild(nodoDatos);
                texto = documento.createTextNode(zn.getTrabajadorEncargado().getCodTrabajador());
                nodoDatos.appendChild(texto);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt%7Dindent-amount", "2");

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("zonas.xml"));

            transformer.transform(source, resultado);
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(TransformerConfigurationException tce){
            tce.printStackTrace();
        }
        catch(TransformerException te){
            te.printStackTrace();
        }
    }
    
    public void ExportarTrabajadores(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            documento = dom.createDocument(null, "xml", null);
            
            Element raiz = documento.createElement("trabajadores");
            documento.getDocumentElement().appendChild(raiz);
            
            Element nodoTrabajador = null;
            Element nodoDatos = null;
            Text texto = null;
            String gerente = "";
            
            for(Trabajador tr : trabajadores){
                nodoTrabajador = documento.createElement("trabajador");
                raiz.appendChild(nodoTrabajador);
                
                nodoDatos = documento.createElement("codigo");
                nodoTrabajador.appendChild(nodoDatos);
                texto = documento.createTextNode(tr.getCodTrabajador());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("nombre");
                nodoTrabajador.appendChild(nodoDatos);
                texto = documento.createTextNode(tr.getNombreTr());
                nodoDatos.appendChild(texto);
                
                nodoDatos = documento.createElement("numero_telefono");
                nodoTrabajador.appendChild(nodoDatos);
                texto = documento.createTextNode(tr.getNumTelefono());
                nodoDatos.appendChild(texto);
                
                if(tr.getGerente() == true){
                    gerente = "si";
                }
                else{
                    gerente = "no";
                }
                nodoDatos = documento.createElement("gerente");
                nodoTrabajador.appendChild(nodoDatos);
                texto = documento.createTextNode(gerente);
                nodoDatos.appendChild(texto);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt%7Dindent-amount", "2");

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("trabajadores.xml"));

            transformer.transform(source, resultado);
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        catch(TransformerConfigurationException tce){
            tce.printStackTrace();
        }
        catch(TransformerException te){
            te.printStackTrace();
        }
    }
}