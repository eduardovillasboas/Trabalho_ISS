/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.view;

import br.com.uem.iss.petshop.Customer.controller.CustomerListController;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class CustomerListView extends javax.swing.JDialog implements ObserverModel{

    /**
     * Creates new form CustomerListView
     */
    CustomerListModel customerListModel;
    CustomerListController customerListController;
    public CustomerListView(java.awt.Frame parent, 
            boolean modal,
            CustomerListController c,
            CustomerListModel listModel) {
        super(parent, modal);
        initComponents();
        customerListModel = listModel;
        customerListController = c;
        state = State.STATE_CANCEL;
        customerListModel.registerErrorObserver(this);
        customerListModel.registerUpdate(this);
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        jButtonEdit.setText("Editar");

        jButtonDelete.setText("Deletar");

        jButtonCancel.setText("Cancelar");

        jButtonNew.setText("Novo");
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
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCustomerTable;
    // End of variables declaration//GEN-END:variables
    enum State{
        STATE_CANCEL,
        STATE_NEW,
        STATE_EDIT
    }
    private State state;
    public CustomerModel configure(AbstractTableModel tableModel) {
        createActions();
        CustomerModel customerModel;
        customerModel = new CustomerModel();
            
        if (tableModel.getRowCount() == 0){
            Customer c = new Customer();
            customerModel.setCustomer(c);
        }
        else {
            jTableCustomerTable.setModel(tableModel);
            setLocationRelativeTo(null);
            setVisible(true);
            if (state == State.STATE_CANCEL)
                return null;
            if (jTableCustomerTable.getSelectedRow() == -1 && state != State.STATE_NEW)
                return null;
            if (state != State.STATE_NEW){
                int value = jTableCustomerTable.getSelectedRow();
                Customer customer = customerListModel.getCustomerAt(value);
                customerModel.setCustomer(customer);
            }else{
                Customer c = new Customer();
                c.setId(null);
                c.setBirth(new Date());
                c.setLastName("");
                c.setName("");
                customerModel.setCustomer(c);
            }
        }
        return customerModel;
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
        state = State.STATE_NEW;
        dispose();
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
        state = State.STATE_EDIT;
        dispose();
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
        customerListController.delete(jTableCustomerTable.getSelectedRow());
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
    
}
