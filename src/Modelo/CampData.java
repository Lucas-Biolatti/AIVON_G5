
package Modelo;

import Entidades.Camp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
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
                
            }else{JOptionPane.showMessageDialog(null,"No se pudo setear el ID");}
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar La campaña");
        }
    }
    
    public void actualizarCampaña(int id,Camp c){
    String sql="UPDATE camp SET fechaInicio=?,fechaCierre=?,montoMin=?,montoMax=? WHERE idCamp=?;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    
    ps.setDate(1,Date.valueOf(c.getFechaInicio()));
    ps.setDate(2,Date.valueOf(c.getFechaCierre()));
    ps.setDouble(3,c.getMontoMin());
    ps.setDouble(3,c.getMontoMax());
    ps.setInt(4,id);
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se pudo actualizar la campaña");
    }
    }
}
