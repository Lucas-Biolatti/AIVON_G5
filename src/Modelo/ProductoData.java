
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

public class ProductoData {
    private Connection con;
    
    public ProductoData(Conexion conexion){
        this.con= conexion.getConection();
    }
    
    public void agregarProducto(Producto p){
    String sql="INSERT INTO producto(nombreProd, uso, tamañoCm3, precioVenta, precioCosto, aporteEst, estadoProducto)"
            + " VALUES (?,?,?,?,?,?,?)";
    
    try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,p.getNombreProd());
        ps.setString(2,p.getUso());
        ps.setInt(3,p.getTamañoCm3());
        ps.setDouble(4,p.getPrecioVenta());
        ps.setDouble(5,p.getPrecioCosto());
        ps.setInt(6,p.getAporte());
        ps.setBoolean(7,p.isEstadoProducto());
        ps.executeUpdate();
        
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            p.setIdProducto(rs.getInt("idProducto"));
        }
        ps.close();
        JOptionPane.showMessageDialog(null,"El producto fue agregado con exito");
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo agregar el Producto");
    }
    }
    
    public void darDeBajaProducto(int id){
    String sql="UPDATE producto SET estadoProducto=0 WHERE idProducto=?;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null,"Se ha dado de baja al producto: "+id);
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, "No se pudo dar de baja al producto");
        }
    }
    public void darDeAltaProducto(int id){
    String sql="UPDATE producto SET estadoProducto=1 WHERE idProducto=?;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null,"Se ha dado de Alta al producto: "+id);
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, "No se pudo dar de Alta al producto");
        }
    }
    
    public List<Producto> obtenerProductos(){
        List<Producto> productos=new ArrayList<>();
        Producto p=new Producto();
        
    String sql="SELECT * FROM producto WHERE estadoProducto=1;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombreProd(rs.getString("nombreProd"));
        p.setUso(rs.getString("uso"));
        p.setTamañoCm3(rs.getInt("tamañoCm3"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));
        p.setPrecioCosto(rs.getDouble("precioCosto"));
        p.setAporte(rs.getInt("aporteEst"));
        p.setEstadoProducto(rs.getBoolean("estadoProducto"));
        productos.add(p);
    }
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo obtener el listado de productos");
    }
    return productos;
    }
    
    public void actualizarProducto(Producto p){
    String sql="UPDATE producto SET nombreProd=?,uso=?,tamañoCm3=?,precioVenta=?,precioCosto=?,aporteEst=?,estadoProducto=? WHERE idProducto=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setString(1,p.getNombreProd());
    ps.setString(2, p.getUso());
    ps.setInt(3,p.getTamañoCm3());
    ps.setDouble(4,p.getPrecioVenta());
    ps.setDouble(5,p.getPrecioCosto());
    ps.setInt(6,p.getAporte());
    ps.setBoolean(7,p.isEstadoProducto());
    ps.setInt(8, p.getIdProducto());
    ps.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"El producto se actualizo correctamente");
    ps.close();
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo modificar el producto");
    }
    }
    
    public Producto buscarProducto(int id){
        Producto p=null;
        String sql="select * from producto where idProducto=?;";
        try{
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            p=new Producto();
            p.setNombreProd(rs.getString("nombreProd"));
            p.setUso(rs.getString("uso"));
            p.setTamañoCm3(rs.getInt("tamañoCm3"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setPrecioCosto(rs.getDouble("precioCosto"));
            p.setAporte(rs.getInt("aporteEst"));
            p.setEstadoProducto(rs.getBoolean("estadoProducto"));
        }
        ps.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se encontro el pedido");
        }
        
        return p;
    }
    
    public ArrayList<Producto> productoNoSeleccionado(int p){
   
        ArrayList<Producto> productos = new ArrayList<>();
             Producto product;
        String sql="SELECT * FROM producto WHERE idProducto NOT IN(SELECT idProducto FROM detallepedido WHERE detallepedido.idPedido=?)";
    
                try{
                    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, p);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                    product = new Producto();
                    product = buscarProducto(rs.getInt("idProducto"));
                    product.setIdProducto(rs.getInt("idProducto"));
                    /*product.setNombreProd(rs.getString("nombreProd"));
                    product.setUso(rs.getString("uso"));
                    product.setTamañoCm3(rs.getInt("tamañoCm3"));
                    product.setPrecioVenta(rs.getDouble("precioVenta"));
                    product.setPrecioCosto(rs.getDouble("precioCosto"));
                    product.setAporte(rs.getInt(rs.getInt("aporteEst")));
                    product.setEstadoProducto(rs.getBoolean("estadoProducto"));
                    */
                    productos.add(product);
                    }
                    ps.close();
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"No se encontraron los productos");
                }
                return productos;
                
                }
    
    public List<DetallePedido> listarDetallePorPedido(int id){
        DetallePedido dp;
        Producto prod;
        Pedido ped;
        List<DetallePedido> detalles = new ArrayList<>();
        
    String sql = "SELECT * FROM detallepedido WHERE idPedido=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
     prod = new Producto();
    dp = new DetallePedido();
    dp.setIdDetalle(rs.getInt("idDetalle"));
    ped = new Pedido();
    ped.setIdPedido(id);
        
    dp.setCantProd(rs.getInt("cantidad"));
    prod = buscarProducto(rs.getInt("idProducto"));
    prod.setIdProducto(rs.getInt("idProducto"));
    dp.setProducto(prod);
      detalles.add(dp);
    }
    
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se encontraron los detalles");
    }
    return detalles;
    }
    
    
}
