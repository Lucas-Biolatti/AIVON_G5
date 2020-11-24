
package Modelo;

import Entidades.Camp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

public class CampData {
    
    private Connection con;
    
    public CampData(Conexion conexion){
    
        this.con=conexion.getConection();
    }
    
    public void agregarCampaña(Camp c){
        String sql="INSERT INTO camp(fechaInicio, fechaCierre, montoMin, montoMax,estadoCamp) VALUES (?,?,?,?,?)";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(c.getFechaInicio()));
            ps.setDate(2,Date.valueOf(c.getFechaCierre()));
            ps.setDouble(3,c.getMontoMin());
            ps.setDouble(4,c.getMontoMax());
            ps.setBoolean(5,c.isEstadoCamp());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            c.setIdCamp(rs.getInt("idCamp"));
                
            }
            JOptionPane.showMessageDialog(null,"Se agrego la campaña con exito");
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar La campaña");
        }
    }
    
    //solicitamos un id de campala y le seteamos  los datos de otra campaña.
    public void actualizarCampaña(Camp c){
    String sql="UPDATE camp SET fechaInicio=?,fechaCierre=?,montoMin=?,montoMax=? WHERE idCamp=?;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    
    ps.setDate(1,Date.valueOf(c.getFechaInicio()));
    ps.setDate(2,Date.valueOf(c.getFechaCierre()));
    ps.setDouble(3,c.getMontoMin());
    ps.setDouble(3,c.getMontoMax());
    ps.setInt(4,c.getIdCamp());
    
    JOptionPane.showMessageDialog(null,"Se Actualizo la campaña con exito");
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se pudo actualizar la campaña");
    }
    }
    
    public void cerrarCampaña(int id){
    
    String sql="UPDATE camp SET estadoCamp=0 where idCamp=?" ;
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"Se dio de baja a la campaña N°"+id);
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error: No se pudo cerrar Campaña");
    }
    }
    
    //Obtenemos la fecha del ultimo cierre. lo usamos Para dar de baja o no una Revendedora por inactividad.
    public LocalDate cierreUltimaCampaña(){
    LocalDate x=null;
        String sql="SELECT MAX(camp.fechaCierre) AS fechauc FROM `camp` WHERE 1";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ResultSet rs=ps.executeQuery();
    if(rs.next()){
    x=rs.getDate("fechauc").toLocalDate();
        System.out.println("La ultima Campaña cerro el: "+ x);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"No se consiguio la fecha");
    }
    return x;
    }
    
    public Camp buscarCampaña(int id){
        Camp c=null;
    String sql="select * from camp where idCamp=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ResultSet rs= ps.executeQuery();
    if(rs.next()){
    c=new Camp();
    c.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
    c.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
    c.setMontoMin(rs.getDouble("montoMin"));
    c.setMontoMax(rs.getDouble("montoMax"));
    c.setEstadoCamp(rs.getBoolean("estadoCamp"));
    }
    ps.close();
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se encontro Campaña");
    }
    return c;
    }
    public Camp campañaActiva(){
        Camp c=null;
        String sql = "SELECT * FROM camp WHERE estadoCamp=1";
        try{
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            c=new Camp();
            c.setIdCamp(rs.getInt("idCamp"));
            c.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            c.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
            c.setMontoMin(rs.getDouble("montoMin"));
            c.setMontoMax(rs.getDouble("montoMax"));
            c.setEstadoCamp(rs.getBoolean("estadoCamp"));
            
            ps.close();
        }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se encontro la campaña");
        }
        return c;
    }
    
    public int estrellasPorCampaña(int idCamp){
        int x=0;
        String sql = "SELECT SUM(estrellasPedido) AS total FROM `pedido` WHERE `idCamp`=?";
        try{
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idCamp);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        x = rs.getInt("total");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo calcular las estrellas para la campaña");
        }
        return x;
    }
    
    public List<Camp> obtenerCampañas(){
    Camp c;
    List <Camp> campañas = new ArrayList<>();
    String sql = "SELECT * FROM `camp`";
    try{
    PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    c = new Camp();
    c.setIdCamp(rs.getInt("idCamp"));
    c.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
    c.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
    c.setMontoMin(rs.getDouble("montoMin"));
    c.setMontoMax(rs.getDouble("montoMax"));
    c.setEstadoCamp(rs.getBoolean("estadoCamp"));
    campañas.add(c);
    
    }
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se pudo obtener el listado de campañas");
        }
    return campañas;
    }
}
