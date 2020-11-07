
package Entidades;

import Modelo.CampData;
import Modelo.Conexion;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Camp {
    
    private int idCamp;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private double montoMin;
    private double montoMax;
    private int estrellasCampaña;
    private boolean estadoCamp;

    public Camp(int idCamp, LocalDate fechaInicio, LocalDate fechaCierre, double montoMin, double montoMax, boolean estadoCamp) {
        this.idCamp = idCamp;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.montoMin = montoMin;
        this.montoMax = montoMax;
        this.estadoCamp = estadoCamp;
    }

    
    public Camp(LocalDate fechaInicio, LocalDate fechaCierre, double montoMin, double montoMax,boolean estadoCamp) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.montoMin = montoMin;
        this.montoMax = montoMax;
        this.estadoCamp=estadoCamp;
    }

    public Camp() {
    }
    
    public void agregarCampaña(){
        CampData cd=new CampData(new Conexion());
        cd.agregarCampaña(this);
    }
    
    public void cerrarCampaña(){
    CampData cd=new CampData(new Conexion());
    cd.cerrarCampaña(this);
    this.setEstadoCamp(false);
    }
    
    /////////////////Getter and Setter////////////////

    public boolean isEstadoCamp() {
        return estadoCamp;
    }

    public void setEstadoCamp(boolean estadoCamp) {
        this.estadoCamp = estadoCamp;
    }

    public int getEstrellasCampaña() {
        return estrellasCampaña;
    }

    public void setEstrellasCampaña(int estrellasCampaña) {
        this.estrellasCampaña = estrellasCampaña;
    }

    public int getIdCamp() {
        return idCamp;
    }

    public void setIdCamp(int idCamp) {
        this.idCamp = idCamp;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public double getMontoMin() {
        return montoMin;
    }

    public void setMontoMin(double montoMin) {
        this.montoMin = montoMin;
    }

    public double getMontoMax() {
        return montoMax;
    }

    public void setMontoMax(double montoMax) {
        this.montoMax = montoMax;
    }

    @Override
    public String toString() {
        return idCamp + ", fechaInicio=" + fechaInicio + ", fechaCierre=" + fechaCierre + ", montoMin=" + montoMin + ", montoMax=" + montoMax + '}';
    }
    
    
    
    
}
