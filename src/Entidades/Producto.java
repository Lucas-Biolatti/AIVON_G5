
package Entidades;

import Modelo.Conexion;
import Modelo.ProductoData;

public class Producto {
    
    private int idProducto;
    private String nombreProd;
    private String uso;
    private int tamañoCm3;
    private double precioVenta;
    private double precioCosto;
    private int aporte;
    private boolean estadoProducto;

    public Producto(String nombreProd, String uso, int tamañoCm3, double precioVenta, double precioCosto, int aporte, boolean estadoProducto) {
        this.nombreProd = nombreProd;
        this.uso = uso;
        this.tamañoCm3 = tamañoCm3;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.aporte = aporte;
        this.estadoProducto = estadoProducto;
    }

    public Producto(int idProducto, String nombreProd, String uso, int tamañoCm3, double precioVenta, double precioCosto, int aporte, boolean estadoProducto) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.uso = uso;
        this.tamañoCm3 = tamañoCm3;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.aporte = aporte;
        this.estadoProducto = estadoProducto;
    }
    
    public Producto() {
    }
    
    void agregarProducto(){
    ProductoData pd=new ProductoData(new Conexion());
    pd.agregarProducto(this);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getTamañoCm3() {
        return tamañoCm3;
    }

    public void setTamañoCm3(int tamañoCm3) {
        this.tamañoCm3 = tamañoCm3;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getAporte() {
        return aporte;
    }

    public void setAporte(int aporte) {
        this.aporte = aporte;
    }

    public boolean isEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @Override
    public String toString() {
        return idProducto + " - " + nombreProd;
    }
    
    
    
    
    
}
