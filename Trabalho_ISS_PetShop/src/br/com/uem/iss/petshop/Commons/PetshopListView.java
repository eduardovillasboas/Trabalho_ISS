/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Commons;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.ControllerListInterface;
import br.com.uem.iss.petshop.Interfaces.ModelListInterface;
import br.com.uem.iss.petshop.Interfaces.ObservableModel;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Utils.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class PetshopListView extends javax.swing.JDialog implements ObserverModel, ObserverJInternalFrame{

    /**
     * Creates new form CustomerListView
     */
    final private AbstractModelList listModel;
    final private ControllerListInterface controllerList;
    
    public PetshopListView(java.awt.Frame parent, 
            boolean modal,
            ControllerListInterface c,
            ModelListInterface l) {
        
        super(parent, modal);
        initComponents();
        listModel = (AbstractModelList)l;
        controllerList = c;
        state = State.STATE_CANCEL;
        ((ObservableModel)listModel).registerErrorObserver(this);
        ((ObservableModel)listModel).registerUpdate(this);
        setTitle(listModel.getTitle());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCustomerTable = new javax.swing.JTable();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableCustomerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonEdit.setText("Editar");
        jButtonEdit.setFocusable(false);
        jButtonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonDelete.setText("Deletar");
        jButtonDelete.setFocusable(false);
        jButtonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.setFocusable(false);
        jButtonCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonNew.setText("Novo");
        jButtonNew.setFocusable(false);
        jButtonNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonDelete, jButtonEdit, jButtonNew});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonDelete, jButtonEdit, jButtonNew});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCustomerTable;
    // End of variables declaration//GEN-END:variables
    private State state;
    public State getState(){
        return state;
    }
    
    public void configure() {
        createActions();
        execControllerInterface();
    }

    public void execControllerInterface(){
        jTableCustomerTable.revalidate();
        jTableCustomerTable.clearSelection();
        listModel.initialize();
        jTableCustomerTable.setModel(listModel.createModel());
        setLocationRelativeTo(null);
        setVisible(true);
    }
            
    @Override
    public void updateViews(String msg) {
        JOptionPane.showMessageDialog(this, msg);
        jTableCustomerTable.repaint();
   }

    @Override
    public void errorOcurred(String error) {
        JOptionPane.showMessageDialog(this, error);
    }
    
    public void createActions(){
        createNewAction();
        createEditAction();
        createDeleteAction();
        createCancelAction();
    }
    
    public void createNewAction(){
        jButtonNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newAction();
            }

        });
    }

    private void newAction() {
        controllerList.newAction();
    }
    
    public void createEditAction(){
        jButtonEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editAction();
            }

        });
    }

    private void editAction() {
        if (jTableCustomerTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
            return;
        }
        controllerList.editAction(listModel.getPetshopEntityAt(jTableCustomerTable.getSelectedRow()));
    }
    
    public void createDeleteAction(){
        jButtonDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAction();
                
            }

        });
    }
    
    private void deleteAction() {
        if (jTableCustomerTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Confirma deleção?", "Mensage do sistema", JOptionPane.INFORMATION_MESSAGE) != 
                JOptionPane.YES_OPTION)
            return;
        controllerList.delete(jTableCustomerTable.getSelectedRow());
        jTableCustomerTable.revalidate();
        jTableCustomerTable.clearSelection();
    }

    public void createCancelAction(){
        jButtonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }

        });
    }

    private void cancelAction() {
        state = State.STATE_CANCEL;
        dispose();
    }

    @Override
    public void wasFinalized(JInternalFrame view) {
        execControllerInterface();
    }

    @Override
    public void addjDesktop(JInternalFrame customerView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
