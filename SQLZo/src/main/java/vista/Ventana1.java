/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import modelo.Cliente;
import modelo.Animal;
import modelo.Zona;
import modelo.Trabajador;

/**
 *
 * @author Patricia Burgos
 */
public class Ventana1 extends javax.swing.JFrame {

    private Controlador controller;
    private DefaultTableModel tm_cliente;
    private DefaultTableModel tm_animal;
    private DefaultTableModel tm_zona;
    private DefaultTableModel tm_trabajador;
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Animal> animales;
    private ArrayList<Zona> zonas;
    private ArrayList<Trabajador> trabajadores;
    
    private Cliente cliente_aux;
    private Animal animal_aux;
    private Zona zona_aux;
    private Trabajador trabajador_aux;
    
    
    /**
     * Creates new form Ventana1
     */
    public Ventana1() throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException{
        clientes = new ArrayList<>();
        animales = new ArrayList<>();
        zonas = new ArrayList<>();
        trabajadores = new ArrayList<>();
        
        cliente_aux = new Cliente();
        animal_aux = new Animal();
        zona_aux = new Zona();
        trabajador_aux = new Trabajador();
        
        controller = new Controlador(clientes, animales, zonas, trabajadores);
        
        initComponents();
        
        //al cargar la ventana se crean todos los modelos con sus respectivas columnas
        //esto útlimo lo hago aquí porque las columnas no las voy a modificar, sólo las filas
        tm_cliente = new DefaultTableModel();
        tm_cliente.addColumn("dni");
        tm_cliente.addColumn("nombre");
        tm_cliente.addColumn("anio nacimiento");
        
        tm_animal = new DefaultTableModel();
        tm_animal.addColumn("codigo");
        tm_animal.addColumn("nombre");
        tm_animal.addColumn("clase");
        tm_animal.addColumn("nombre cientifico");
        tm_animal.addColumn("anio nacimiento");
        
        tm_zona = new DefaultTableModel();
        tm_zona.addColumn("id");
        tm_zona.addColumn("bioma");
        tm_zona.addColumn("capacidad");
        tm_zona.addColumn("superficie");
        
        tm_trabajador = new DefaultTableModel();
        tm_trabajador.addColumn("codigo");
        tm_trabajador.addColumn("gerente");
        tm_trabajador.addColumn("nombre");
        tm_trabajador.addColumn("numero de telefono");
        
        PrintClientes();
        PrintAnimales();
        PrintZonas();
        PrintTrabajadores();
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_ciudad = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cliente = new javax.swing.JTable();
        add_cli = new javax.swing.JButton();
        modifie_cli = new javax.swing.JButton();
        delete_cli = new javax.swing.JButton();
        jLabel_nombre_ciudad = new javax.swing.JLabel();
        jLabel_pais = new javax.swing.JLabel();
        jLabel_num_habitantes = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        nombre_cli = new javax.swing.JTextField();
        save_cli = new javax.swing.JButton();
        cancel_cli = new javax.swing.JButton();
        anio_cli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        animal_visto = new javax.swing.JTextField();
        insertar_animal_a_cliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        animales_vistos = new javax.swing.JTable();
        eliminar_animal_visto = new javax.swing.JButton();
        jPanel_libro1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Trabajador = new javax.swing.JTable();
        jLabel_nombre_libro1 = new javax.swing.JLabel();
        jLabel_autor1 = new javax.swing.JLabel();
        jLabel_edad_recomendada1 = new javax.swing.JLabel();
        nombre_tr = new javax.swing.JTextField();
        cod_tr = new javax.swing.JTextField();
        save_tr = new javax.swing.JButton();
        cancel_tr = new javax.swing.JButton();
        delete_tr = new javax.swing.JButton();
        modifie_tr = new javax.swing.JButton();
        add_tr = new javax.swing.JButton();
        jLabel_anio_publicacion1 = new javax.swing.JLabel();
        num_telefono = new javax.swing.JTextField();
        canvas1 = new java.awt.Canvas();
        gerente = new javax.swing.JTextField();
        jPanel_biblioteca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Animal = new javax.swing.JTable();
        jLabel_nombre_biblioteca = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        cod_an = new javax.swing.JTextField();
        nombre_an = new javax.swing.JTextField();
        nombre_cientifico = new javax.swing.JTextField();
        save_an = new javax.swing.JButton();
        cancel_an = new javax.swing.JButton();
        add_an = new javax.swing.JButton();
        modifie_an = new javax.swing.JButton();
        delete_an = new javax.swing.JButton();
        jLabel_ciudades_bibliotecas = new javax.swing.JLabel();
        jLabel_ciudades_bibliotecas1 = new javax.swing.JLabel();
        clase = new javax.swing.JTextField();
        anio_nac_an = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clientes_vistos = new javax.swing.JTextField();
        insertar_cliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        zona_habitada = new javax.swing.JTextField();
        Insertar_zona_habitada = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        show_clientes_vistos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        id_zona_habitada = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bioma_zona_habitada = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        capacidad_zona_habitada = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        superficie_zona_habitada = new javax.swing.JLabel();
        eliminar_cliente_visto = new javax.swing.JButton();
        jPanel_libro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Zona = new javax.swing.JTable();
        jLabel_nombre_libro = new javax.swing.JLabel();
        jLabel_autor = new javax.swing.JLabel();
        jLabel_edad_recomendada = new javax.swing.JLabel();
        capacidad = new javax.swing.JTextField();
        id_zona = new javax.swing.JTextField();
        save_zona = new javax.swing.JButton();
        cancel_zona = new javax.swing.JButton();
        delete_zona = new javax.swing.JButton();
        modifie_zona = new javax.swing.JButton();
        add_zona = new javax.swing.JButton();
        jLabel_anio_publicacion = new javax.swing.JLabel();
        superficie = new javax.swing.JTextField();
        bioma = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        animales_habitan = new javax.swing.JTextField();
        insertar_animal_a_zona = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        trabajador_encargado = new javax.swing.JTextField();
        insertar_trabajador = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        show_animales_habitan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        codigo_trabjador_encargada = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        gerente_trabajador_encargado = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nombre_trabajador_encargado = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        numero_telefono_trabajador_encargado = new javax.swing.JLabel();
        eliminar_animal_habita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre_cliente", "Anio_nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Cliente);
        if (Cliente.getColumnModel().getColumnCount() > 0) {
            Cliente.getColumnModel().getColumn(0).setResizable(false);
            Cliente.getColumnModel().getColumn(1).setResizable(false);
            Cliente.getColumnModel().getColumn(2).setResizable(false);
        }

