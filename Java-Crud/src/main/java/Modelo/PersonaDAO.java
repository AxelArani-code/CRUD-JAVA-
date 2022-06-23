/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author axela
 */
public class PersonaDAO {
    Conexion conectar  = new Conexion();
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql = "select * from persona";
    
    public List listar(){
        List <Persona>datos = new ArrayList<>();  
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Persona p = new Persona(); 
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                datos.add(p);
                
            }
        }catch(Exception e){
        }
        
        return datos; 
    }
}
