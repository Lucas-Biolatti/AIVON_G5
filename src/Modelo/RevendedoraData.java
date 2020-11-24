
package Modelo;

import Entidades.Revendedora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;


public class RevendedoraData {
    private Connection con;
    
    public RevendedoraData(Conexion conexion){
    this.con=conexion.getConection();
    }
    
    public void agregarRevendedora(Revendedora r){
    String sql="INSERT INTO revendedora( telefono, mail, nombreCompleto, dni, estado, nivel) VALUES (?,?,?,?,?,?);";
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
           JOptionPane.showMessageDialog(null, "Revendedora agregada con exito");
           }
            ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo agregar Revendedora");
        }
    }
    //Preguntar si lo ejecutamos directo del data o como lo podriamos llevar al Revendedora.
    public void actualizarRevendedora(Revendedora r){
    String sql="UPDATE revendedora SET telefono=?,mail=?,nombreCompleto=?,dni=?,estado=?,nivel=? WHERE idRevendedora=?";
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,r.getTel());
        ps.setString(2,r.getMail());
        ps.setString(3,r.getNombreCompleto());
        ps.setString(4,r.getDni());
        ps.setBoolean(5,r.isEstado());
        ps.setInt(7,r.getIdRevendedora());
        ps.setInt(6,r.getNivel());
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"La revendedora Fue actualizada correctamente");
   
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
          JOptionPane.showMessageDialog(null, "Se dio de baja exitosamente");
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
          JOptionPane.showMessageDialog(null,"Se dio de Alta exitosamente");
          ps.close();
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo dar de baja");
    }
    }
    
    public List<Revendedora> obtenerRevendedoras(){
    Revendedora r=null;
    List<Revendedora> revendedoras=new ArrayList<>();
    String sql="SELECT * FROM revendedora ";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
        r=new Revendedora();
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
    
    public LocalDate fechaUltimoPedido(int id){
    LocalDate x=null;
        String sql="SELECT MAX(pedido.`fechaIngreso`) AS fechaMax FROM `pedido`,detallepedido WHERE pedido.idRevendedora=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,id);
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
    
    public int estrallasPorRevendedora(int id){
        int x=0;
    String sql="SELECT sum(pedido.estrellasPedido) AS total FROM pedido,revendedora WHERE pedido.idRevendedora=revendedora.idRevendedora and "
            + "pedido.idRevendedora=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,id);
    ResultSet rs=ps.executeQuery();
    if(rs.next()){
    x=rs.getInt("total");
    }else{JOptionPane.showMessageDialog(null,"No se encontraron estrallas para la Revendedora");}
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error: No se pudo obtener las estrellas");
    }
    return x;
    }
    public void modificarNivel(int id){
    
        String sql = "UPDATE revendedora SET nivel=? WHERE idRevendedora=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
    int estrellas=0;
    int n=0;
    int resto=0;
    estrellas=estrallasPorRevendedora(id);
    n=(estrellas/50)+1;
    resto=estrellas%50;
    //if(estrellas<50){
        ps.setInt(1,n);
        ps.setInt(2, id);
        ps.executeUpdate();
        //}
    //else{
    //this.setNivel(n);
        
    //}    
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "No se pudo modificar el nivel");
    }
    }

    public Revendedora buscarRevendedora(int id){
    String sql="Select * from revendedora Where idRevendedora=?;";
        Revendedora r=null;
        try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        r=new Revendedora();
        r.setIdRevendedora(rs.getInt("idRevendedora"));
        r.setTel(rs.getString("telefono"));
        r.setMail(rs.getString("mail"));
        r.setNombreCompleto(rs.getString("nombreCompleto"));
        r.setDni(rs.getString("dni"));
        r.setNivel(rs.getInt("nivel"));
        r.setEstado(rs.getBoolean("estado"));
        }
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se encontro Revendedora");
        }
        return r;
    }
    
    public void comprobarEstado(int id){
        String sql="UPDATE revendedora SET `estado`=? WHERE idRevendedora=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(2, id);
        CampData cd = new CampData(new Conexion());
    LocalDate up = this.fechaUltimoPedido(id);
    LocalDate ucc = cd.cierreUltimaCampaña();
    Calendar inicio=Calendar.getInstance();
        inicio.set(up.getYear(),up.getMonthValue(),up.getDayOfMonth());
        Calendar actual=Calendar.getInstance();
        actual.set(ucc.getYear(),ucc.getMonthValue(),ucc.getDayOfMonth());
        
        long fin=actual.getTimeInMillis();
        long inicioms=inicio.getTimeInMillis();
        
        int dias=(int) (Math.abs((fin-inicioms))/(1000*60*60*24));
        
        if(dias>74 && fin>inicioms){
        ps.setInt(1, 0);
        JOptionPane.showMessageDialog(null, "Esta revendedora fue dada de baja por inactividad");
         }else{
            ps.setInt(1,1);
            JOptionPane.showMessageDialog(null, "El estado es Activo");
        }
        ps.executeUpdate();
        
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo comprobar el estado");
        }
    
    }
}
