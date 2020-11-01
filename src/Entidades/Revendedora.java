
package Entidades;

public class Revendedora {
    private int idRevendedora;
    private String tel;
    private String mail;
    private String nombreCompleto;
    private String dni;
    private boolean estado;
    private Camp campaña;

    public Revendedora(String tel, String mail, String nombreCompleto, String dni, boolean estado, Camp campaña) {
        this.tel = tel;
        this.mail = mail;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.estado = estado;
        this.campaña = campaña;
    }

    public Revendedora() {
    }

    public int getIdRevendedora() {
        return idRevendedora;
    }

    public void setIdRevendedora(int idRevendedora) {
        this.idRevendedora = idRevendedora;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Camp getCampaña() {
        return campaña;
    }

    public void setCampaña(Camp campaña) {
        this.campaña = campaña;
    }

    @Override
    public String toString() {
        return "Revendedora{" + "idRevendedora=" + idRevendedora + ", mail=" + mail + ", nombreCompleto=" + nombreCompleto + ", estado=" + estado + ", campa\u00f1a=" + campaña + '}';
    }
    
    
}
