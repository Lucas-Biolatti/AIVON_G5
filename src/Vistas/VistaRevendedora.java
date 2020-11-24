/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Revendedora;
import Modelo.Conexion;
import Modelo.RevendedoraData;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author lbiolatti
 */
public class VistaRevendedora extends javax.swing.JInternalFrame {
    Conexion c;
    RevendedoraData rd;
    
   
    public VistaRevendedora() {
        initComponents();
        c = new Conexion();
        rd = new RevendedoraData(c);
    }

       public void calcularNivel(){
       int id;
       id = Integer.parseInt(tId.getText());
       rd.modificarNivel(id);
       
       }
       public void ultimoPedido(){
           int id;
           id=Integer.parseInt(tId.getText());
       SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
       LocalDate ult;
       
       ult= rd.fechaUltimoPedido(id);
       tUltimoPedido.setDate(Date.valueOf(ult));
       }
       
       public void comprobarEstado(){
       int id;
       id=Integer.parseInt(tId.getText());
           rd.comprobarEstado(id);
       
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tDni = new javax.swing.JTextField();
        tTelefono = new javax.swing.JTextField();
        tmail = new javax.swing.JTextField();
        tNivel = new javax.swing.JTextField();
        cActivo = new javax.swing.JCheckBox();
        bBuscar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bActualizar = new javax.swing.JButton();
        bBaja = new javax.swing.JButton();
        bAlta = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tUltimoPedido = new com.toedter.calendar.JDateChooser();
        bVerificar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO REVENDEDORA");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Revendedora:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DNI:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido y Nombre:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Email:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Telefono:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nivel:");

        cActivo.setBackground(new java.awt.Color(255, 255, 255));
        cActivo.setText("Activo?");
        cActivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cActivo.setEnabled(false);
        cActivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cActivo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActivoActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        bBaja.setText("Dar de Baja");
        bBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaActionPerformed(evt);
            }
        });

        bAlta.setText("Dar de Alta");
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rev_1.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha de Ultimo pedido");

        tUltimoPedido.setEnabled(false);

        bVerificar.setText("Verificar Estado");
        bVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tmail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNivel, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(tUltimoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscar))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addGap(20, 20, 20)
                .addComponent(bActualizar)
                .addGap(20, 20, 20)
                .addComponent(bBaja)
                .addGap(20, 20, 20)
                .addComponent(bAlta)
                .addGap(20, 20, 20)
                .addComponent(bLimpiar)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(bVerificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tUltimoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bActualizar)
                    .addComponent(bBaja)
                    .addComponent(bAlta)
                    .addComponent(bLimpiar))
                .addGap(18, 18, 18)
                .addComponent(bVerificar)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActivoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cActivoActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(tId.getText());
        
        try{
            
        Revendedora rev;
     
        calcularNivel();
        
        rev=rd.buscarRevendedora(id);
        
        tNombre.setText(rev.getNombreCompleto());
        tDni.setText(rev.getDni());
        tTelefono.setText(rev.getTel());
        tmail.setText(rev.getMail());
        tNivel.setText(rev.getNivel()+"");
        cActivo.setSelected(rev.isEstado());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"No se encontro la revendedora que busca");
        }
        
        
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // TODO add your handling code here:
        Revendedora rev;
        String tel;
        String mail;
        String nombre;
        String dni;
        boolean estado;
        int nivel;
        
        tel=tTelefono.getText();
        mail=tmail.getText();
        nombre=tNombre.getText();
        dni=tDni.getText();
        estado=cActivo.isSelected();
        nivel=Integer.parseInt(tNivel.getText());
        rev= new Revendedora(tel,mail,nombre,dni,estado,nivel);
        rd.agregarRevendedora(rev);
       tId.setText(rev.getIdRevendedora()+"");
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        // TODO add your handling code here:
        
         Revendedora rev;
        int id;
        String tel;
        String mail;
        String nombre;
        String dni;
        boolean estado;
        int nivel;
        ultimoPedido();
        
        id= Integer.parseInt(tId.getText());
        tel=tTelefono.getText();
        mail=tmail.getText();
        nombre=tNombre.getText();
        dni=tDni.getText();
        estado=cActivo.isSelected();
        nivel=Integer.parseInt(tNivel.getText());
        rev= new Revendedora(id,tel,mail,nombre,dni,estado,nivel);
        rd.actualizarRevendedora(rev);
              
      
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaActionPerformed
        // TODO add your handling code here:
        int id;
        id=Integer.parseInt(tId.getText());
        rd.darDeBaja(id);
    }//GEN-LAST:event_bBajaActionPerformed

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
        // TODO add your handling code here:
        int id;
        id=Integer.parseInt(tId.getText());
        rd.darDeAlta(id);
    }//GEN-LAST:event_bAltaActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
        tId.setText("");
        tTelefono.setText("");
        tmail.setText("");
        tNombre.setText("");
        tDni.setText("");
        cActivo.setSelected(false);
        tNivel.setText("");
        tUltimoPedido.setDate(null);
        
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerificarActionPerformed
        // TODO add your handling code here:
           try{comprobarEstado();
           ultimoPedido();
           
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, "La revendedora aun no posee un pedido");
           }
           
    }//GEN-LAST:event_bVerificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bAlta;
    private javax.swing.JButton bBaja;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bVerificar;
    private javax.swing.JCheckBox cActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tDni;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tNivel;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tTelefono;
    private com.toedter.calendar.JDateChooser tUltimoPedido;
    private javax.swing.JTextField tmail;
    // End of variables declaration//GEN-END:variables
}
