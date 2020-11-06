
package Entidades;

import Modelo.Conexion;
import Modelo.PedidoData;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pedido {
    
    private int idPedido;
    private LocalDate fechaIngreso;
    private LocalDate fechaEntrega;
    private LocalDate fechaPago;
    private int cajas;
    private double importe;
    private int estrellaPedido=0;
    private boolean estado;
    private Revendedora revendedora;
    private Camp camp;
    private ArrayList<DetallePedido>lineaPedido ;
    
    public Pedido(LocalDate fechaIngreso, LocalDate fechaEntrega, LocalDate fechaPago, int cajas, boolean estado, Revendedora revendedora, Camp camp) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.fechaPago = fechaPago;
        this.cajas = cajas;
        this.estado = estado;
        this.revendedora = revendedora;
        this.camp=camp;
    }

    public Pedido(int idPedido, LocalDate fechaIngreso, LocalDate fechaEntrega, LocalDate fechaPago, int cajas, boolean estado, Revendedora revendedora, Camp camp) {
        this.idPedido = idPedido;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.fechaPago = fechaPago;
        this.cajas = cajas;
        this.estado = estado;
        this.revendedora = revendedora;
        this.camp = camp;
    }
    
    public Pedido() {
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }
    
    public int estrellasDelPedido(Pedido p){
   PedidoData pd=new PedidoData(new Conexion());
    return pd.sumarEstrellasPedido(p);
    
    }
    
    public void pagarPedido(LocalDate fpago){
    PedidoData pd=new PedidoData(new Conexion());
    pd.pagarPedido(fpago);
    this.fechaPago=fpago;
     System.out.println("Pago Exitoso");
     
    }
    public void cambiarEstado(){
    Period periodo=Period.between(this.getFechaPago(), this.getFechaEntrega());
       PedidoData pd=new PedidoData(new Conexion());
       
        if(Math.abs(periodo.getDays())<10){
          this.setEstado(true);
          pd.cambiarEstado(this);
          }else {
           this.setEstado(true);
           pd.cambiarEstado(this);
          
    }
    }
    
    public List<Producto> listarProductos(Pedido p){
       PedidoData pd=new PedidoData(new Conexion());
       
    return pd.ListaProductos(p);
    }

    public ArrayList<DetallePedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(ArrayList<DetallePedido> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getCajas() {
        return cajas;
    }

    public void setCajas(int cajas) {
        this.cajas = cajas;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getEstrellaPedido() {
        return estrellaPedido;
    }

    public void setEstrellaPedido(int estrellaPedido) {
        this.estrellaPedido = estrellaPedido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Revendedora getRevendedora() {
        return revendedora;
    }

    public void setRevendedora(Revendedora revendedora) {
        this.revendedora = revendedora;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fechaIngreso=" + fechaIngreso + ", fechaEntrega=" + fechaEntrega + ", fechaPago=" + fechaPago + ", cajas=" + cajas + ", importe=" + importe + ", estrellaPedido=" + estrellaPedido + ", estado=" + estado + ", revendedora=" + revendedora + '}';
    }
    
    
    
}
