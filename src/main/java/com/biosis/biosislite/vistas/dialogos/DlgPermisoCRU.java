/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos;

import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.PermisoControlador;
import com.biosis.biosislite.controladores.TipoPermisoControlador;
import com.biosis.biosislite.entidades.AsignacionPermiso;
import com.biosis.biosislite.entidades.Permiso;
import com.biosis.biosislite.entidades.TipoPermiso;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.utiles.HerramientaGeneral;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Francis
 */
public class DlgPermisoCRU extends javax.swing.JDialog {

    /**
     * Creates new form DlgPermisoCRU
     */
    private List<AsignacionPermiso> asignacionList;
    private List<TipoPermiso> tipoPermisoList;
    private Permiso permiso;
    private int accion;
    private final PermisoControlador permc = new PermisoControlador();
    private final TipoPermisoControlador tpermc = new TipoPermisoControlador();
    private boolean accionRealizada = false;

    public DlgPermisoCRU(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        iniciarMascara();
        initComponents();
        
        spinners();
        bindeoSalvaje();
        permc.prepararCrear();
        this.permiso = permc.getSeleccionado();
        this.accion = Controlador.NUEVO;
        inicializar(permiso, accion);
    }

    public DlgPermisoCRU(JInternalFrame parent, Permiso permiso, int accion) {
        super(JOptionPane.getFrameForComponent(parent), true);
        iniciarMascara();
        initComponents();
        spinners();
        bindeoSalvaje();
        this.permiso = permiso;
        this.accion = accion;
        inicializar(permiso, accion);
        
        this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        grupoOpcion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTipoPermiso = new javax.swing.JComboBox();
        txtDocumento = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        pnlOpcion = new javax.swing.JPanel();
        radFecha = new javax.swing.JRadioButton();
        radHora = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlFin = new javax.swing.JPanel();
        txtFechaFin = new javax.swing.JFormattedTextField(this.mascaraFecha);
        jLabel7 = new javax.swing.JLabel();
        spHoraFin = new javax.swing.JSpinner();
        pnlInicio = new javax.swing.JPanel();
        txtFechaInicio = new javax.swing.JFormattedTextField(this.mascaraFecha);
        jLabel8 = new javax.swing.JLabel();
        spHoraInicio = new javax.swing.JSpinner();
        pnlEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        pnlAccionesEmpleado = new javax.swing.JPanel();
        btnAnadir = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        grupoOpcion.add(radFecha);
        grupoOpcion.add(radHora);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        lblTitulo.setBackground(new java.awt.Color(204, 204, 255));
        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Asignar Permiso");
        lblTitulo.setOpaque(true);
        jPanel1.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit_16x16.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar);

        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remove_16x16.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel_16x16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3.setLayout(jPanel3Layout);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Tipo de permiso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("Motivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel4, gridBagConstraints);

        cboTipoPermiso.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cboTipoPermiso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(cboTipoPermiso, gridBagConstraints);

        txtDocumento.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(txtDocumento, gridBagConstraints);

        txtMotivo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(txtMotivo, gridBagConstraints);

        pnlOpcion.setLayout(new javax.swing.BoxLayout(pnlOpcion, javax.swing.BoxLayout.LINE_AXIS));

        radFecha.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        radFecha.setSelected(true);
        radFecha.setText("Por fecha");
        radFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFechaActionPerformed(evt);
            }
        });
        pnlOpcion.add(radFecha);

        radHora.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        radHora.setText("Por hora");
        radHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHoraActionPerformed(evt);
            }
        });
        pnlOpcion.add(radHora);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        jPanel3.add(pnlOpcion, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("Fecha / Hora de inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setText("Fecha / Hora de fin:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel6, gridBagConstraints);

        pnlFin.setLayout(new java.awt.GridBagLayout());

        txtFechaFin.setColumns(10);
        txtFechaFin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaFin.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        pnlFin.add(txtFechaFin, new java.awt.GridBagConstraints());

        jLabel7.setText(" / ");
        pnlFin.add(jLabel7, new java.awt.GridBagConstraints());

        spHoraFin.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        spHoraFin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1453266000000L), null, null, java.util.Calendar.DAY_OF_MONTH));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlFin.add(spHoraFin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(pnlFin, gridBagConstraints);

        pnlInicio.setLayout(new java.awt.GridBagLayout());

        txtFechaInicio.setColumns(10);
        txtFechaInicio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaInicio.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        pnlInicio.add(txtFechaInicio, new java.awt.GridBagConstraints());

        jLabel8.setText(" / ");
        pnlInicio.add(jLabel8, new java.awt.GridBagConstraints());

        spHoraInicio.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        spHoraInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1453266000000L), null, null, java.util.Calendar.DAY_OF_MONTH));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlInicio.add(spHoraInicio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(pnlInicio, gridBagConstraints);

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));
        pnlEmpleados.setLayout(new java.awt.BorderLayout(0, 5));

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmpleado);

        pnlEmpleados.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlAccionesEmpleado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnAnadir.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        pnlAccionesEmpleado.add(btnAnadir);

        btnQuitar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus-16.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        pnlAccionesEmpleado.add(btnQuitar);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Find_16x16.png"))); // NOI18N
        jButton1.setText("Ver marcaciones");
        pnlAccionesEmpleado.add(jButton1);

        pnlEmpleados.add(pnlAccionesEmpleado, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        jPanel3.add(pnlEmpleados, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
        DlgEmpleado dlgEmpleado = new DlgEmpleado(this);
        Empleado empleado = dlgEmpleado.getSeleccionado();
        if (empleado != null) {
            long conteo = asignacionList.stream().filter(a -> a.getEmpleado().equals(empleado)).count();

            if (conteo == 0) {
                AsignacionPermiso asignacion = new AsignacionPermiso();
                asignacion.setPermiso(permiso);
                asignacion.setEmpleado(empleado);
                asignacionList.add(asignacion);
                permc.getSeleccionado().getAsignacionPermisoList().add(asignacion);
            }
        }
        System.out.println("EMPLEADO: " + empleado.getNombreCompleto());
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        volcarData(permc.getSeleccionado());

        if (permc.accion(accion)) {
            FormularioUtil.mensajeExito(this, accion);
            this.accionRealizada = true;
            this.dispose();
            
        }else{
            FormularioUtil.mensajeError(this, accion);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int fila = tblEmpleado.getSelectedRow();
        if (fila != -1) {
            AsignacionPermiso asignacion = asignacionList.get(fila);
            permc.getSeleccionado().getAsignacionPermisoList().remove(asignacion);
            asignacionList.remove(asignacion);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void radFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFechaActionPerformed
        // TODO add your handling code here:
        checkOpciones();
    }//GEN-LAST:event_radFechaActionPerformed

    private void radHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHoraActionPerformed
        // TODO add your handling code here:
        checkOpciones();
    }//GEN-LAST:event_radHoraActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.accion = Controlador.MODIFICAR;
        inicializar(permiso, accion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgPermisoCRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgPermisoCRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgPermisoCRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgPermisoCRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        PermisoControlador permc = new PermisoControlador();
        Permiso permiso = permc.buscarPorId((7L));
        java.awt.EventQueue.invokeLater(() -> {
            DlgPermisoCRU dialog = new DlgPermisoCRU(new javax.swing.JInternalFrame(), permiso, Controlador.LEER);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cboTipoPermiso;
    private javax.swing.ButtonGroup grupoOpcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAccionesEmpleado;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlFin;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlOpcion;
    private javax.swing.JRadioButton radFecha;
    private javax.swing.JRadioButton radHora;
    private javax.swing.JSpinner spHoraFin;
    private javax.swing.JSpinner spHoraInicio;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables

    private MaskFormatter mascaraFecha;

    private void spinners() {
        FormularioUtil.modeloSpinnerFechaHora(spHoraInicio, "HH:mm");
        FormularioUtil.modeloSpinnerFechaHora(spHoraFin, "HH:mm");
    }

    private void iniciarMascara() {
        try {
            this.mascaraFecha = new MaskFormatter("##/##/####");
            this.mascaraFecha.setPlaceholderCharacter('_');
//            this.mascara.setInvalidCharacters("A'");
        } catch (ParseException ex) {
            Logger.getLogger(DlgPermisoCRU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    NUEVO = campos en blanco
    EDITAR = campos llenos con lo que existe del permiso
    VER = campos llenos con lo que existe en el permiso sin capacidad de editar
     */
    private void inicializar(Permiso permiso, int accion) {
        switch (accion) {
            case Controlador.NUEVO:
                
                lblTitulo.setText("Generar permiso");
                btnCancelar.setText("Cancelar");
                break;
            case Controlador.MODIFICAR:
                lblTitulo.setText("Modificar permiso");
                btnCancelar.setText("Cancelar");
                break;
            case Controlador.LEER:
                lblTitulo.setText("Ver permiso");
                btnCancelar.setText("Cerrar");
                break;
        }

        permc.setSeleccionado(permiso);
        
        inicializarControles(accion);
        if (accion == Controlador.MODIFICAR || accion == Controlador.LEER) {
            llenarCampos(permiso);
        }
        
        if(accion != Controlador.LEER){
            checkOpciones();
        }

    }

    private void bindeoSalvaje() {
        asignacionList = ObservableCollections.observableList(new ArrayList<AsignacionPermiso>());
        tipoPermisoList = tpermc.buscarTodos();
        BeanProperty pDocumento = BeanProperty.create("empleado.nroDocumento");
        BeanProperty pNombreCompleto = BeanProperty.create("empleado.nombreCompleto");

        JTableBinding bindTable = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, asignacionList, tblEmpleado);
        bindTable.addColumnBinding(pDocumento).setColumnName("DNI").setEditable(false);
        bindTable.addColumnBinding(pNombreCompleto).setColumnName("Apellidos y nombres").setEditable(false);

        JComboBoxBinding bindCombo = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, tipoPermisoList, cboTipoPermiso);

        bindCombo.bind();
        bindTable.bind();

        cboTipoPermiso.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof TipoPermiso) {
                    value = ((TipoPermiso) value).getNombre();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    private void inicializarControles(int accion) {
        boolean leer = accion == Controlador.LEER;
        boolean leerModificar = accion == Controlador.LEER || accion == Controlador.MODIFICAR;
        boolean nuevoModificar = accion == Controlador.NUEVO || accion == Controlador.MODIFICAR;

        this.btnEditar.setVisible(accion == Controlador.LEER);
        this.btnEliminar.setVisible(leerModificar);
        this.btnGuardar.setVisible(nuevoModificar);
        this.pnlAccionesEmpleado.setVisible(nuevoModificar);
        
        this.cboTipoPermiso.setEnabled(!leer);
        this.txtDocumento.setEditable(!leer);
        this.txtMotivo.setEditable(!leer);
        this.txtFechaInicio.setEditable(!leer);
        this.txtFechaFin.setEditable(!leer);
        this.spHoraInicio.setEnabled(!leer);
        this.spHoraFin.setEnabled(!leer);
        this.radFecha.setEnabled(!leer);
        this.radHora.setEnabled(!leer);
    }

    private void llenarCampos(Permiso permiso) {
        this.txtDocumento.setText(permiso.getDocumento());
        this.txtMotivo.setText(permiso.getMotivo());
        this.cboTipoPermiso.setSelectedItem(permiso.getTipoPermiso());
        
        this.txtFechaInicio.setText(HerramientaGeneral.formatoFecha.format(permiso.getFechaInicio()));
        this.txtFechaFin.setText(HerramientaGeneral.formatoFecha.format(permiso.getFechaFin()));
        if(permiso.getOpcion() == 'H'){
            this.radHora.setSelected(true);
            this.spHoraInicio.setValue(permiso.getHoraInicio());
            this.spHoraFin.setValue(permiso.getHoraFin());
        }else{
            this.radFecha.setSelected(true);
            this.spHoraInicio.setValue(new Date(18000000));
            this.spHoraFin.setValue(new Date(18000000));
        }
        
        this.asignacionList.clear();
        this.asignacionList.addAll(permiso.getAsignacionPermisoList());
    }

    private void volcarData(Permiso permiso) {
        try {
            TipoPermiso tipoPermiso = (TipoPermiso) cboTipoPermiso.getSelectedItem();
            String strFechaInicio = this.txtFechaInicio.getText();
            String strFechaFin = this.txtFechaFin.getText();
            Date fechaInicio = HerramientaGeneral.formatoFecha.parse(strFechaInicio);
            Date fechaFin = radHora.isSelected() ? fechaInicio : HerramientaGeneral.formatoFecha.parse(strFechaFin);

            Date horaInicio = null;
            Date horaFin = null;
            if (radHora.isSelected()) {
                horaInicio = (Date) spHoraInicio.getValue();
                horaFin = (Date) spHoraFin.getValue();
            }

            permiso.setFechaInicio(fechaInicio);
            permiso.setFechaFin(fechaFin);
            permiso.setDocumento(txtDocumento.getText());
            permiso.setHoraInicio(horaInicio);
            permiso.setHoraFin(horaFin);
            permiso.setTipoPermiso(tipoPermiso);
            permiso.setOpcion(radFecha.isSelected() ? 'F' : 'H');
            permiso.setMotivo(txtMotivo.getText());
            permiso.setDiferencia(BigDecimal.ZERO);

        } catch (ParseException ex) {
            Logger.getLogger(DlgPermisoCRU.class.getName()).log(Level.SEVERE, null, ex.getCause().getMessage());
        }
    }

    private void checkOpciones() {
        this.txtFechaFin.setEnabled(radFecha.isSelected());
        this.spHoraInicio.setEnabled(radHora.isSelected());
        this.spHoraFin.setEnabled(radHora.isSelected());
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public boolean isAccionRealizada() {
        return accionRealizada;
    }
        
}
