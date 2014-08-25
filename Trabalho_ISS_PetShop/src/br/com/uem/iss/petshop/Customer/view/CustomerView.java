/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.view;

import br.com.uem.iss.petshop.Customer.controller.CustomerController;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Util.ObservableJInternalFrame;
import br.com.uem.iss.petshop.Util.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Util.ObserverModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class CustomerView extends javax.swing.JInternalFrame implements ObservableJInternalFrame, ObserverModel{

    /**
     * Creates new form CustomerView
     */
    CustomerController customerControler;
    CustomerModel customerModel;

    ArrayList<ObserverJInternalFrame> observerJInternalFrames;
    public CustomerView(CustomerController c, CustomerModel m) {
        initComponents();
        customerControler = c;
        customerModel = m;
        observerJInternalFrames = new ArrayList<>();
        updateViewFromModel();
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
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jFormattedTextFieldBirth = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonGravar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        jLabel1.setText("Nome:");

        jLabel2.setText("Sobrenome:");

        jTextFieldName.setText("jTextField1");

        jTextFieldLastName.setText("jTextField2");

        jFormattedTextFieldBirth.setText("jFormattedTextField1");
        jFormattedTextFieldBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldBirthActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de nascimento");

        jButtonGravar.setText("Gravar");

        jButtonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldName)
                    .addComponent(jFormattedTextFieldBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGravar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar))
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGravar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldBirthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JFormattedTextField jFormattedTextFieldBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void register(ObserverJInternalFrame o) {
        observerJInternalFrames.add(o);
    }

    @Override
    public void updateObserversWasFinalized(){
        for (ObserverJInternalFrame observerJInternalFrame : observerJInternalFrames) {
            observerJInternalFrame.wasFinalized(this);
        }
    }
    
    public void createActions(){
        createActionGravar();
        createActionCancelar();
    }
    
    public void configure() {
        createActions();
        setVisible(true);
    }

    @Override
    public void updateViews(String msg) {
        if (msg != null){
            JOptionPane.showMessageDialog(this, msg);
            return;
        }
        updateViewFromModel();
    }

    @Override
    public void errorOcurred(String error) {
        if (error != null)
            JOptionPane.showMessageDialog(this, error);
        else
            JOptionPane.showMessageDialog(this, "um erro desconhecido ocorreu");
    }

    private void createActionCancelar() {
        jButtonCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalizeCustomerView();
            }

        });
    }
    private void createActionGravar() {
        jButtonGravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });
    }
    
    private void finalizeCustomerView() {
        updateObserversWasFinalized();
        dispose();
    }
    
    private void gravar(){
        if (customerModel.getId() != null)
            customerModel.beginTransaction();
            
        customerModel.setName(jTextFieldName.getText());
        customerModel.setLastName(jTextFieldLastName.getText());
        customerModel.setBirthDat(new Date());
        
        if (customerModel.getId() == null)
            customerModel.persist();
        else
            customerModel.commit();
        
        finalizeCustomerView();
    }

    private void updateViewFromModel() {
        if (customerModel != null && customerModel.getCustomer() != null){
            jTextFieldName.setText(customerModel.getName());
            jTextFieldLastName.setText(customerModel.getLastName());
            jFormattedTextFieldBirth.setText(customerModel.getBirthDate().toString());
        } else {
            jTextFieldName.setText("");
            jTextFieldLastName.setText("");
            jFormattedTextFieldBirth.setText("");
        }
    }
    
}