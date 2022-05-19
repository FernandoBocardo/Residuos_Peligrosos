/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import entidades.EmpresaTransportadora;
import entidades.Residuo;
import entidades.SolicitudTraslado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import residuos_negocios.CtrlTraslados;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class FrmSeleccionarEmpresas extends javax.swing.JFrame {

    private final CtrlTraslados ctrlTraslados;
    private Residuo residuoSeleccionado;
    private SolicitudTraslado solicitudTraslado;
    
    /**
     * Creates new form FrmSeleccionarEmpresas
     */
    public FrmSeleccionarEmpresas() {
        initComponents();
        this.ctrlTraslados = new CtrlTraslados();
    }
    
    public FrmSeleccionarEmpresas(Residuo residuoSeleccionado, SolicitudTraslado solicitudTraslado) {
        initComponents();
        this.ctrlTraslados = new CtrlTraslados();
        this.residuoSeleccionado = residuoSeleccionado;
        this.solicitudTraslado = solicitudTraslado;
        llenarTablaEmpresasDisponibles();
    }
    
    private void llenarTablaEmpresasDisponibles(){
        DefaultTableModel modeloTabla = (DefaultTableModel)this.tblEmpresasDisponibles.getModel();
        modeloTabla = ctrlTraslados.llenarTablaEmpresasDisponibles(modeloTabla);
    }
    
    private EmpresaTransportadora getEmpresaDisponibleSeleccionada(){
        int indiceFilaSeleccionada = this.tblEmpresasDisponibles.getSelectedRow();
        if(indiceFilaSeleccionada != -1){
            DefaultTableModel modelo = (DefaultTableModel)this.tblEmpresasDisponibles.getModel();
            int indiceColumnaNombre = 0;
            EmpresaTransportadora EmpresaDisponibleSeleccionada = (EmpresaTransportadora) modelo.getValueAt(indiceFilaSeleccionada, 
                indiceColumnaNombre);
            return EmpresaDisponibleSeleccionada;
        }else{
            return null;
        }
    }
    
    private EmpresaTransportadora getEmpresaElegidaSeleccionada(){
        int indiceFilaSeleccionada = this.tblEmpresasSeleccionadas.getSelectedRow();
        if(indiceFilaSeleccionada != -1){
            DefaultTableModel modelo = (DefaultTableModel)this.tblEmpresasSeleccionadas.getModel();
            int indiceColumnaNombre = 0;
            EmpresaTransportadora EmpresaElegidaSeleccionado = (EmpresaTransportadora) modelo.getValueAt(indiceFilaSeleccionada, 
                indiceColumnaNombre);
            return EmpresaElegidaSeleccionado;
        }else{
            return null;
        }
    }
    
    private int getIndiceEmpresaElegidaSeleccionada(){
        int indiceFilaSeleccionada = this.tblEmpresasSeleccionadas.getSelectedRow();
        if(indiceFilaSeleccionada != -1){
            return indiceFilaSeleccionada;
        }else{
            return -1;
        }
    }
    
    private int getIndiceEmpresaDisponibleSeleccionada(){
        int indiceFilaSeleccionada = this.tblEmpresasDisponibles.getSelectedRow();
        if(indiceFilaSeleccionada != -1){
            return indiceFilaSeleccionada;
        }else{
            return -1;
        }
    }
    
    private void agregarTablaEmpresasSeleccionadas()
    {
        DefaultTableModel modeloTablaEmpresasSeleccionadas = (DefaultTableModel)this.tblEmpresasSeleccionadas.getModel();
        DefaultTableModel modeloTablaEmpresasDisponibles = (DefaultTableModel)this.tblEmpresasDisponibles.getModel();
        EmpresaTransportadora empresaDisponibleSeleccionado = getEmpresaDisponibleSeleccionada();
        int idQuimicoSeleccionado = getIndiceEmpresaDisponibleSeleccionada();
        modeloTablaEmpresasSeleccionadas = ctrlTraslados.agregarTablaEmpresasSeleccionadas(modeloTablaEmpresasSeleccionadas, empresaDisponibleSeleccionado, residuoSeleccionado);
        modeloTablaEmpresasDisponibles = ctrlTraslados.removerTablaEmpresasDisponibles(modeloTablaEmpresasDisponibles, idQuimicoSeleccionado);
    }
    
    private void removerTablaEmpresasSeleccionadas()
    {
        DefaultTableModel modeloTablaEmpresasSeleccionadas = (DefaultTableModel)this.tblEmpresasSeleccionadas.getModel();
        DefaultTableModel modeloTablaEmpresasDisponibles = (DefaultTableModel)this.tblEmpresasDisponibles.getModel();
        EmpresaTransportadora empresaElegidaSeleccionada = getEmpresaElegidaSeleccionada();
        int indiceComponenteSeleccionado = getIndiceEmpresaElegidaSeleccionada();
        modeloTablaEmpresasSeleccionadas = ctrlTraslados.removerTablaEmpresasSeleccionadas(modeloTablaEmpresasSeleccionadas, indiceComponenteSeleccionado, residuoSeleccionado);
        modeloTablaEmpresasDisponibles = ctrlTraslados.agregarTablaEmpresasDisponibles(modeloTablaEmpresasDisponibles, empresaElegidaSeleccionada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresasSeleccionadas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpresasDisponibles = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar empresas");

        tblEmpresasSeleccionadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Cantidad Asignada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmpresasSeleccionadas);
        if (tblEmpresasSeleccionadas.getColumnModel().getColumnCount() > 0) {
            tblEmpresasSeleccionadas.getColumnModel().getColumn(0).setResizable(false);
            tblEmpresasSeleccionadas.getColumnModel().getColumn(1).setResizable(false);
        }

        tblEmpresasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblEmpresasDisponibles);
        if (tblEmpresasDisponibles.getColumnModel().getColumnCount() > 0) {
            tblEmpresasDisponibles.getColumnModel().getColumn(0).setResizable(false);
        }

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAsignar)
                        .addGap(48, 48, 48)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAsignar)
                            .addComponent(btnCancelar))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(getEmpresaDisponibleSeleccionada()!= null)
        {
            agregarTablaEmpresasSeleccionadas();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una empresa disponible", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        if(getIndiceEmpresaElegidaSeleccionada()!= -1)
        {
            removerTablaEmpresasSeleccionadas();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una empresa para remover", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloTablaEmpresasSeleccionadas = (DefaultTableModel)this.tblEmpresasSeleccionadas.getModel();
        if(ctrlTraslados.verificarEmpresasSeleccionadas(modeloTablaEmpresasSeleccionadas))
        {
            if(ctrlTraslados.agregarAsignacionTraslado(residuoSeleccionado, modeloTablaEmpresasSeleccionadas, solicitudTraslado))
            {
                JOptionPane.showMessageDialog(this, "El traslado se asigno correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                new FrmAsignarTraslado(solicitudTraslado).setVisible(true);
                super.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "No se pudo asignar el traslado", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos una empresa", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        new FrmAsignarTraslado(solicitudTraslado).setVisible(true);
        super.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccionarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccionarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccionarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccionarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSeleccionarEmpresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmpresasDisponibles;
    private javax.swing.JTable tblEmpresasSeleccionadas;
    // End of variables declaration//GEN-END:variables
}
