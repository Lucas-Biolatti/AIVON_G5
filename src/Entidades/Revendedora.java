
package Entidades;

public class Revendedora {
    private int idRevendedora;
    private String tel;
    private String mail;
    private String nombreCompleto;
    private String dni;
    private boolean estado;
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Revendedora(int idRevendedora) {
        this.idRevendedora = idRevendedora;
    }

    public Revendedora(int idRevendedora, String tel, String mail, String nombreCompleto, String dni, boolean estado, int nivel) {
        this.idRevendedora = idRevendedora;
        this.tel = tel;
        this.mail = mail;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.estado = estado;
        this.nivel = nivel;
    }
   

    public Revendedora(String tel, String mail, String nombreCompleto, String dni, boolean estado,int nivel) {
        this.tel = tel;
        this.mail = mail;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.estado = estado;
        this.nivel=nivel;
       
    }

    public Revendedora() {
    }
    public void bajaPorInactividad(){
    
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

    
    
    @Override
    public String toString() {
        return "Revendedora{" + "idRevendedora=" + idRevendedora + ", mail=" + mail + ", nombreCompleto=" + nombreCompleto + ", estado=" + estado + '}';
    }
    
    
}
