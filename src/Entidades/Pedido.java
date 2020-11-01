
package Entidades;

import java.time.LocalDate;

public class Pedido {
    
    private int idPedido;
    private LocalDate fechaIngreso;
    private LocalDate fechaEntrega;
    private LocalDate fechaPago;
    private int cajas;
    private double importe;
    private int estrellaPedido;
    private boolean estado;
    private Revendedora revendedora;

    public Pedido(LocalDate fechaIngreso, LocalDate fechaEntrega, LocalDate fechaPago, int cajas, double importe, int estrellaPedido, boolean estado, Revendedora revendedora) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.fechaPago = fechaPago;
        this.cajas = cajas;
        this.importe = importe;
        this.estrellaPedido = estrellaPedido;
        this.estado = estado;
        this.revendedora = revendedora;
    }

    public Pedido() {
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
