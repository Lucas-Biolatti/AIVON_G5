
package Entidades;

import Modelo.CampData;
import Modelo.Conexion;
import Modelo.RevendedoraData;
import java.time.LocalDate;
import java.time.Period;

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
    public void comprobarEstado(){
        RevendedoraData rd=new RevendedoraData(new Conexion());
        CampData cd=new CampData(new Conexion());
        //LocalDate up=rd.fechaUltimoPedido(this);
        //LocalDate ucc=cd.cierreUltimaCampaña();
        Period p=Period.between(rd.fechaUltimoPedido(this),cd.cierreUltimaCampaña());
        System.out.println(p.getYears()*365+p.getMonths()*30+p.getDays());
        if(Math.abs(p.getYears()*365+p.getMonths()*30+p.getDays())>74){
        rd.darDeBaja(this.getIdRevendedora());
        this.estado=false;
            System.out.println("La Revendedora fue dada de baja Por inactividad");
     }else System.out.println("Error");
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
