
package aivon;

import Entidades.Producto;
import Modelo.Conexion;
import Modelo.ProductoData;

public class Aivon {

    public static void main(String[] args) {
     Conexion c=new Conexion();
    Producto p1=new Producto("Lapiz Labial rojo","corporal",60,50,45,1,true);
    ProductoData pd=new ProductoData(c);
    //pd.agregarProducto(p);Funciona ok
    //pd.darDeBajaProducto(1);
    
    //    System.out.println(pd.obtenerProductos());
    //pd.actualizarProducto(2, p1); Funciona ok
    }
    
}
