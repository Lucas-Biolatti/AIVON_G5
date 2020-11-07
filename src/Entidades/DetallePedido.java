
package Entidades;

import Modelo.Conexion;
import Modelo.DetallePedidoData;
import java.util.HashSet;
import java.util.Set;

public class DetallePedido {
    
    private int idDetalle;
    private Producto producto;
    private Pedido pedido;
    private int cantProd;
    private double subTotal;
    private int nroCaja;
   

    public DetallePedido(Producto producto, Pedido pedido,int cantProd,int nroCaja) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantProd=cantProd;
        this.nroCaja=nroCaja;
    }

    public DetallePedido(Producto producto, Pedido pedido) {
        this.producto = producto;
        this.pedido = pedido;
       
    }
    
    public void calcularSubTotal(){
    this.subTotal=(this.getProducto().getPrecioCosto()*this.getCantProd());
        
    
    }

    public void agregarDetallePedido(){
    DetallePedidoData dpd = new DetallePedidoData(new Conexion());
    dpd.agregarDetallePedido(this);
    
    }

    //No sabemos que datos necesitamos.
    public DetallePedido() {
    }
    
    /////////Getter and Setter//////////////
    
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(int nroCaja) {
        this.nroCaja = nroCaja;
    }
    
    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }
    
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetalle=" + idDetalle + ", producto=" + producto + ", pedido=" + pedido + '}';
    }
    
    
}
