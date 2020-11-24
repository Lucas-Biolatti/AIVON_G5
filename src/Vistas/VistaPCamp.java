/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Camp;
import Entidades.Pedido;
import Entidades.Revendedora;
import Modelo.CampData;
import Modelo.Conexion;
import Modelo.PedidoData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lbiolatti
 */
public class VistaPCamp extends javax.swing.JInternalFrame {

    Conexion c;
    PedidoData pd;
    CampData cd;
    DefaultTableModel tablaPedido;
    public VistaPCamp() {
        initComponents();
        c = new Conexion();
        pd = new PedidoData(c);
        cd = new CampData(c);
        tablaPedido = new DefaultTableModel();
        cabeceraPedido();
        cargarCamp();
    }

    public void cabeceraPedido(){
    ArrayList<Object> column = new ArrayList<>();
    column.add("ID");
    column.add("CAJAS");
    column.add("ESTADO");
    column.add("REVENDEDORA");
    column.add("IMPORTE");
    column.add("ESTRELLAS");
    
    
    for(Object o:column){
    tablaPedido.addColumn(o);
    }
    tabla.setModel(tablaPedido);
    
    }
    public void cargarCamp(){
    
        List<Camp> lista = cd.obtenerCampañas();
        for(Camp c:lista){
        cbCamp.addItem(c);
        }
    }
    public void borrarFilas(){
        try{
        int a = tablaPedido.getRowCount()-1;
       
        for(int i=a;i>=0;i--){
            tablaPedido.removeRow(i);
            
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "La Campaña no tiene pedidos");
    }
    }
    public void cargarPedidos(){
     
    Camp c = (Camp) cbCamp.getSelectedItem();
    List <Pedido> lista = pd.listarPedidosCampaña(c);
    for(Pedido p:lista){
        tablaPedido.addRow(new Object[]{p.getIdPedido(),p.getCajas(),p.isEstado(),p.getRevendedora(),p.getImporte(),p.getEstrellaPedido()});
    }
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCamp = new javax.swing.JComboBox<>();
        bbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE PEDIDO POR CAMPAÑA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Campaña:");

        cbCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCampActionPerformed(evt);
            }
        });

        bbuscar.setText("Buscar");
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Clock-Consult.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bbuscar)
                        .addGap(54, 54, 54))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bbuscar))
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        cargarPedidos();
    }//GEN-LAST:event_bbuscarActionPerformed

    private void cbCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCampActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbuscar;
    private javax.swing.JComboBox<Camp> cbCamp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
