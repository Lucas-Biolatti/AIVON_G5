
package Modelo;

import Entidades.Camp;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Revendedora;
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

/**
 *
 * @author agus_
 */
public class PedidoData {
    private Connection con;
    
    
    
    public PedidoData(Conexion conexion) {
        this.con = conexion.getConection();
    }

    public void agregarPedido(Pedido p){
       
         String sql  = "INSERT INTO pedido(fechaIngreso, fechaEntrega, fechaPago, cantCajas, estado, idRevendedora,idCamp) "
                     + "VALUES (?,?,?,?,?,?,?);" ; 
                     
                     try{
                         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                         ps.setDate(1, Date.valueOf(p.getFechaIngreso()));
                         ps.setDate(2, Date.valueOf(p.getFechaEntrega()));
                         ps.setDate(3, Date.valueOf(p.getFechaPago()));
                         ps.setInt(4, p.getCajas());
                         ps.setBoolean(5, p.isEstado());
                         ps.setInt(6, p.getRevendedora().getIdRevendedora());
                         ps.setInt(7, p.getCamp().getIdCamp());
                        
                         ps.executeUpdate();
                         
                         ResultSet rs = ps.getGeneratedKeys();
                         if(rs.next()){
                             p.setIdPedido(rs.getInt("idProducto"));
                         }
                         ps.close();
                         
                         JOptionPane.showMessageDialog(null, "El pedido fue agregado con exito");
                         
                     }catch(SQLException e){
                         JOptionPane.showMessageDialog(null, "No se pudo agregar el pedido");                   
                     }
        }
 
    public void darDeBajaPedido(int id){
        String sql = "UPDATE 'pedido' SET 'estado'=0 WHERE 'idPedido'=?";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public List<Pedido> listaPedidos(){
        List<Pedido> p = new ArrayList<>();
        Pedido pedidos = new Pedido();
        Revendedora r= new Revendedora();
        
        String sql = "SELECT * FROM `pedido` WHERE estado = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pedidos.setIdPedido(rs.getInt("idPedido"));
                pedidos.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                pedidos.setFechaEntrega(rs.getDate("fechaEntrega").toLocalDate());
                pedidos.setFechaPago(rs.getDate("fechaPago").toLocalDate());
                pedidos.setCajas(rs.getInt("cantCajas"));
                pedidos.setImporte(rs.getDouble("importe"));
                pedidos.setEstrellaPedido(rs.getInt("estrellaPedido"));
                r.setIdRevendedora(rs.getInt("idRevendedora"));
                p.add(pedidos);
               
            }
            ps.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo obtener la lista de pedidos");
        }
        
        return p;
        
            
    }
    
    public List<Producto> ListaProductos(Pedido p){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto pr = new Producto();
        String sql="SELECT producto.* FROM producto,pedido,detallepedido WHERE detallepedido.idPedido=? AND detallepedido.idProducto=producto.idProducto;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,p.getIdPedido());
    
    ResultSet rs=ps.executeQuery();
    
    while(rs.next()){
    pr.setIdProducto(rs.getInt("idProducto"));
    pr.setNombreProd(rs.getString("nombreProd"));
    pr.setUso(rs.getString("uso"));
    pr.setTamañoCm3(rs.getInt("tamañoCm3"));
    pr.setPrecioVenta(rs.getDouble("precioVenta"));
    pr.setPrecioCosto(rs.getDouble("precioCosto"));
    pr.setAporte(rs.getInt("aporteEst"));
    pr.setEstadoProducto(rs.getBoolean("estadoProducto"));
    productos.add(pr);
        System.out.println(pr);
     }
       ps.close();
    
    }catch(SQLException e){
       JOptionPane.showMessageDialog(null,"No se pudo listar los productos");
    }
    return productos;
    }
    
    public int sumarEstrellasPedido(Pedido p){
    int x=0;
    String sql="SELECT sum(producto.aporteEst) AS total FROM producto,pedido,detallepedido WHERE detallepedido.idPedido=? AND detallepedido.idProducto=producto.idProducto;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, p.getIdPedido());
    
    ResultSet rs=ps.executeQuery();
    if(rs.next()){
    x=rs.getInt("total");
    }
    ps.close();
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se pudo obtener las estrellas");
    }
    return x;
    }
    
    public void sumarEstrellasP(Pedido p){
    String sql="UPDATE `pedido` SET `estrellasPedido`=? WHERE pedido.idPedido=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(2,p.getIdPedido());
    ps.setInt(1,this.sumarEstrellasPedido(p));
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error: No se pudo agregar");
    }
    }
    public void pagarPedido(LocalDate fpago){
    String sql="UPDATE `pedido` SET `fechaPago`=? WHERE 1" ;
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setDate(1,Date.valueOf(fpago));
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null, "Se efectuo el pago correctamente");
     
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se Pudo pagar el Pedido");
    }
    
    
    }
    public void entregarPedido(LocalDate fEntrega){
    String sql="UPDATE `pedido` SET `fechaEntrega`=? WHERE 1" ;
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setDate(1,Date.valueOf(fEntrega));
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null, "Se efectuo el pago correctamente");
     
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se Pudo entregar el Pedido");
    }
    
    
    }
    public void cambiarEstado(Pedido p){
    String sql="UPDATE `pedido` SET `estado`=? WHERE pedido.idPedido=?";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setBoolean(1, p.isEstado());
    ps.setInt(2, p.getIdPedido());
    ps.executeUpdate();
    ps.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"No se pudo modificar");
    }
    
    }
   public Pedido buscarPedido(int id){
   String sql="SELECT * FROM `pedido` WHERE pedido.idPedido=?;";
   Pedido p=new Pedido();
   Revendedora r=new Revendedora();
   Camp c=new Camp();
   try{
   PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   ps.setInt(1, id);
   ResultSet rs=ps.executeQuery();
   if(rs.next()){
    p.setIdPedido(rs.getInt("idPedido"));
    p.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
    p.setFechaEntrega(rs.getDate("fechaEntrega").toLocalDate());
    p.setFechaPago(rs.getDate("fechaPago").toLocalDate());
    p.setCajas(rs.getInt("cantCajas"));
    p.setImporte(rs.getDouble("importe"));
    p.setEstrellaPedido(rs.getInt("estrellaPedido"));
    r.setIdRevendedora(rs.getInt("idRevendedora"));
    p.setRevendedora(r);
    c.setIdCamp(rs.getInt("idCamp"));
    p.setCamp(c);
       ps.close();
   } else System.out.println("El pedido no fue encontrado");
   }catch(SQLException e){
       JOptionPane.showMessageDialog(null, "No se pudo buscar pedido");
   }
   return p;
   }
    
}
