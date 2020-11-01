
package Entidades;

public class DetalleCampaña {
    
    private int idDetCamp;
    private Camp camp;
    private Revendedora revendedora;
    private int cantidadEstrellas;

    public DetalleCampaña(Camp camp, Revendedora revendedora, int cantidadEstrellas) {
        this.camp = camp;
        this.revendedora = revendedora;
        this.cantidadEstrellas = cantidadEstrellas;
    }

    public int getIdDetCamp() {
        return idDetCamp;
    }

    public void setIdDetCamp(int idDetCamp) {
        this.idDetCamp = idDetCamp;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public Revendedora getRevendedora() {
        return revendedora;
    }

    public void setRevendedora(Revendedora revendedora) {
        this.revendedora = revendedora;
    }

    public int getCantidadEstrellas() {
        return cantidadEstrellas;
    }

    public void setCantidadEstrellas(int cantidadEstrellas) {
        this.cantidadEstrellas = cantidadEstrellas;
    }

    @Override
    public String toString() {
        return "DetalleCampa\u00f1a{" + "idDetCamp=" + idDetCamp + ", camp=" + camp + ", revendedora=" + revendedora + ", cantidadEstrellas=" + cantidadEstrellas + '}';
    }
    
    
}
