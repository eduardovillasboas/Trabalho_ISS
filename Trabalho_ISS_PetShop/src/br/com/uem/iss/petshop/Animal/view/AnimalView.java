/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.view;

import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Animal.controller.AnimalController;
import br.com.uem.iss.petshop.Animal.model.AnimalModel;
import br.com.uem.iss.petshop.Interfaces.ViewInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class AnimalView extends javax.swing.JInternalFrame implements ViewInterface{

    /**
     * Creates new form AnimalView
     */
    ArrayList<ObserverJInternalFrame> oberverInternalFrames;
    AnimalController animalController;
    AnimalModel animalModel;
    public AnimalView(AnimalController c,
                      AnimalModel m) {
        initComponents();
        animalController = c;
        animalModel = m;
        oberverInternalFrames = new ArrayList<>();
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
        jTextFieldName = new javax.swing.JTextField();

        jLabel1.setText("Nome:");

        jTextFieldName.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void register(ObserverJInternalFrame o) {
        oberverInternalFrames.add(o);
    }

    @Override
    public void updateObserversWasFinalized() {
        for (ObserverJInternalFrame observerJInternalFrame : oberverInternalFrames) {
            observerJInternalFrame.wasFinalized(this);
        }
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

    private void updateViewFromModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void configure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
