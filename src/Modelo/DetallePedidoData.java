
package Modelo;

import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallePedidoData {
    
    private Connection con;
    
    public DetallePedidoData(Conexion conexion){
    this.con=conexion.getConection();
    }
    
    public void agregarDetallePedido(DetallePedido dp){
    
        String sql="INSERT INTO detallepedido(idPedido, idProducto,cantidad) VALUES (?,?,?);";
        try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,dp.getPedido().getIdPedido());
        ps.setInt(2,dp.getProducto().getIdProducto());
        ps.setInt(3, dp.getCantProd());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            dp.setIdDetalle(rs.getInt("idDetalle"));
            
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro ID");
        }
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo agregar detalle");
        }
    }
    
    public void eliminarDetalle(int id){
    String sql = "DELETE FROM `detallepedido` WHERE idDetalle=?";
    try{
    PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo eliminar el detalle");
    }
        
    }
    
    public void actualizarCantidad(int id,int cant){
    
        String sql="UPDATE detallepedido SET cantidad=? WHERE idDetalle=?;";
        try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(2, id);
        ps.setInt(1, cant);
        ps.executeUpdate();
       
        ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo Actualizar detalle");
        }
    }
    
    
}
