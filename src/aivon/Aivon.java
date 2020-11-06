
package aivon;

import Entidades.Camp;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Revendedora;
import Modelo.CampData;
import Modelo.Conexion;
import Modelo.DetallePedidoData;
import Modelo.PedidoData;
import Modelo.ProductoData;
import Modelo.RevendedoraData;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;


public class Aivon {

    public static void main(String[] args) {
   Conexion c=new Conexion();
   ProductoData pd=new ProductoData(c);
   Producto p1= new Producto(3,"Crema de Afeitar","Cara",50,500,450,5,true);
   Producto p2= new Producto(4,"Crema de mano","diurno",30,100,85,2,true);
    //pd.agregarProducto(p2);
   
    RevendedoraData rd=new RevendedoraData(c);
   Revendedora r1=new Revendedora(2,"2154678352","kjhksjdhg@dsf.com","Maria","37592474",true,1);
   
   //rd.agregarRevendedora(r1);
   
   
   Camp c1=new Camp(1,LocalDate.of(2020,4, 1),LocalDate.of(2020, 4, 26),5000,8000,true);
   CampData cd=new CampData(c);
   //cd.agregarCampaña(c1);
  Pedido pedido=new Pedido(2,LocalDate.of(2020,4,5),LocalDate.of(2020, 4, 30),LocalDate.of(2020,4,14),2,true,r1,c1);
  
   PedidoData pdata=new PedidoData(c);
   //pdata.agregarPedido(pedido);
  
  DetallePedido dped=new DetallePedido(p1,pedido);
  DetallePedido dped2=new DetallePedido(p2,pedido);
  DetallePedidoData dpd=new DetallePedidoData(c);
  //dpd.agregarDetallePedido(dped2);
  
   
       Pedido pedido1=pdata.buscarPedido(2);
        //System.out.println(pedido1);
  //pedido1.setEstrellaPedido(pdata.sumarEstrellasPedido(pedido1));
    //   System.out.println("Las estrellas del pedido son: "+pedido1.getEstrellaPedido());
     //pedido.listarProductos(pedido);
       // System.out.println(pedido.estrellasDelPedido(pedido));
    //pedido.pagarPedido(LocalDate.of(2020,4,30));
    pedido1.cambiarEstado();
    
    }
}
