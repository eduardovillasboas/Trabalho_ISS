/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Commons;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.ObservableModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class ListSelectView extends javax.swing.JDialog {

    /**
     * Creates new form ListQueryView
     */
    AbstractModelList modelList;
    ListSelectController listQueryController;
    public ListSelectView(java.awt.Frame parent, 
                         boolean modal,
                         AbstractModelList ml,
                         ListSelectController lc) {
        super(parent, modal);
        initComponents();
        modelList = ml;
        modelList.initialize();
        listQueryController = lc;
        status = StatusOperation.CANCEL_SELECT;
        jTableEntity.setModel(modelList.createModel());
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
        jTableEntity = new javax.swing.JTable();
        jButtonCancel = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableEntity.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableEntity);

        jButtonCancel.setText("Cancelar");

        jButtonSelect.setText("Selecionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancel)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelect)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSelect))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEntity;
    // End of variables declaration//GEN-END:variables

    public void createActions() {
        createActionSelection();
        createCancelAction();
    }
    
    StatusOperation status;
    StatusOperation getStatusOperation() {
        return status;
    }

    PetshopEntity entity;
    public PetshopEntity configure() {
        if (modelList.createModel().getRowCount() == 0){
            status = StatusOperation.EMPTY_ENTITY_MODEL;
            entity = null;
            return null; 
        }
            
        createActions();
        status = StatusOperation.CANCEL_SELECT;
        setLocationRelativeTo(null);
        setVisible(true);
        return entity;
    }

    private void createActionSelection() {
        jButtonSelect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionSelection();
            }
        });
    }
    
    private void actionSelection() {
        if (jTableEntity.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Nenhuma entidade selecionada");
            return;
        }
        status = StatusOperation.SELECTED_ENTITY;
        entity = (PetshopEntity)modelList.getPetshopEntityAt(jTableEntity.getSelectedRow());
        dispose();
    }
    
    private void createCancelAction() {
        jButtonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionCancel();
            }
        });
    }
    
    private void actionCancel() {
        status = StatusOperation.CANCEL_SELECT;
        entity = null;
        dispose();
    }
}
