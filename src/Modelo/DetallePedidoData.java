
package Modelo;

import Entidades.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DetallePedidoData {
    
    private Connection con;
    
    public DetallePedidoData(Conexion conexion){
    this.con=conexion.getConection();
    }
    
    public void agregarDetallePedido(DetallePedido dp){
    
        String sql="INSERT INTO detallepedido(idPedido, idProducto) VALUES (?,?);";
        try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,dp.getPedido().getIdPedido());
        ps.setInt(2,dp.getProducto().getIdProducto());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            dp.setIdDetalle(rs.getInt("idDetalle"));
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro ID");
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo agregar detalle");
        }
    }
    
    
}
