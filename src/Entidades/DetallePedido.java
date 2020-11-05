
package Entidades;

public class DetallePedido {
    
    private int idDetalle;
    private Producto producto;
    private Pedido pedido;
   

    public DetallePedido(Producto producto, Pedido pedido) {
        this.producto = producto;
        this.pedido = pedido;
    }

    public DetallePedido(Producto producto, Pedido pedido, Revendedora revendedora) {
        this.producto = producto;
        this.pedido = pedido;
       
    }

    public DetallePedido() {
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
