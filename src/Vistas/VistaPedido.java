
package Vistas;

import Entidades.Camp;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Revendedora;
import Modelo.CampData;
import Modelo.Conexion;
import Modelo.DetallePedidoData;
import Modelo.PedidoData;
import Modelo.ProductoData;
import Modelo.RevendedoraData;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaPedido extends javax.swing.JInternalFrame {

    Conexion c;
    PedidoData pd;
    DetallePedidoData dpd; 
    RevendedoraData rd;
    CampData cd;
    DefaultTableModel tablaProductos;
    DefaultTableModel tablaDetalle;
    ProductoData prodDat;
    
    public VistaPedido() {
        initComponents();
        c = new Conexion();
        pd = new PedidoData(c);
        dpd = new DetallePedidoData(c);
        rd = new RevendedoraData(c);
        cd = new CampData(c);
        prodDat = new ProductoData(c);
        agregarRevendedoras();
        campActiva();
        tablaProductos = new DefaultTableModel();
        tablaDetalle = new DefaultTableModel();
        
        cabeceraDetalle();
        
    }
    
    
    
    public void borrarFilasDetalle(){
    
        int a = tablaDetalle.getRowCount()-1;
        for(int i=a;i>=0;i--){
            tablaDetalle.removeRow(i);
            
        }
    }
    
    public void borrarItem(){
  
    cbProducto.removeAllItems();
   
    }
    
    public void cargaProdNoSel(){
        borrarItem();
     
        int id;
        id = Integer.parseInt(tId.getText());
       
    
    List<Producto> productos = prodDat.productoNoSeleccionado(id);
    for(Producto i:productos){
    cbProducto.addItem(i);
    }
       
    }
    
    public void campActiva(){
    Camp cam;
    cam = cd.campañaActiva();
    tCamp.setText(cam.getIdCamp()+"");
    
    }
    public void agregarRevendedoras(){
    List<Revendedora> lista = rd.obtenerRevendedoras();
    for(Revendedora i:lista){
        cbRev.addItem(i);
    }
    }
    
    public void cabeceraDetalle(){
    ArrayList<Object> column = new ArrayList<>();
    column.add("ID");
    column.add("PEDIDO");
    column.add("PRODUCTO");
    column.add("CANTIDAD");
    
    
    for(Object o:column){
    tablaDetalle.addColumn(o);
    }
    tDetalle.setModel(tablaDetalle);
    
    }
    public void cargarDetalle(){
        int id;
        id = Integer.parseInt(tId.getText());
    
        List<DetallePedido> lista = prodDat.listarDetallePorPedido(id);
        for(DetallePedido d:lista){
        tablaDetalle.addRow(new Object []{d.getIdDetalle(),id,d.getProducto(),d.getCantProd()});
        }
    }
    
   public void eliminarDetalle(){
   int fsel = tDetalle.getSelectedRow();
        
        if(fsel!=-1){
        int id = (int) tablaDetalle.getValueAt(fsel, 0);
        dpd.eliminarDetalle(id);
                }else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fila a eliminar");
            }
   }
    
    public void borrarFilasDet(){
    
        int a = tablaDetalle.getRowCount()-1;
        for(int i=a;i>=0;i--){
            tablaDetalle.removeRow(i);
            
        }
        
    }
    
    public void calcularEstrellas(){
    int id;
    int id2;
    id =Integer.parseInt(tId.getText());
    id2 =Integer.parseInt(tId.getText());
    pd.sumarEstrellasP(id,id2);
   
    tEstrellas.setText(pd.sumarEstrellasPedido(id)+"");
    }
    public void calcularImporte(){
    int id;
    id =Integer.parseInt(tId.getText());
    pd.sumarImpotePedido(id);
    pd.sumarImporteP(id);
    tImporte.setText(pd.sumarImpotePedido(id)+"");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        jdFIng = new com.toedter.calendar.JDateChooser();
        jdFEnt = new com.toedter.calendar.JDateChooser();
        tId = new javax.swing.JTextField();
        tCajas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbRev = new javax.swing.JComboBox<>();
        tImporte = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tEstrellas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bAgPed = new javax.swing.JButton();
        cEstado = new javax.swing.JCheckBox();
        bBuscar = new javax.swing.JButton();
        bActPed = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tCamp = new javax.swing.JTextField();
        bBaja = new javax.swing.JButton();
        bAlta = new javax.swing.JButton();
        bIncluir = new javax.swing.JButton();
        bQuitar = new javax.swing.JButton();
        jdFPag = new com.toedter.calendar.JDateChooser();
        cbProducto = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tCantidad = new javax.swing.JTextField();
        bActualizaCant = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PEDIDO");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Pedido");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DETALLE PEDIDO");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha de Ingreso");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha de Pago");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cantidad de Cajas");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha de Entrega");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estrellas del pedido");

        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tDetalle);

        tId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Revendedora");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Importe");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PRODUCTOS");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PEDIDO");

        bAgPed.setText("Agregar Pedido");
        bAgPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgPedActionPerformed(evt);
            }
        });

        cEstado.setText("Activo?");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bActPed.setText("Actualizar");
        bActPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActPedActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Campaña");

        bBaja.setText("Baja");
        bBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaActionPerformed(evt);
            }
        });

        bAlta.setText("Alta");
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });

        bIncluir.setText("Incluir");
        bIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncluirActionPerformed(evt);
            }
        });

        bQuitar.setText("Quitar");
        bQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQuitarActionPerformed(evt);
            }
        });

        jLabel14.setText("Producto");

        jLabel15.setText("Cantidad");

        bActualizaCant.setText("Actualizar Cantidad");
        bActualizaCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizaCantActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tId))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tCajas))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jdFPag, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jdFEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jdFIng, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tImporte, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tCamp, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tEstrellas)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(cbRev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bAgPed)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bActPed)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bBaja)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bAlta))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(bBuscar)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bIncluir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                                .addComponent(bQuitar)
                                .addGap(18, 18, 18)
                                .addComponent(bActualizaCant))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(cEstado)
                        .addGap(219, 219, 219)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdFIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdFEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdFPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tCamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bIncluir))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAgPed)
                        .addComponent(bActPed)
                        .addComponent(bBaja)
                        .addComponent(bAlta)
                        .addComponent(bLimpiar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bQuitar)
                        .addComponent(bActualizaCant)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdActionPerformed

    private void bAgPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgPedActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        Pedido p=null;
     LocalDate fechaIngreso;
     LocalDate fechaEntrega=null;
     LocalDate fechaPago=null;
     int cajas;
     //double importe;
     //int estrellaPedido;
     boolean estado;
     Revendedora revendedora;
     Camp camp;
        
        String fi=formato.format(jdFIng.getDate());
        fechaIngreso=LocalDate.parse(fi, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        String fe=formato.format(jdFEnt.getDate());
        fechaEntrega = LocalDate.parse(fe,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       
        String fp = formato.format(jdFPag.getDate());
        fechaPago = LocalDate.parse(fp,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        cajas = Integer.parseInt(tCajas.getText());
        
        //estrellaPedido = Integer.parseInt(tEstrellas.getText());
        
        //importe = Double.parseDouble(tImporte.getText());
        
        camp = cd.campañaActiva();
        
        revendedora = (Revendedora) cbRev.getSelectedItem();
        
        estado = cEstado.isSelected();
        p = new Pedido(fechaIngreso,fechaEntrega,fechaPago,cajas,estado, revendedora,camp);
        pd.agregarPedido(p);
        tId.setText(p.getIdPedido()+"");
        cargaProdNoSel();
        borrarFilasDet();
        cargarDetalle();

    }//GEN-LAST:event_bAgPedActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        try{
        Pedido p;
        int id;
        id = Integer.parseInt(tId.getText());
        p = pd.buscarPedido(id);
        
        
        jdFIng.setDate(Date.valueOf(p.getFechaIngreso()));
        jdFEnt.setDate(Date.valueOf(p.getFechaEntrega()));
        jdFPag.setDate(Date.valueOf(p.getFechaPago()));
        tCajas.setText(p.getCajas()+"");
        tEstrellas.setText(p.getEstrellaPedido()+"");
        tCamp.setText(p.getCamp().getIdCamp()+"");
        tImporte.setText(p.getImporte()+"");
        cbRev.setSelectedIndex(p.getRevendedora().getIdRevendedora()-1);
        
        cEstado.setSelected(p.isEstado());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"No se encontro el Pedido");
        }
        cargaProdNoSel();
        borrarFilasDet();
        cargarDetalle();
        calcularEstrellas();
        calcularImporte();
        
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bActPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActPedActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        Pedido p=null;
     LocalDate fechaIngreso;
     LocalDate fechaEntrega;
     LocalDate fechaPago;
     int cajas;
     double importe;
     int estrellaPedido;
     boolean estado;
     Revendedora revendedora;
     Camp camp;
     int id;
        
        id = Integer.parseInt(tId.getText());
        
        String fi=formato.format(jdFIng.getDate());
        fechaIngreso=LocalDate.parse(fi, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        String fe=formato.format(jdFEnt.getDate());
        fechaEntrega = LocalDate.parse(fe,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       
        String fp = formato.format(jdFPag.getDate());
        fechaPago = LocalDate.parse(fe,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        cajas = Integer.parseInt(tCajas.getText());
        
        estrellaPedido = Integer.parseInt(tEstrellas.getText());
        
        importe = Double.parseDouble(tImporte.getText());
        
       camp = cd.campañaActiva();
        
        revendedora = (Revendedora) cbRev.getSelectedItem();
        
        estado = cEstado.isSelected();
        p = new Pedido(id,fechaIngreso,fechaEntrega,fechaPago,cajas,estado, revendedora,camp);
        pd.actualizarPedido(p);
        cargaProdNoSel();
        borrarFilasDet();
        cargarDetalle();
        calcularEstrellas();
        calcularImporte();
        
    }//GEN-LAST:event_bActPedActionPerformed

    private void bBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaActionPerformed
        // TODO add your handling code here:
        try{
        int id;
        id = Integer.parseInt(tId.getText());
        pd.darDeBajaPedido(id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "No se encontro el pedido");
        }
    }//GEN-LAST:event_bBajaActionPerformed

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
        // TODO add your handling code here:
        try{
        int id;
        id = Integer.parseInt(tId.getText());
        pd.darDeAltaPedido(id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "No se encontro el pedido");
        }
    }//GEN-LAST:event_bAltaActionPerformed

    private void bIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIncluirActionPerformed
        // TODO add your handling code here:
        try{
      Pedido p = pd.buscarPedido(Integer.parseInt(tId.getText()));
      Producto prod = (Producto) cbProducto.getSelectedItem();
      int cantidad = Integer.parseInt(tCantidad.getText());
      DetallePedido dp = new DetallePedido(prod,p,cantidad);
      dpd.agregarDetallePedido(dp);
      pd.sumarEstrellasP(Integer.parseInt(tId.getText()),Integer.parseInt(tId.getText()));
      calcularEstrellas();
      calcularImporte();
      cargaProdNoSel();
        borrarFilasDet();
        cargarDetalle();
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Debe Completar los dos campos");
        }
    }//GEN-LAST:event_bIncluirActionPerformed

    private void bQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitarActionPerformed
        // TODO add your handling code here:
        eliminarDetalle();
        cargaProdNoSel();
        borrarFilasDet();
        cargarDetalle();
        pd.sumarEstrellasP(Integer.parseInt(tId.getText()),Integer.parseInt(tId.getText()));
        calcularEstrellas();
        calcularImporte();
    }//GEN-LAST:event_bQuitarActionPerformed

    private void bActualizaCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizaCantActionPerformed
        // TODO add your handling code here:
        int fsel = tDetalle.getSelectedRow();
        if(fsel!=-1){
         int idDet = Integer.valueOf(tablaDetalle.getValueAt(fsel,0)+"");
         int cant = Integer.valueOf(tablaDetalle.getValueAt(fsel, 3)+"");
        dpd.actualizarCantidad(idDet, cant);
        borrarFilasDet();
        cargarDetalle();
        calcularEstrellas();
        calcularImporte();
        JOptionPane.showMessageDialog(this, "Se actualizo la cantidad con exito");
                
                }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar");
        }
    }//GEN-LAST:event_bActualizaCantActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
        tId.setText("");
        jdFIng.setDate(null);
        jdFEnt.setDate(null);
        jdFPag.setDate(null);
        tCajas.setText("");
        tEstrellas.setText("");
        cd.campañaActiva();
        tImporte.setText("");
        
        cEstado.setSelected(false);

        
    }//GEN-LAST:event_bLimpiarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActPed;
    private javax.swing.JButton bActualizaCant;
    private javax.swing.JButton bAgPed;
    private javax.swing.JButton bAlta;
    private javax.swing.JButton bBaja;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bIncluir;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bQuitar;
    private javax.swing.JCheckBox cEstado;
    private javax.swing.JComboBox<Producto> cbProducto;
    private javax.swing.JComboBox<Revendedora> cbRev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFEnt;
    private com.toedter.calendar.JDateChooser jdFIng;
    private com.toedter.calendar.JDateChooser jdFPag;
    private javax.swing.JTextField tCajas;
    private javax.swing.JTextField tCamp;
    private javax.swing.JTextField tCantidad;
    private javax.swing.JTable tDetalle;
    private javax.swing.JTextField tEstrellas;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tImporte;
    // End of variables declaration//GEN-END:variables
}