        add_cli.setText("Añadir");
        add_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_cliActionPerformed(evt);
            }
        });

        modifie_cli.setText("Modificar");
        modifie_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifie_cliActionPerformed(evt);
            }
        });

        delete_cli.setText("Borrar");
        delete_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_cliActionPerformed(evt);
            }
        });

        jLabel_nombre_ciudad.setText("DNI");

        jLabel_pais.setText("Nombre_cliente");

        jLabel_num_habitantes.setText("Anio_nacimiento");

        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });

        save_cli.setText("Guardar");
        save_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_cliActionPerformed(evt);
            }
        });

        cancel_cli.setText("Cancelar");
        cancel_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_cliActionPerformed(evt);
            }
        });

        jLabel1.setText("Cod Animales Vistos");

        animal_visto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animal_vistoActionPerformed(evt);
            }
        });

        insertar_animal_a_cliente.setText("Insertar");
        insertar_animal_a_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_animal_a_clienteActionPerformed(evt);
            }
        });

        animales_vistos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod_animal", "Nombre_animal", "Clase", "Nombre_cient", "Anio_nac_an"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(animales_vistos);
        if (animales_vistos.getColumnModel().getColumnCount() > 0) {
            animales_vistos.getColumnModel().getColumn(0).setResizable(false);
            animales_vistos.getColumnModel().getColumn(1).setResizable(false);
            animales_vistos.getColumnModel().getColumn(2).setResizable(false);
            animales_vistos.getColumnModel().getColumn(3).setResizable(false);
            animales_vistos.getColumnModel().getColumn(4).setResizable(false);
        }

        eliminar_animal_visto.setText("Eliminar");
        eliminar_animal_visto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_animal_vistoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ciudadLayout = new javax.swing.GroupLayout(jPanel_ciudad);
        jPanel_ciudad.setLayout(jPanel_ciudadLayout);
        jPanel_ciudadLayout.setHorizontalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nombre_ciudad)
                                    .addComponent(jLabel_pais)
                                    .addComponent(jLabel_num_habitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dni, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(nombre_cli)
                                    .addComponent(anio_cli))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(save_cli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancel_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(add_cli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete_cli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modifie_cli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(animal_visto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(insertar_animal_a_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ciudadLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(eliminar_animal_visto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel_ciudadLayout.setVerticalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addComponent(add_cli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifie_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_cli))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel_nombre_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pais)
                    .addComponent(nombre_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_cli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_num_habitantes)
                    .addComponent(cancel_cli)
                    .addComponent(anio_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(animal_visto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertar_animal_a_cliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminar_animal_visto)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cliente", jPanel_ciudad);

        Trabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo_trabajador", "Gerente", "Nombre_trabajador", "Numero_telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrabajadorMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Trabajador);
        if (Trabajador.getColumnModel().getColumnCount() > 0) {
            Trabajador.getColumnModel().getColumn(0).setResizable(false);
            Trabajador.getColumnModel().getColumn(1).setResizable(false);
            Trabajador.getColumnModel().getColumn(2).setResizable(false);
            Trabajador.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel_nombre_libro1.setText("Codigo_trabajador");

        jLabel_autor1.setText("Gerente");

        jLabel_edad_recomendada1.setText("Nombre_trabajador");

        cod_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_trActionPerformed(evt);
            }
        });

        save_tr.setText("Guardar");
        save_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_trActionPerformed(evt);
            }
        });

        cancel_tr.setText("Cancelar");
        cancel_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_trActionPerformed(evt);
            }
        });

        delete_tr.setText("Borrar");
        delete_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_trActionPerformed(evt);
            }
        });

        modifie_tr.setText("Modificar");
        modifie_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifie_trActionPerformed(evt);
            }
        });

        add_tr.setText("Añadir");
        add_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_trActionPerformed(evt);
            }
        });

        jLabel_anio_publicacion1.setText("Numero_telefono");

        gerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_libro1Layout = new javax.swing.GroupLayout(jPanel_libro1);
        jPanel_libro1.setLayout(jPanel_libro1Layout);
        jPanel_libro1Layout.setHorizontalGroup(
            jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libro1Layout.createSequentialGroup()
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libro1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modifie_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_libro1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_libro1)
                            .addComponent(jLabel_autor1)
                            .addComponent(jLabel_edad_recomendada1)
                            .addComponent(jLabel_anio_publicacion1))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(num_telefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cod_tr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(nombre_tr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gerente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel_tr, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_libro1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel_libro1Layout.setVerticalGroup(
            jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libro1Layout.createSequentialGroup()
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libro1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(add_tr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifie_tr, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_tr))
                    .addGroup(jPanel_libro1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_libro1)
                    .addComponent(cod_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_autor1)
                    .addComponent(save_tr)
                    .addComponent(gerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_edad_recomendada1)
                    .addComponent(nombre_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_tr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_anio_publicacion1)
                    .addComponent(num_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(jPanel_libro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_libro1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane.addTab("Trabajador", jPanel_libro1);

        Animal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo_animal", "Nombre_animal", "Clase", "Nombre_cientifico", "Anio_nacimiento_animal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Animal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnimalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Animal);
        if (Animal.getColumnModel().getColumnCount() > 0) {
            Animal.getColumnModel().getColumn(0).setResizable(false);
            Animal.getColumnModel().getColumn(1).setResizable(false);
            Animal.getColumnModel().getColumn(2).setResizable(false);
            Animal.getColumnModel().getColumn(3).setResizable(false);
            Animal.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel_nombre_biblioteca.setText("Codigo_animal");

        jLabel_telefono.setText("Nombre_animal");

        jLabel_direccion.setText("Nombre_cientifico");

        cod_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_anActionPerformed(evt);
            }
        });

        save_an.setText("Guardar");
        save_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_anActionPerformed(evt);
            }
        });

        cancel_an.setText("Cancelar");
        cancel_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_anActionPerformed(evt);
            }
        });

        add_an.setText("Añadir");
        add_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_anActionPerformed(evt);
            }
        });

        modifie_an.setText("Modificar");
        modifie_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifie_anActionPerformed(evt);
            }
        });

        delete_an.setText("Borrar");
        delete_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_anActionPerformed(evt);
            }
        });

        jLabel_ciudades_bibliotecas.setText("Clase");

        jLabel_ciudades_bibliotecas1.setText("Anio_nacimiento_animal");

        jLabel2.setText("DNI clientes vistos");

        insertar_cliente.setText("Insertar");
        insertar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_clienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Id Zona habitada");

        Insertar_zona_habitada.setText("Insertar");
        Insertar_zona_habitada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insertar_zona_habitadaActionPerformed(evt);
            }
        });

        show_clientes_vistos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Ano Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(show_clientes_vistos);
        if (show_clientes_vistos.getColumnModel().getColumnCount() > 0) {
            show_clientes_vistos.getColumnModel().getColumn(0).setResizable(false);
            show_clientes_vistos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setText("Id Zona habitada");

        id_zona_habitada.setText("no asociada");

        jLabel9.setText("Bioma Zn Hb");

        bioma_zona_habitada.setText("no asociada");

        jLabel10.setText("Capacidad_Zn_Hb");

        capacidad_zona_habitada.setText("no asociada");

        jLabel12.setText("Superficie_Zn_Hb");

        superficie_zona_habitada.setText("no asociada");

        eliminar_cliente_visto.setText("Eliminar");
        eliminar_cliente_visto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_cliente_vistoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_bibliotecaLayout = new javax.swing.GroupLayout(jPanel_biblioteca);
        jPanel_biblioteca.setLayout(jPanel_bibliotecaLayout);
        jPanel_bibliotecaLayout.setHorizontalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modifie_an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(add_an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete_an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_ciudades_bibliotecas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_nombre_biblioteca)
                                            .addComponent(jLabel_telefono)
                                            .addComponent(jLabel_direccion)
                                            .addComponent(jLabel_ciudades_bibliotecas)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(nombre_an, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(nombre_cientifico, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cod_an, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(save_an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cancel_an, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(zona_habitada, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(clientes_vistos)
                                                        .addComponent(anio_nac_an)
                                                        .addComponent(clase, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(insertar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                                    .addComponent(Insertar_zona_habitada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(id_zona_habitada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(bioma_zona_habitada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacidad_zona_habitada))
                .addGap(28, 28, 28)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(superficie_zona_habitada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_bibliotecaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminar_cliente_visto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel_bibliotecaLayout.setVerticalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(add_an)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifie_an, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_an))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_biblioteca)
                    .addComponent(cod_an, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_telefono)
                    .addComponent(nombre_an, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_an))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_direccion)
                    .addComponent(nombre_cientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_an))
                .addGap(20, 20, 20)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ciudades_bibliotecas)
                    .addComponent(clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ciudades_bibliotecas1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio_nac_an, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clientes_vistos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertar_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(zona_habitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Insertar_zona_habitada))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminar_cliente_visto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_zona_habitada)
                    .addComponent(bioma_zona_habitada)
                    .addComponent(capacidad_zona_habitada)
                    .addComponent(superficie_zona_habitada))
                .addGap(20, 20, 20))
        );

        jTabbedPane.addTab("Animal", jPanel_biblioteca);

        Zona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_zona", "Bioma", "Capacidad", "Superficie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Zona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZonaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Zona);
        if (Zona.getColumnModel().getColumnCount() > 0) {
            Zona.getColumnModel().getColumn(0).setResizable(false);
            Zona.getColumnModel().getColumn(1).setResizable(false);
            Zona.getColumnModel().getColumn(2).setResizable(false);
            Zona.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel_nombre_libro.setText("Id_zona");

        jLabel_autor.setText("Bioma");

        jLabel_edad_recomendada.setText("Capacidad");

        id_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_zonaActionPerformed(evt);
            }
        });

        save_zona.setText("Guardar");
        save_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_zonaActionPerformed(evt);
            }
        });

        cancel_zona.setText("Cancelar");
        cancel_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_zonaActionPerformed(evt);
            }
        });

        delete_zona.setText("Borrar");
        delete_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_zonaActionPerformed(evt);
            }
        });

        modifie_zona.setText("Modificar");
        modifie_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifie_zonaActionPerformed(evt);
            }
        });

        add_zona.setText("Añadir");
        add_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_zonaActionPerformed(evt);
            }
        });

        jLabel_anio_publicacion.setText("Superficie");

        jLabel4.setText("Cod Animales");

        animales_habitan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animales_habitanActionPerformed(evt);
            }
        });

        insertar_animal_a_zona.setText("Insertar");
        insertar_animal_a_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_animal_a_zonaActionPerformed(evt);
            }
        });

        jLabel5.setText("Trabajador enc");

        insertar_trabajador.setText("Insertar");
        insertar_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_trabajadorActionPerformed(evt);
            }
        });

        show_animales_habitan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Clase", "Nombre_cientifico", "Anio_nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(show_animales_habitan);
        if (show_animales_habitan.getColumnModel().getColumnCount() > 0) {
            show_animales_habitan.getColumnModel().getColumn(0).setResizable(false);
            show_animales_habitan.getColumnModel().getColumn(1).setResizable(false);
            show_animales_habitan.getColumnModel().getColumn(2).setResizable(false);
            show_animales_habitan.getColumnModel().getColumn(3).setResizable(false);
            show_animales_habitan.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel7.setText("Codigo Trabajador encargado");

        codigo_trabjador_encargada.setText("no asociado");

        jLabel11.setText("Gerente Tr En");

        gerente_trabajador_encargado.setText("no asociado");

        jLabel14.setText("Nombre Tr En");

        nombre_trabajador_encargado.setText("no asociado");

        jLabel16.setText("Numero Telefono Tr En");

        numero_telefono_trabajador_encargado.setText("no asociado");

        eliminar_animal_habita.setText("Eliminar");
        eliminar_animal_habita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_animal_habitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_libroLayout = new javax.swing.GroupLayout(jPanel_libro);
        jPanel_libro.setLayout(jPanel_libroLayout);
        jPanel_libroLayout.setHorizontalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modifie_zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(add_zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete_zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nombre_libro)
                                    .addComponent(jLabel_autor)
                                    .addComponent(jLabel_edad_recomendada)
                                    .addComponent(jLabel_anio_publicacion))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(superficie, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_zona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(capacidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bioma, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(save_zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancel_zona, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(animales_habitan)
                                    .addComponent(trabajador_encargado, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(insertar_animal_a_zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(insertar_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                                        .addComponent(codigo_trabjador_encargada, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(gerente_trabajador_encargado)
                                        .addGap(41, 41, 41))
                                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(nombre_trabajador_encargado))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(numero_telefono_trabajador_encargado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_libroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(eliminar_animal_habita, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel_libroLayout.setVerticalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(add_zona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifie_zona, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_zona))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_libro)
                    .addComponent(id_zona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_autor)
                    .addComponent(save_zona)
                    .addComponent(bioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_edad_recomendada)
                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_zona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_anio_publicacion)
                    .addComponent(superficie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animales_habitan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertar_animal_a_zona)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(trabajador_encargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertar_trabajador))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar_animal_habita)
                .addGap(31, 31, 31)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_trabjador_encargada)
                    .addComponent(gerente_trabajador_encargado)
                    .addComponent(nombre_trabajador_encargado)
                    .addComponent(numero_telefono_trabajador_encargado))
                .addGap(25, 25, 25))
        );

        jTabbedPane.addTab("Zona", jPanel_libro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Ciudad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @brief método que agrega un trabajador al ArrayList de Clientes
     * @param evt 
     * @pre se han debido de rellenar los campos de los textfields de trabajador
     * @post se habrá añadido un nuevo trabajador al sistema
     */
    private void add_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_trActionPerformed
        Trabajador new_tr = new Trabajador();
        new_tr.setCodTrabajador(cod_tr.getText());
        new_tr.setNombreTr(nombre_tr.getText());
        new_tr.setNumTelefono(num_telefono.getText());
        if(gerente.getText().equals("si")){
            new_tr.setGerente(true);
        }
        else{
            new_tr.setGerente(false);
        }
        
        trabajadores.add(new_tr);
        controller.AgregarTrabajador(new_tr);
        PrintTrabajadores();
        
        cod_tr.setText("");
        nombre_tr.setText("");
        num_telefono.setText("");
        gerente.setText("");
    }//GEN-LAST:event_add_trActionPerformed

    /**
     * @brief método que modifica un trabajador seleccionado, imprime sus datos en los textfields
     * @param evt 
     * @post se deberá cancelar o guardar después
     */
    private void modifie_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifie_trActionPerformed
        cod_tr.setText(trabajadores.get(Trabajador.getSelectedRow()).getCodTrabajador());
        nombre_tr.setText(trabajadores.get(Trabajador.getSelectedRow()).getNombreTr());
        num_telefono.setText(trabajadores.get(Trabajador.getSelectedRow()).getNumTelefono());
        if(trabajadores.get(Trabajador.getSelectedRow()).getGerente()){
            gerente.setText("si");
        }
        else{
            gerente.setText("no");
        }
        
        trabajador_aux = trabajadores.get(Trabajador.getSelectedRow());
    }//GEN-LAST:event_modifie_trActionPerformed

    /**
     * @brief elimina el trabajador seleccionaddo
     * @param evt 
     */
    private void delete_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_trActionPerformed
        trabajadores.remove(Trabajador.getSelectedRow());
        controller.EliminarTrabajador(trabajadores.get(Trabajador.getSelectedRow()));
        PrintTrabajadores();
    }//GEN-LAST:event_delete_trActionPerformed

    /**
     * @brief elimina los cambios realizados, simplemente resetea los textfields
     * @param evt 
     */
    private void cancel_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_trActionPerformed
        cod_tr.setText("");
        nombre_tr.setText("");
        num_telefono.setText("");
        gerente.setText("");
        trabajador_aux = null;
    }//GEN-LAST:event_cancel_trActionPerformed

    /**
     * @brief método que guarda los cambios de la modificación de un trabajador
     * @param evt 
     */
    private void save_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_trActionPerformed
        trabajador_aux.setCodTrabajador(cod_tr.getText());
        trabajador_aux.setNombreTr(nombre_tr.getText());
        trabajador_aux.setNumTelefono(num_telefono.getText());
        
        if(gerente.getText().equals("si")){
            trabajador_aux.setGerente(true);
        }
        else{
            trabajador_aux.setGerente(false);
        }
        controller.ModificarTrabajador(trabajador_aux);
        
        PrintTrabajadores();
        trabajador_aux = null;
        
        cod_tr.setText("");
        nombre_tr.setText("");
        num_telefono.setText("");
        gerente.setText("");
    }//GEN-LAST:event_save_trActionPerformed

    private void cod_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_trActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_trActionPerformed

    private void TrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrabajadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TrabajadorMouseClicked

    /**
     * @brief método que agrega una zona al ArrayList de Clientes
     * @param evt 
     * @pre se han debido de rellenar los campos de los textfields de zona
     * @pre el Textfield de la capacidad debe ser un entero y el de superficie un double
     * @post se habrá añadido un nuevo zona al sistema
     */
    private void add_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_zonaActionPerformed
        Zona new_zn = new Zona();
        int new_capacidad = 0;
        double new_superficie = 0.0;
        
        new_zn.setIdZona(id_zona.getText());
        new_zn.setBioma(bioma.getText());
        
        try{
            new_capacidad = Integer.parseInt(capacidad.getText());
            new_superficie = Double.parseDouble(superficie.getText());
        }
        catch (Exception ex){
        }
        
        new_zn.setCapacidad(new_capacidad);
        new_zn.setSuperficie(new_superficie);
        
        zonas.add(new_zn);
        controller.AgregarZona(new_zn);
        PrintZonas();
        
        id_zona.setText("");
        bioma.setText("");
        capacidad.setText("");
        superficie.setText("");
    }//GEN-LAST:event_add_zonaActionPerformed
    
    /**
     * @brief método que modifica una zona seleccionado, imprime sus datos en los textfields
     * @param evt 
     * @post se deberá cancelar o guardar después
     */
    private void modifie_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifie_zonaActionPerformed
        String new_capacidad = "50";
        String new_superficie = "50.0";
        id_zona.setText(zonas.get(Zona.getSelectedRow()).getIdZona());
        bioma.setText(zonas.get(Zona.getSelectedRow()).getBioma());
        
        try{
            new_capacidad = Integer.toString(zonas.get(Zona.getSelectedRow()).getCapacidad());
            new_superficie = Double.toString(zonas.get(Zona.getSelectedRow()).getSuperficie());
        }
        catch(Exception ex){
        }
        
        capacidad.setText(new_capacidad);
        superficie.setText(new_superficie);
        zona_aux = zonas.get(Zona.getSelectedRow());
    }//GEN-LAST:event_modifie_zonaActionPerformed

    /**
     * @brief elimina el zona seleccionaddo
     * @param evt 
     */
    private void delete_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_zonaActionPerformed
        zonas.remove(Zona.getSelectedRow());
        controller.EliminarZonas(zonas.get(Zona.getSelectedRow()));
        PrintZonas();
    }//GEN-LAST:event_delete_zonaActionPerformed

    /**
     * @brief elimina los cambios realizados, simplemente resetea los textfields
     * @param evt 
     */
    private void cancel_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_zonaActionPerformed
        id_zona.setText("");
        bioma.setText("");
        capacidad.setText("");
        superficie.setText("");
        zona_aux = null;
    }//GEN-LAST:event_cancel_zonaActionPerformed

    /**
     * @brief método que guarda los cambios de la modificación de una zona
     * @param evt 
     */
    private void save_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_zonaActionPerformed
        int cp= 0;
        double sp = 0.0;
        zona_aux.setIdZona(id_zona.getText());
        zona_aux.setBioma(bioma.getText());
        
        try{
            cp = Integer.valueOf(anio_cli.getText());
            sp = Double.valueOf(superficie.getText());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        zona_aux.setCapacidad(cp);
        zona_aux.setSuperficie(sp);
        
        controller.ModificarZona(zona_aux);
        
        PrintZonas();
        zona_aux = null;
        
        id_zona.setText("");
        bioma.setText("");
        capacidad.setText("");
        superficie.setText("");
    }//GEN-LAST:event_save_zonaActionPerformed

    private void id_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_zonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_zonaActionPerformed

    private void ZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZonaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ZonaMouseClicked

    /**
     * @brief elimina el animal seleccionaddo
     * @param evt 
     */
    private void delete_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_anActionPerformed
        animales.remove(Animal.getSelectedRow());
        controller.EliminarAnimal(animales.get(Animal.getSelectedRow()));
        PrintAnimales();
    }//GEN-LAST:event_delete_anActionPerformed
    
    /**
     * @brief método que modifica un animal seleccionado, imprime sus datos en los textfields
     * @param evt 
     * @post se deberá cancelar o guardar después
     */
    private void modifie_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifie_anActionPerformed
        String new_anio = "1945";
        cod_an.setText(animales.get(Animal.getSelectedRow()).getCodAnimal());
        nombre_an.setText(animales.get(Animal.getSelectedRow()).getNombreAni());
        nombre_cientifico.setText(animales.get(Animal.getSelectedRow()).getNombreCientifico());
        clase.setText(animales.get(Animal.getSelectedRow()).getClase());
        
        try{
            new_anio = Integer.toString(animales.get(Animal.getSelectedRow()).getAnioNacAni());
        }
        catch(Exception ex){
        }
        
        anio_nac_an.setText(new_anio);
        animal_aux = animales.get(Animal.getSelectedRow());
    }//GEN-LAST:event_modifie_anActionPerformed

    /**
     * @brief método que agrega un animal al ArrayList de Animales
     * @param evt 
     * @pre se han debido de rellenar los campos de los textfields de animal
     * @pre el Textfield del anio de nac de animal debe ser un entero
     * @post se habrá añadido un nuevo animal al sistema
     */
    private void add_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_anActionPerformed
        Animal new_an = new Animal();
        int anio = 0;
        new_an.setCodAnimal(cod_an.getText());
        new_an.setNombreAni(nombre_an.getText());
        new_an.setClase(clase.getText());
        new_an.setNombreCientifico(nombre_cientifico.getText());
        
        try{
            anio = Integer.parseInt(anio_nac_an.getText());
        }
        catch (Exception ex){
        }
        
        new_an.setAnioNacNni(anio);
        
        animales.add(new_an);
        controller.AgregarAnimal(new_an);
        PrintAnimales();
        
        cod_an.setText("");
        nombre_an.setText("");
        nombre_cientifico.setText("");
        clase.setText("");
        anio_nac_an.setText("");
    }//GEN-LAST:event_add_anActionPerformed

    /**
     * @brief elimina los cambios realizados, simplemente resetea los textfields
     * @param evt 
     */
    private void cancel_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_anActionPerformed
        cod_an.setText("");
        nombre_an.setText("");
        nombre_cientifico.setText("");
        clase.setText("");
        anio_nac_an.setText("");
        animal_aux = null;
    }//GEN-LAST:event_cancel_anActionPerformed

    /**
     * @brief método que guarda los cambios de la modificación de un animal
     * @param evt 
     */
    private void save_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_anActionPerformed
        int anio = 0;
        animal_aux.setCodAnimal(cod_an.getText());
        animal_aux.setNombreAni(nombre_an.getText());
        animal_aux.setClase(clase.getText());
        animal_aux.setNombreCientifico(nombre_cientifico.getText());
        
        try{
            anio = Integer.valueOf(anio_nac_an.getText());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        animal_aux.setAnioNacNni(anio);
        controller.ModificarAnimal(animal_aux);
        
        PrintAnimales();
        animal_aux = null;
        
        cod_an.setText("");
        nombre_an.setText("");
        nombre_cientifico.setText("");
        clase.setText("");
        anio_nac_an.setText("");
    }//GEN-LAST:event_save_anActionPerformed

    private void cod_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_anActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_anActionPerformed

    private void AnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnimalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AnimalMouseClicked

    /**
     * @brief elimina los cambios realizados, simplemente resetea los textfields
     * @param evt 
     */
    private void cancel_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_cliActionPerformed
        dni.setText("");
        nombre_cli.setText("");
        anio_cli.setText("");
        cliente_aux = null;
    }//GEN-LAST:event_cancel_cliActionPerformed

    /**
     * @brief método que guarda los cambios de la modificación de un cliente
     * @param evt 
     */
    private void save_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_cliActionPerformed
        int anio = 0;
        cliente_aux.setDNI(dni.getText());
        cliente_aux.setNombreCli(nombre_cli.getText());
        
        try{
            anio = Integer.valueOf(anio_cli.getText());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        cliente_aux.setAnioNac(anio);
        controller.ModificarCliente(cliente_aux);
        
        PrintClientes();
        cliente_aux = null;
        
        dni.setText("");
        nombre_cli.setText("");
        anio_cli.setText("");
    }//GEN-LAST:event_save_cliActionPerformed

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniActionPerformed

    /**
     * @brief elimina el cliente seleccionaddo
     * @param evt 
     */
    private void delete_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_cliActionPerformed
        clientes.remove(Cliente.getSelectedRow());
        controller.EliminarCliente(clientes.get(Cliente.getSelectedRow()));
        PrintClientes();
    }//GEN-LAST:event_delete_cliActionPerformed

    /**
     * @brief método que modifica un cliente seleccionado, imprime sus datos en los textfields
     * @param evt 
     * @post se deberá cancelar o guardar después
     */
    private void modifie_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifie_cliActionPerformed
        String new_anio = "1945";
        dni.setText(clientes.get(Cliente.getSelectedRow()).getDNI());
        nombre_cli.setText(clientes.get(Cliente.getSelectedRow()).getNombreCli());
        
        try{
            new_anio = Integer.toString(clientes.get(Cliente.getSelectedRow()).getAnioNac());
        }
        catch(Exception ex){
        }
        
        anio_cli.setText(new_anio);
        cliente_aux = clientes.get(Cliente.getSelectedRow());
    }//GEN-LAST:event_modifie_cliActionPerformed

    /**
     * @brief método que agrega un cliente al ArrayList de Clientes
     * @param evt 
     * @pre se han debido de rellenar los campos de los textfields de cliente
     * @pre el Textfield del anio de nac debe ser un entero
     * @post se habrá añadido un nuevo cliente al sistema
     */
    private void add_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_cliActionPerformed
        Cliente new_cli = new Cliente();
        int anio = 0;
        new_cli.setDNI(dni.getText());
        new_cli.setNombreCli(nombre_cli.getText());
        
        try{
            anio = Integer.parseInt(anio_cli.getText());
        }
        catch (Exception ex){
        }
        
        new_cli.setAnioNac(anio);
        
        clientes.add(new_cli);
        controller.AgregarCliente(new_cli);
        PrintClientes();
        
        dni.setText("");
        nombre_cli.setText("");
        anio_cli.setText("");
    }//GEN-LAST:event_add_cliActionPerformed

    private void ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteMouseClicked

    private void gerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gerenteActionPerformed

    private void animal_vistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animal_vistoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animal_vistoActionPerformed

    private void animales_habitanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animales_habitanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animales_habitanActionPerformed

    /**
     * @brief método que permite insertar una animal en un cliente
     * @param evt 
     * @pre se ha debido de seleccionar un cliente e insertado un codigo de animal
     */
    private void insertar_animal_a_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_animal_a_clienteActionPerformed
        cliente_aux = clientes.get(Cliente.getSelectedRow());
        Boolean existe = false;
        
        for (Animal an : animales){
            //esta condición comprueba si el código insertado existe
            if (an.getCodAnimal().equals(animal_visto.getText())){
                //en este for each se comprueban los animales que hay en el cliente seleccionado,
                //si el animal ya estaba insertado no se inserta, else se inserta
                for (Animal an_vistos : cliente_aux.getVAnimales()){
                    if(an_vistos.getCodAnimal().equals(animal_visto.getText())){
                        existe = true;
                    }
                }
                if (existe == false){
                    cliente_aux.setAnimal(an);
                    controller.AgregarVer(cliente_aux, an);
                    //System.out.println("insertado");
                }
            }
        }
        PrintAnimalesVistos();
    }//GEN-LAST:event_insertar_animal_a_clienteActionPerformed

    /**
     * @brief método que permite insertar una animal en una zona
     * @param evt 
     * @pre se ha debido de seleccionar una zona e insertado un codigo de animal
     */
    private void insertar_animal_a_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_animal_a_zonaActionPerformed
        zona_aux = zonas.get(Zona.getSelectedRow());
        Boolean existe = false;
        
        for (Animal an : animales){
            //esta condición comprueba si el código insertado existe
            if (an.getCodAnimal().equals(animales_habitan.getText())){
                //en este for each se comprueban los animales que hay en la zona seleccionada,
                //si el animal ya estaba insertado no se inserta, else se inserta
                for (Animal an_habitados : zona_aux.getVAnimalesHabitan()){
                    if(an_habitados.getCodAnimal().equals(animales_habitan.getText())){
                        existe = true;
                    }
                }
                if (existe == false){
                    zona_aux.setAnimalHabita(an);
                }
            }
        }
        PrintAnimalesHabitan();
    }//GEN-LAST:event_insertar_animal_a_zonaActionPerformed

    /**
     * @brief método que permite insertar un cliente en un animal
     * @param evt 
     * @pre se ha debido de seleccionar un animal e insertado un dni de cliente
     */
    private void insertar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_clienteActionPerformed
        animal_aux = animales.get(Animal.getSelectedRow());
        Boolean existe = false;
        
        for (Cliente cl : clientes){
            //esta condición comprueba si el código insertado existe
            if (cl.getDNI().equals(clientes_vistos.getText())){
                //en este for each se comprueban los clientes que hay en el animal seleccionado,
                //si el cliente ya estaba insertado no se inserta, else se inserta
                for (Cliente cl_vistos : animal_aux.getVClientesVistos()){
                    if(cl_vistos.getDNI().equals(clientes_vistos.getText())){
                        existe = true;
                    }
                }
                if (existe == false){
                    animal_aux.setCliente(cl);
                    controller.AgregarVer(cl, animal_aux);
                }
            }
        }
        PrintClientesVistos();
    }//GEN-LAST:event_insertar_clienteActionPerformed

    /**
     * @brief método que permite añadir la zona en la que habita un animal
     * @param evt 
     * @pre se ha debido de seleccionar un animal e insertado un id de zona
     */
    private void Insertar_zona_habitadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insertar_zona_habitadaActionPerformed
        animal_aux = animales.get(Animal.getSelectedRow());
        
        for (Zona zn : zonas){
            //se comprueba si la zona insertada existe
            if(zn.getIdZona().equals(zona_habitada.getText())){
                //si existe se inserta en el animal seleccionado
                //si ya había una, se modifica, sino se inserta
                animal_aux.setZonaHabitada(zn);
                controller.ModificarZonaHabitada(animal_aux, zn);
            }
        }
        PrintZonaHabitada();
    }//GEN-LAST:event_Insertar_zona_habitadaActionPerformed

    /**
     * @brief método que permite añadir el trabajador encargado de una zona
     * @param evt 
     * @pre se ha debido de seleccionar una zona e insertado un codigo de trabajador
     */
    private void insertar_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_trabajadorActionPerformed
        zona_aux = zonas.get(Zona.getSelectedRow());
        
        for (Trabajador tr : trabajadores){
            //se comprueba si el trabajador insertado existe
            if(tr.getCodTrabajador().equals(trabajador_encargado.getText())){
                //si existe se inserta en la zona seleccionada
                //si ya había uno, se modifica, sino se inserta
                zona_aux.setTrabajadorEncargado(tr);
                controller.ModificarTrabajadorEncargado(zona_aux, tr);
            }
        }
        PrintTrabajadorEncargado();
    }//GEN-LAST:event_insertar_trabajadorActionPerformed

    private void eliminar_animal_vistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_animal_vistoActionPerformed
        cliente_aux.getVAnimales().remove(Animal.getSelectedRow());
        controller.EliminarVer(animales.get(Animal.getSelectedRow()), cliente_aux);
        PrintAnimalesVistos();
    }//GEN-LAST:event_eliminar_animal_vistoActionPerformed

    private void eliminar_cliente_vistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_cliente_vistoActionPerformed
        animal_aux.getVClientesVistos().remove(Cliente.getSelectedRow());
        controller.EliminarVer(animal_aux, clientes.get(Cliente.getSelectedRow()));
        PrintClientesVistos();
    }//GEN-LAST:event_eliminar_cliente_vistoActionPerformed

    private void eliminar_animal_habitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_animal_habitaActionPerformed
        zona_aux.getVAnimalesHabitan().remove(Animal.getSelectedRow());
        PrintAnimalesHabitan();
    }//GEN-LAST:event_eliminar_animal_habitaActionPerformed

    /**
     * @brief método que permite mostrar todos los clientes al usuario
     * @post se habrá imprimido los clientes, 
     */
    private void PrintClientes(){
        if(tm_cliente.getRowCount() > 0){
            tm_cliente.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_cliente.getRowCount(); i++){
            tm_cliente.removeRow(i);
        }
        
        String new_dni = "";
        String new_nombre = "";
        int new_anio = 0;
        
        //este bucle inserta cada cliente a cada fila del modelo
        for(int i=0; i < clientes.size(); i++){
            new_dni = clientes.get(i).getDNI();
            new_nombre = clientes.get(i).getNombreCli();
            new_anio = clientes.get(i).getAnioNac();
            
            tm_cliente.addRow(new Object[]{new_dni, new_nombre, new_anio});
        }
        
        //asigna el modelo al JTable de cliente
        Cliente.setModel(tm_cliente);
    }
    
    /**
     * @brief método que permite mostrar todos los animales al usuario
     * @post se habrán imprimido los animales, 
     */
    private void PrintAnimales(){
        if(tm_animal.getRowCount() > 0){
            tm_animal.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_animal.getRowCount(); i++){
            tm_animal.removeRow(i);
        }
        
        String new_cod = "";
        String new_nombre = "";
        String new_clase = "";
        String new_nombre_cientifico = "";
        int new_anio = 0;
        
        //este bucle inserta cada animal a cada fila del modelo
        for(int i=0; i < animales.size(); i++){
            new_cod = animales.get(i).getCodAnimal();
            new_nombre = animales.get(i).getNombreAni();
            new_clase = animales.get(i).getClase();
            new_nombre_cientifico = animales.get(i).getNombreCientifico();
            new_anio = animales.get(i).getAnioNacAni();
            
            tm_animal.addRow(new Object[]{new_cod, new_nombre, new_clase, new_nombre_cientifico, new_anio});
        }
        
        //asigna el modelo al JTable de animal
        Animal.setModel(tm_animal);
    }
    
    /**
     * @brief método que permite mostrar todos los clientes al usuario
     * @post se habrá imprimido los clientes, 
     */
    private void PrintZonas(){
        if(tm_zona.getRowCount() > 0){
            tm_zona.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_zona.getRowCount(); i++){
            tm_zona.removeRow(i);
        }
        
        String new_id = "";
        String new_bioma = "";
        int new_capacidad = 0;
        double new_superficie = 0.0;
        
        //este bucle inserta cada zona a cada fila del modelo
        for(int i=0; i < zonas.size(); i++){
            new_id = zonas.get(i).getIdZona();
            new_bioma = zonas.get(i).getBioma();
            new_capacidad = zonas.get(i).getCapacidad();
            new_superficie = zonas.get(i).getSuperficie();
            
            tm_zona.addRow(new Object[]{new_id, new_bioma, new_capacidad, new_superficie});
        }
        
        //asigna el modelo al JTable de zona
        Zona.setModel(tm_zona);
    }
    
    /**
     * @brief método que permite mostrar todos los trabajadores al usuario
     * @param al_trabajadores (E), ArrayList que contiene todos los trabajadores del sistema
     * @post se habrá imprimido los trabajadores
     */
    private void PrintTrabajadores(){
        if(tm_trabajador.getRowCount() > 0){
            tm_trabajador.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_trabajador.getRowCount(); i++){
            tm_trabajador.removeRow(i);
        }
        
        String new_codigo = "";
        String new_nombre = "";
        String new_numero = "";
        String new_gerente = "";
        
        //este bucle inserta cada zona a cada fila del modelo
        for(int i=0; i < trabajadores.size(); i++){
            new_codigo = trabajadores.get(i).getCodTrabajador();
            new_nombre = trabajadores.get(i).getNombreTr();
            new_numero = trabajadores.get(i).getNumTelefono();
            
            if(trabajadores.get(i).getGerente() == true){
                new_gerente = "si";
            }
            else{
                new_gerente = "no";
            }
            
            tm_trabajador.addRow(new Object[]{new_codigo, new_gerente, new_nombre, new_numero});
        }
        
        //asigna el modelo al JTable de trabajador
        Trabajador.setModel(tm_trabajador);
    }
    
    private void PrintAnimalesVistos(){
        if(tm_animal.getRowCount() > 0){
            tm_animal.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_animal.getRowCount(); i++){
            tm_animal.removeRow(i);
        }
        
        String new_codigo = "";
        String new_nombre = "";
        String new_clase = "";
        String new_nombre_cient = "";
        int new_anio;
        
        //este bucle inserta cada zona a cada fila del modelo
        for(int i=0; i < cliente_aux.getVAnimales().size(); i++){
            new_codigo = cliente_aux.getVAnimales().get(i).getCodAnimal();
            new_nombre = cliente_aux.getVAnimales().get(i).getNombreAni();
            new_clase = cliente_aux.getVAnimales().get(i).getClase();
            new_nombre_cient = cliente_aux.getVAnimales().get(i).getNombreCientifico();
            new_anio = cliente_aux.getVAnimales().get(i).getAnioNacAni();
            
            tm_animal.addRow(new Object[]{new_codigo, new_clase, new_nombre, new_nombre_cient, new_anio});
        }
        animales_vistos.setModel(tm_animal);
    }
    
    private void PrintAnimalesHabitan(){
        if(tm_animal.getRowCount() > 0){
            tm_animal.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_animal.getRowCount(); i++){
            tm_animal.removeRow(i);
        }
        
        String new_codigo = "";
        String new_nombre = "";
        String new_clase = "";
        String new_nombre_cient = "";
        int new_anio;
        
        //este bucle inserta cada zona a cada fila del modelo
        for(int i=0; i < zona_aux.getVAnimalesHabitan().size(); i++){
            new_codigo = zona_aux.getVAnimalesHabitan().get(i).getCodAnimal();
            new_nombre = zona_aux.getVAnimalesHabitan().get(i).getNombreAni();
            new_clase = zona_aux.getVAnimalesHabitan().get(i).getClase();
            new_nombre_cient = zona_aux.getVAnimalesHabitan().get(i).getNombreCientifico();
            new_anio = zona_aux.getVAnimalesHabitan().get(i).getAnioNacAni();
            
            tm_animal.addRow(new Object[]{new_codigo, new_clase, new_nombre, new_nombre_cient, new_anio});
        }
        show_animales_habitan.setModel(tm_animal);
    }
    
    private void PrintClientesVistos(){
        if(tm_cliente.getRowCount() > 0){
            tm_cliente.removeRow(0);
        }
        
        //elimina cada fila del modelo, esto se hace porque luego se copia el ArrayList entero
        for(int i=0; i < tm_cliente.getRowCount(); i++){
            tm_cliente.removeRow(i);
        }
        
        String new_dni = "";
        String new_nombre = "";
        int new_anio;
        
        //este bucle inserta cada zona a cada fila del modelo
        for(int i=0; i < animal_aux.getVClientesVistos().size(); i++){
            new_dni = animal_aux.getVClientesVistos().get(i).getDNI();
            new_nombre = animal_aux.getVClientesVistos().get(i).getNombreCli();
            new_anio = animal_aux.getVClientesVistos().get(i).getAnioNac();
            
            tm_cliente.addRow(new Object[]{new_dni, new_nombre, new_anio});
        }
        show_clientes_vistos.setModel(tm_cliente);
    }
    
    private void PrintZonaHabitada(){
        id_zona_habitada.setText(animal_aux.getZonaHabitada().getIdZona());
        bioma_zona_habitada.setText(animal_aux.getZonaHabitada().getBioma());
        try{
           capacidad_zona_habitada.setText(Integer.toString(animal_aux.getZonaHabitada().getCapacidad())); 
           superficie_zona_habitada.setText(Double.toString(animal_aux.getZonaHabitada().getSuperficie()));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void PrintTrabajadorEncargado(){
        codigo_trabjador_encargada.setText(zona_aux.getTrabajadorEncargado().getCodTrabajador());
        numero_telefono_trabajador_encargado.setText(zona_aux.getTrabajadorEncargado().getNumTelefono());
        nombre_trabajador_encargado.setText(zona_aux.getTrabajadorEncargado().getNombreTr());
        if(zona_aux.getTrabajadorEncargado().getGerente() == true){
           gerente_trabajador_encargado.setText("si"); 
        }
        else{
            gerente_trabajador_encargado.setText("no");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt){
        controller.getConexion().CerrarConexion();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Animal;
    private javax.swing.JTable Cliente;
    private javax.swing.JButton Insertar_zona_habitada;
    private javax.swing.JTable Trabajador;
    private javax.swing.JTable Zona;
    private javax.swing.JButton add_an;
    private javax.swing.JButton add_cli;
    private javax.swing.JButton add_tr;
    private javax.swing.JButton add_zona;
    private javax.swing.JTextField animal_visto;
    private javax.swing.JTextField animales_habitan;
    private javax.swing.JTable animales_vistos;
    public javax.swing.JTextField anio_cli;
    public javax.swing.JTextField anio_nac_an;
    public javax.swing.JTextField bioma;
    private javax.swing.JLabel bioma_zona_habitada;
    private javax.swing.JButton cancel_an;
    private javax.swing.JButton cancel_cli;
    public javax.swing.JButton cancel_tr;
    public javax.swing.JButton cancel_zona;
    private java.awt.Canvas canvas1;
    private javax.swing.JTextField capacidad;
    private javax.swing.JLabel capacidad_zona_habitada;
    public javax.swing.JTextField clase;
    private javax.swing.JTextField clientes_vistos;
    public javax.swing.JTextField cod_an;
    private javax.swing.JTextField cod_tr;
    private javax.swing.JLabel codigo_trabjador_encargada;
    private javax.swing.JButton delete_an;
    private javax.swing.JButton delete_cli;
    private javax.swing.JButton delete_tr;
    private javax.swing.JButton delete_zona;
    public javax.swing.JTextField dni;
    private javax.swing.JButton eliminar_animal_habita;
    private javax.swing.JButton eliminar_animal_visto;
    private javax.swing.JButton eliminar_cliente_visto;
    private javax.swing.JTextField gerente;
    private javax.swing.JLabel gerente_trabajador_encargado;
    private javax.swing.JTextField id_zona;
    private javax.swing.JLabel id_zona_habitada;
    private javax.swing.JButton insertar_animal_a_cliente;
    private javax.swing.JButton insertar_animal_a_zona;
    private javax.swing.JButton insertar_cliente;
    private javax.swing.JButton insertar_trabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_anio_publicacion;
    private javax.swing.JLabel jLabel_anio_publicacion1;
    private javax.swing.JLabel jLabel_autor;
    private javax.swing.JLabel jLabel_autor1;
    private javax.swing.JLabel jLabel_ciudades_bibliotecas;
    private javax.swing.JLabel jLabel_ciudades_bibliotecas1;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_edad_recomendada;
    private javax.swing.JLabel jLabel_edad_recomendada1;
    private javax.swing.JLabel jLabel_nombre_biblioteca;
    private javax.swing.JLabel jLabel_nombre_ciudad;
    private javax.swing.JLabel jLabel_nombre_libro;
    private javax.swing.JLabel jLabel_nombre_libro1;
    private javax.swing.JLabel jLabel_num_habitantes;
    private javax.swing.JLabel jLabel_pais;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JPanel jPanel_biblioteca;
    private javax.swing.JPanel jPanel_ciudad;
    private javax.swing.JPanel jPanel_libro;
    private javax.swing.JPanel jPanel_libro1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton modifie_an;
    private javax.swing.JButton modifie_cli;
    private javax.swing.JButton modifie_tr;
    private javax.swing.JButton modifie_zona;
    public javax.swing.JTextField nombre_an;
    public javax.swing.JTextField nombre_cientifico;
    public javax.swing.JTextField nombre_cli;
    private javax.swing.JTextField nombre_tr;
    private javax.swing.JLabel nombre_trabajador_encargado;
    private javax.swing.JTextField num_telefono;
    private javax.swing.JLabel numero_telefono_trabajador_encargado;
    private javax.swing.JButton save_an;
    private javax.swing.JButton save_cli;
    public javax.swing.JButton save_tr;
    public javax.swing.JButton save_zona;
    private javax.swing.JTable show_animales_habitan;
    private javax.swing.JTable show_clientes_vistos;
    private javax.swing.JTextField superficie;
    private javax.swing.JLabel superficie_zona_habitada;
    private javax.swing.JTextField trabajador_encargado;
    private javax.swing.JTextField zona_habitada;
    // End of variables declaration//GEN-END:variables
    /*private ArrayList<Ciudad> ciudades;
    private Ciudad ciudad_modificar;
    private DefaultTableModel table_model_ciudad;    
    private Boolean modif_ciudad;
    private int id_ciudad;
    
    private ArrayList<Biblioteca> bibliotecas;
    private Biblioteca biblioteca_modificar;
    private DefaultTableModel table_model_biblioteca;    
    private Boolean modif_biblioteca;
    private int id_biblioteca;
    
    private ArrayList<Libro> libros;
    private Libro libro_modificar;
    private DefaultTableModel table_model_libro;    
    private Boolean modif_libro;
    private int id_libro;
    
    private ArrayList<Persona> personas;
    private Persona persona_modificar;
    private DefaultTableModel table_model_persona;    
    private Boolean modif_persona;
    private int id_persona;*/
}