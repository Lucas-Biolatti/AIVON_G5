
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
   
   ////////Crear y Agregar Productos a BD/////////////
   
    Producto p1= new Producto(3,"Crema de Afeitar","Cara",50,500,450,5,true); //Se crearon sin id pero se los inrustamos despues de creados para realizar algunas pruebas
    Producto p2= new Producto(4,"Crema de mano","diurno",30,100,85,2,true);
    //p2.agregarProducto();
   
    //////Crear y Agregar Revendedora a BD///////////
    RevendedoraData rd=new RevendedoraData(c);
   Revendedora r1=new Revendedora(2,"2154678352","kjhksjdhg@dsf.com","Maria","37592474",true,1);
    r1.modificarNivel();
    //r1.agregarRevendedora();
    //r1.comprobarEstado(); //Determina si esta activa o no dependiendo del ultimo pedido que hizo y la fecha de cierre de la ultima campaña
    //System.out.println(r1.isEstado());
   
    /////Crear y Agregar Campañas a bd/////////////
   Camp c1=new Camp(1,LocalDate.of(2020,4, 1),LocalDate.of(2020, 4, 26),5000,8000,true);
   Camp c2=new Camp(1,LocalDate.of(2020,7, 1),LocalDate.of(2020, 7, 26),5000,8000,true);
   
   CampData cd=new CampData(c);
   //cd.agregarCampaña(c1);
   //c2.agregarCampaña();
   
   /////Crear y Agregar Pedidos a la BD//////////////
   Pedido pedido=new Pedido(2,LocalDate.of(2020,4,5),LocalDate.of(2020, 4, 30),LocalDate.of(2020,4,14),2,true,r1,c1);
   Pedido pedido2=new Pedido(LocalDate.of(2020,4,5),LocalDate.of(2020, 4, 30),LocalDate.of(2020,4,14),2,true,r1,c1);
   //pedido2.agregarPedido();
   //PedidoData pdata=new PedidoData(c); // Se prueban de las dos maneras. desde la clase comun y la clase data
   //pdata.agregarPedido(pedido);
  
   /////Crar  y Agregar DetallePedido a la BD//////
  DetallePedido dped=new DetallePedido(p1,pedido,3,1);
  DetallePedido dped2=new DetallePedido(p2,pedido,2,1);
  DetallePedidoData dpd=new DetallePedidoData(c);
  //dpd.agregarDetallePedido(dped);
  //dped2.agregarDetallePedido();
  //dped2.calcularSubTotal();
  //System.out.println(dped2.getSubTotal());
  // pedido.craeLineaDetalle();//no sabemos que hacer con este metodo
  //Pedido pedido1=pdata.buscarPedido(2);//buscamos producto desde la BD
  //System.out.println(pedido1);
  //System.out.println("Las estrellas del pedido son: "+pedido1.getEstrellaPedido());
  //System.out.println(pedido.listarProductos(pdata.buscarPedido(2)));
  // System.out.println(pedido.estrellasDelPedido(pedido));
  //pedido.pagarPedido(LocalDate.of(2020,4,30));
  //pedido1.cambiarEstado();
  //pedido.sumarEstrellasDelPedido();
  // pedido.listarPedidoCampaña(c1);
  // pedido.listarPedidoRevendedora(r1);
  
      
    }
}
