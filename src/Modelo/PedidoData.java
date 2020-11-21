
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

public class PedidoData {
    private Connection con;
    
    
    //Constructor
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
    public void actualizarPedido(Pedido p){
       
         String sql  = "UPDATE pedido SET fechaIngreso=?,fechaEntrega=?,fechaPago=?,cantCajas=?,estado=?,idRevendedora=?,idCamp=? WHERE idPedido=?;"; 
                     
                     try{
                         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                         
                         ps.setDate(1, Date.valueOf(p.getFechaIngreso()));
                         ps.setDate(2, Date.valueOf(p.getFechaEntrega()));
                         ps.setDate(3, Date.valueOf(p.getFechaPago()));
                         ps.setInt(4, p.getCajas());
                         ps.setBoolean(5, p.isEstado());
                         ps.setInt(6, p.getRevendedora().getIdRevendedora());
                         ps.setInt(7, p.getCamp().getIdCamp());
                         ps.setInt(8,p.getIdPedido());
                        
                         ps.executeUpdate();
                         ps.close();
                         JOptionPane.showMessageDialog(null, "El pedido fue actualizado con exito");
                         
                     }catch(SQLException e){
                         JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido");                   
                     }
        }
 
    public void darDeBajaPedido(int id){
        String sql = "UPDATE 'pedido' SET 'estado'=0 WHERE 'idPedido'=?";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido "+id+" dado de baja");
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo dar de baja al pedido");
        }   
    }
    public void darDeAltaPedido(int id){
        String sql = "UPDATE 'pedido' SET 'estado'=1 WHERE 'idPedido'=?";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido "+id+" dado de alta");
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo dar de alta al pedido");
        }   
    }
    
    public List<Pedido> listaPedidos(){
        List<Pedido> p = new ArrayList<>();
        Pedido pedidos;
        Revendedora r;
        
        String sql = "SELECT * FROM `pedido` WHERE estado = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pedidos= new Pedido();
                r=new Revendedora();
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
    public Pedido buscarPedidos(int id){
        Pedido pedidos=null;
        Revendedora r;
        
        String sql = "SELECT * FROM `pedido` WHERE estado = 1 and idPedido=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pedidos= new Pedido();
                r=new Revendedora();
                pedidos.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                pedidos.setFechaEntrega(rs.getDate("fechaEntrega").toLocalDate());
                pedidos.setFechaPago(rs.getDate("fechaPago").toLocalDate());
                pedidos.setCajas(rs.getInt("cantCajas"));
                pedidos.setImporte(rs.getDouble("importe"));
                pedidos.setEstrellaPedido(rs.getInt("estrellaPedido"));
                r.setIdRevendedora(rs.getInt("idRevendedora"));
            }
            ps.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el pedido");
        }
        
        return pedidos;
        
            
    }
    
    public List<Producto> ListaProductos(Pedido p){
        
        Producto pr;
        ArrayList<Producto> productos = new ArrayList<>();
        String sql="SELECT producto.* FROM producto,pedido,detallepedido WHERE detallepedido.idPedido=? AND detallepedido.idProducto=producto.idProducto;";
    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,p.getIdPedido());
    
    ResultSet rs=ps.executeQuery();
    
    while(rs.next()){
     pr=new Producto();
    pr.setIdProducto(rs.getInt("idProducto"));
    pr.setNombreProd(rs.getString("nombreProd"));
    pr.setUso(rs.getString("uso"));
    pr.setTamañoCm3(rs.getInt("tamañoCm3"));
    pr.setPrecioVenta(rs.getDouble("precioVenta"));
    pr.setPrecioCosto(rs.getDouble("precioCosto"));
    pr.setAporte(rs.getInt("aporteEst"));
    pr.setEstadoProducto(rs.getBoolean("estadoProducto"));
    productos.add(pr);
       
     }
       ps.close();
    
    }catch(SQLException e){
       JOptionPane.showMessageDialog(null,"No se pudo listar los productos");
    }
    return productos;
    }
    
    //Creamos dos metodos el sumarEstrellasPedido nos trae la suma de la consulta y el metodo que le sigue
    //actualiza la base de datos. No sebemos si se podria realizar en el mismo metodo una consulta y una actualizacion a la vez.
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
    
    //Creamos el entregar pedido porque suponemos que si hacemos un pedido no se entraga automaticamente.
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
    
    //Se creo el buscarPedido para poder ejecutar los metodos de prueba con datos directos de la BD.
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
    p.setEstrellaPedido(rs.getInt("estrellasPedido"));
    p.setEstado(rs.getBoolean("estado"));
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
    
    //Los ListarPedidos tienen dentro del metodo los System.out.Printl para poder ejecutar las pruebas
    public List<Pedido> listarPedidosCampaña(Camp c){
       List<Pedido> pc=new ArrayList<>();
       Revendedora r;
       Pedido p;
       Camp camp;
       String sql="SELECT * FROM `pedido` WHERE pedido.idCamp=?";
   try{
   PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   ps.setInt(1,c.getIdCamp());
   ResultSet rs=ps.executeQuery();
       System.out.println("La Campaña "+c.getIdCamp()+" tiene los siguientes Pedidos: ");
   while(rs.next()){
   p=new Pedido();
   r=new Revendedora();
   camp=new Camp();
   p.setIdPedido(rs.getInt("idPedido"));
   p.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
   p.setFechaEntrega(rs.getDate("fechaEntrega").toLocalDate());
   p.setFechaPago(rs.getDate("fechaPago").toLocalDate());
   p.setCajas(rs.getInt("cantCajas"));
   p.setEstado(rs.getBoolean("estado"));
   r.setIdRevendedora(rs.getInt("idRevendedora"));
   p.setRevendedora(r);
   camp.setIdCamp(rs.getInt("idCamp"));
   p.setCamp(camp);
   p.setEstrellaPedido(rs.getInt("estrellasPedido"));
   pc.add(p);
       System.out.println("Pedido: "+p.getIdPedido()+" Estrellas: "+p.getEstrellaPedido());
   }
   ps.close();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error: No se pudo listar");
   }
   
   return pc;
   
   }
    
    public List<Pedido> listarPedidosRevendedora(Revendedora c){
       List<Pedido> pc=new ArrayList<>();
       Revendedora r;
       Pedido p;
       Camp camp;
       String sql="SELECT * FROM `pedido` WHERE pedido.idRevendedora=?";
   try{
   PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   ps.setInt(1,c.getIdRevendedora());
   ResultSet rs=ps.executeQuery();
       System.out.println("La revendedora "+c.getNombreCompleto()+" tiene los siguientes pedidos: ");
   while(rs.next()){
   p=new Pedido();
   r=new Revendedora();
   camp=new Camp();
   p.setIdPedido(rs.getInt("idPedido"));
   p.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
   p.setFechaEntrega(rs.getDate("fechaEntrega").toLocalDate());
   p.setFechaPago(rs.getDate("fechaPago").toLocalDate());
   p.setCajas(rs.getInt("cantCajas"));
   p.setEstado(rs.getBoolean("estado"));
   r.setIdRevendedora(rs.getInt("idRevendedora"));
   p.setRevendedora(r);
   camp.setIdCamp(rs.getInt("idCamp"));
   p.setCamp(camp);
   pc.add(p);
       System.out.println("Pedido: "+p.getIdPedido()+" Campaña: "+p.getCamp().getIdCamp());
   }
   ps.close();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error: No se pudo listar");
   }
   
   return pc;
   
   }
}

