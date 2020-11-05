/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Revendedora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author lbiolatti
 */
public class RevendedoraData {
    private Connection con;
    
    public RevendedoraData(Conexion conexion){
    this.con=conexion.getConection();
    }
    
    public void agregarRevendedora(Revendedora r){
    String sql="INSERT INTO revendedora(telefono,mail,nombreCompleto,dni,estado) VALUES (?,?,?,?,?)";
       try{ 
           PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,r.getTel());
           ps.setString(2,r.getMail());
           ps.setString(3,r.getNombreCompleto());
           ps.setString(4,r.getDni());
           ps.setBoolean(5,r.isEstado());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if(rs.next()){
           r.setIdRevendedora(rs.getInt("idRevendedora"));
           ps.close();
           }else {
               JOptionPane.showMessageDialog(null,"No se encontro el ID");
           }
           
           
           
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo agregar Revendedora");
        }
    }
    
    public void actualizarRevendedora(int id,Revendedora r){
    String sql="UPDATE revendedora SET telefono=?,mail=?,nombreCompleto=?,dni=?,estado=?, WHERE idRevendedora=?";
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,r.getTel());
        ps.setString(2,r.getMail());
        ps.setString(3,r.getNombreCompleto());
        ps.setString(4,r.getDni());
        ps.setBoolean(5,r.isEstado());
        ps.setInt(6,id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"La revendedora con ID: "+id+" Fue actualizada correctamente");
   
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo actualizar la Revendedora");
    }
    
    }
    
    public void darDeBaja(int id){
    String sql="UPDATE revendedora SET estado=0, WHERE idRevendedora=?;";
    
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          ps.executeUpdate();
          ps.close();
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo dar de baja");
    }
    }
    public void darDeAlta(int id){
    String sql="UPDATE revendedora SET estado=1, WHERE idRevendedora=?;";
    
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          ps.executeUpdate();
          ps.close();
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo dar de baja");
    }
    }
    
    
    public List<Revendedora> obtenerRevendedoras(){
    Revendedora r=new Revendedora();
    List<Revendedora> revendedoras=new ArrayList<>();
    String sql="SELECT * FROM revendedora WHERE estado=1";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
        r.setTel(rs.getString("telefono"));
        r.setMail(rs.getString("mail"));
        r.setNombreCompleto(rs.getString("nombreCompleto"));
        r.setDni(rs.getString("dni"));
        r.setEstado(rs.getBoolean("estado"));
        r.setIdRevendedora(rs.getInt("idRevendedora"));
        revendedoras.add(r);
     
    }
            
            
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"No se pudo mostrar la lista");
       }
    return revendedoras;
    }
    
    
    
}
