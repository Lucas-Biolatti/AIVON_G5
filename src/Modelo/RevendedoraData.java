
package Modelo;

import Entidades.Revendedora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;


public class RevendedoraData {
    private Connection con;
    
    public RevendedoraData(Conexion conexion){
    this.con=conexion.getConection();
    }
    
    public void agregarRevendedora(Revendedora r){
    String sql="INSERT INTO revendedora( `telefono`, `mail`, `nombreCompleto`, `dni`, `estado`, `nivel`) VALUES (?,?,?,?,?,?);";
       try{ 
           PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,r.getTel());
           ps.setString(2,r.getMail());
           ps.setString(3,r.getNombreCompleto());
           ps.setString(4,r.getDni());
           ps.setBoolean(5,r.isEstado());
           ps.setInt(6,r.getNivel());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if(rs.next()){
           r.setIdRevendedora(rs.getInt("idRevendedora"));
           
           }
            ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo agregar Revendedora");
        }
    }
    //Preguntar si lo ejecutamos directo del data o como lo podriamos llevar al Revendedora.
    public void actualizarRevendedora(int id,Revendedora r){
    String sql="UPDATE revendedora SET telefono=?,mail=?,nombreCompleto=?,dni=?,estado=?,nivel=? WHERE idRevendedora=?";
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,r.getTel());
        ps.setString(2,r.getMail());
        ps.setString(3,r.getNombreCompleto());
        ps.setString(4,r.getDni());
        ps.setBoolean(5,r.isEstado());
        ps.setInt(6,id);
        ps.setInt(7,r.getNivel());
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"La revendedora con ID: "+id+" Fue actualizada correctamente");
   
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo actualizar la Revendedora");
    }
    
    }
    
    public void darDeBaja(int id){
    String sql="UPDATE revendedora SET estado=0 WHERE idRevendedora=?;";
    
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
    String sql="UPDATE revendedora SET estado=1 WHERE idRevendedora=?;";
    
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
        r.setNivel(rs.getInt("nivel"));
        revendedoras.add(r);
     
    }
            
            
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"No se pudo mostrar la lista");
       }
    return revendedoras;
    }
    
    public LocalDate fechaUltimoPedido(Revendedora r){
    LocalDate x=null;
        String sql="SELECT MAX(pedido.`fechaIngreso`) AS fechaMax FROM `pedido`,detallepedido WHERE pedido.idRevendedora=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,r.getIdRevendedora());
    ResultSet rs=ps.executeQuery();
    if(rs.next()){
    x=rs.getDate("fechaMax").toLocalDate();
        System.out.println("El ultimo pedido se genero el: "+x);
    }
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error: No se pudo obtener fecha");
    }
    return x;
    }
    
}
