/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axela
 */
public class Controlador implements ActionListener{

    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona(); 
    Vista vista = new Vista(); 
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador (Vista v){
        this.vista= v; 
        this.vista.btnListar.addActionListener(this);
    }

 
    @Override
    public void actionPerformed(ActionEvent e) {
       //Escuchador 
       if(e.getSource()== vista.btnListar){
           listar(vista.tabla);
       }
    }
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        
        List<Persona> lista = dao.listar(); 
        Object[] object = new Object[4];
        for(int i=0; i<lista.size(); i++){
            //Revisa todos los campos
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNom();
            object[2] = lista.get(i).getCorreo();
            object[3] = lista.get(i).getTel();
            //Agregamos todo dentro la variable modelo 
            modelo.addRow(object);
        }
        //MOstrat todos los datos en la tabla 
        vista.tabla.setModel(modelo);
        
    }
    
}
