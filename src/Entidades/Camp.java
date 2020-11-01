
package Entidades;

import java.time.LocalDate;

public class Camp {
    
    private int idCamp;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private double montoMin;
    private double montoMax;

    public Camp(LocalDate fechaInicio, LocalDate fechaCierre, double montoMin, double montoMax) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.montoMin = montoMin;
        this.montoMax = montoMax;
    }

    public Camp() {
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
