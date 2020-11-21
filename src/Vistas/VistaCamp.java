
package Vistas;

import Entidades.Camp;
import Modelo.CampData;
import Modelo.Conexion;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VistaCamp extends javax.swing.JInternalFrame {
    Conexion c;
    CampData cd;
    /** Creates new form VistaCamp */
    public VistaCamp() {
        initComponents();
        c=new Conexion();
        cd=new CampData(c);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        tMmin = new javax.swing.JTextField();
        tMMax = new javax.swing.JTextField();
        tECamp = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        bActualizar = new javax.swing.JButton();
        bDarBaja = new javax.swing.JButton();
        bDarAlta = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        cEstado = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jdInicio = new com.toedter.calendar.JDateChooser();
        jdFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Campaña:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de Inicio:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha de Cierre:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Monto Minimo: $");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Monto Maximo: $");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estrallas Campaña");

        tId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdActionPerformed(evt);
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

        bDarBaja.setText("Dar de Baja");
        bDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDarBajaActionPerformed(evt);
            }
        });

        bDarAlta.setText("Calcular Estrellas");
        bDarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDarAltaActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        cEstado.setText("Activo?");
        cEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEstadoActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/camp.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO CAMPAÑA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(bGuardar)
                                .addGap(20, 20, 20)
                                .addComponent(bActualizar)
                                .addGap(20, 20, 20)
                                .addComponent(bDarBaja)
                                .addGap(20, 20, 20)
                                .addComponent(bDarAlta)
                                .addGap(20, 20, 20)
                                .addComponent(bLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tMmin)
                                    .addComponent(tMMax)
                                    .addComponent(tECamp)
                                    .addComponent(jdInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdFin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cEstado)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tId)
                        .addGap(70, 70, 70)
                        .addComponent(bBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tMmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tMMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(tECamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLimpiar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bGuardar)
                        .addComponent(bActualizar)
                        .addComponent(bDarBaja)
                        .addComponent(bDarAlta)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
       SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        Camp c=null;
        LocalDate fini;
        LocalDate ffin;
        double mMin;
        double mMax;
        boolean estado;
        
        String fechai=formato.format(jdInicio.getDate());
        fini=LocalDate.parse(fechai,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        String fechaf=formato.format(jdFin.getDate());
        ffin=LocalDate.parse(fechaf,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        mMin=Double.parseDouble(tMmin.getText());
        mMax=Double.parseDouble(tMMax.getText());
        estado=cEstado.isSelected();
        c=new Camp(fini,ffin,mMin,mMax,estado);
        cd.agregarCampaña(c);
        tId.setText(c.getIdCamp()+"");
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
      SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        Camp c=null;
        LocalDate fini;
        LocalDate ffin;
        double mMin;
        double mMax;
        boolean estado;
        int id;
        
        id=Integer.parseInt(tId.getText());
        String fechai=formato.format(jdInicio.getDate());
        fini=LocalDate.parse(fechai,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        String fechaf=formato.format(jdFin.getDate());
        ffin=LocalDate.parse(fechaf,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        mMin=Double.parseDouble(tMmin.getText());
        mMax=Double.parseDouble(tMMax.getText());
        estado=cEstado.isSelected();
        c=new Camp(id,fini,ffin,mMin,mMax,estado);
        cd.actualizarCampaña(c);
        

    }//GEN-LAST:event_bActualizarActionPerformed

    private void bDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDarBajaActionPerformed
        // TODO add your handling code here:
       int id;
       id=Integer.parseInt(tId.getText());
       cd.cerrarCampaña(id);
    }//GEN-LAST:event_bDarBajaActionPerformed

    private void bDarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDarAltaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bDarAltaActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
       jdInicio.setDate(null);
        jdFin.setDate(null);
        tMmin.setText("");
        tMMax.setText("");
        //tECamp
        cEstado.setSelected(false);
      
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
       Camp c;
        int id;
        id=Integer.parseInt(tId.getText());
        c=cd.buscarCampaña(id);
        
        jdInicio.setDate(Date.valueOf(c.getFechaInicio()));
        jdFin.setDate(Date.valueOf(c.getFechaCierre()));
        tMmin.setText(c.getMontoMin()+"");
        tMMax.setText(c.getMontoMax()+"");
        //tECamp
        cEstado.setSelected(c.isEstadoCamp());
    }//GEN-LAST:event_bBuscarActionPerformed

    private void cEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cEstadoActionPerformed

    private void tIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdActionPerformed
        // TODO add your handling code here:
        jdInicio.setDate(null);
        jdFin.setDate(null);
        tMmin.setText("");
        tMMax.setText("");
        //tECamp
        cEstado.setSelected(false);
    }//GEN-LAST:event_tIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bDarAlta;
    private javax.swing.JButton bDarBaja;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JCheckBox cEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser jdFin;
    private com.toedter.calendar.JDateChooser jdInicio;
    private javax.swing.JTextField tECamp;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tMMax;
    private javax.swing.JTextField tMmin;
    // End of variables declaration//GEN-END:variables

}