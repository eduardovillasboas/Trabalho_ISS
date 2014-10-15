/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Main.view;

import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Main.controller.MainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/*.view*
 *
 * @author EDUARDO
 */
public class MainView extends javax.swing.JFrame implements ObserverJInternalFrame {

    /**
     * Creates new form MainView
     */
    MainController mainController;

    public MainView(MainController m) {
        initComponents();
        mainController = m;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemCustomerRecord = new javax.swing.JMenuItem();
        jMenuItemAnimalRecord = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemProductRecord = new javax.swing.JMenuItem();
        jMenuItemServiceRecord = new javax.swing.JMenuItem();
        jMenuItemServiceOrder = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItemDrugsRecord = new javax.swing.JMenuItem();
        jMenuItemVacinaRecord = new javax.swing.JMenuItem();
        jMenuItemPatologyRecord = new javax.swing.JMenuItem();
        jMenuItemCompanyRecord = new javax.swing.JMenuItem();
        jMenuItemLoginRecord = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemClose = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        jMenu1.setText("Manutencao");

        jMenu7.setText("Animais e Clientes");

        jMenuItemCustomerRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCustomerRecord.setText("Cadastro de Clientes");
        jMenuItemCustomerRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomerRecordActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemCustomerRecord);

        jMenuItemAnimalRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAnimalRecord.setText("Cadastro de Animais");
        jMenu7.add(jMenuItemAnimalRecord);

        jMenu1.add(jMenu7);

        jMenu6.setText("Produtos e Servicos");

        jMenuItemProductRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemProductRecord.setText("Cadastro de Produtos");
        jMenuItemProductRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductRecordActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemProductRecord);

        jMenuItemServiceRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemServiceRecord.setText("Cadastro de Serviços");
        jMenuItemServiceRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServiceRecordActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemServiceRecord);

        jMenuItemServiceOrder.setText("Ordem de serviço");
        jMenu6.add(jMenuItemServiceOrder);

        jMenu1.add(jMenu6);

        jMenu8.setText("Veterinaria");

        jMenuItemDrugsRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemDrugsRecord.setText("Cadastro de Medicamentos");
        jMenuItemDrugsRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDrugsRecordActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemDrugsRecord);

        jMenuItemVacinaRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemVacinaRecord.setText("Cadastro de Vacinas");
        jMenu8.add(jMenuItemVacinaRecord);

        jMenuItemPatologyRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemPatologyRecord.setText("Cadastro de Patologias");
        jMenu8.add(jMenuItemPatologyRecord);

        jMenu1.add(jMenu8);

        jMenuItemCompanyRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCompanyRecord.setText("Cadastro de Empresas");
        jMenuItemCompanyRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompanyRecordActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCompanyRecord);

        jMenuItemLoginRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemLoginRecord.setText("Cadastro de Login");
        jMenu1.add(jMenuItemLoginRecord);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatorios");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sair");

        jMenuItemClose.setText("Sair do sistema");
        jMenu4.add(jMenuItemClose);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCustomerRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomerRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCustomerRecordActionPerformed

    private void jMenuItemProductRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemProductRecordActionPerformed

    private void jMenuItemServiceRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemServiceRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemServiceRecordActionPerformed

    private void jMenuItemDrugsRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDrugsRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemDrugsRecordActionPerformed

    private void jMenuItemCompanyRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompanyRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCompanyRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAnimalRecord;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemCompanyRecord;
    private javax.swing.JMenuItem jMenuItemCustomerRecord;
    private javax.swing.JMenuItem jMenuItemDrugsRecord;
    private javax.swing.JMenuItem jMenuItemLoginRecord;
    private javax.swing.JMenuItem jMenuItemPatologyRecord;
    private javax.swing.JMenuItem jMenuItemProductRecord;
    private javax.swing.JMenuItem jMenuItemServiceOrder;
    private javax.swing.JMenuItem jMenuItemServiceRecord;
    private javax.swing.JMenuItem jMenuItemVacinaRecord;
    // End of variables declaration//GEN-END:variables

    JFrame jMainFrame;

    public void createControls() {
        jMainFrame = this;
        createCustomerAction();
        createProductAction();
        createAnimalAction();
        createPatologyAction();
        createServiceAction();
        createVacinaAction();
        createCompanyAction();
        createDrugsAction();
        createLoginAction();
        createCloseAction();
        createServiceOrderAction();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void createCustomerAction() {
        jMenuItemCustomerRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerAction();
            }
        });
    }

    private void customerAction() {
        mainController.customerAction();
    }

    private void createProductAction() {
        jMenuItemProductRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productAction();
            }
        });
    }
    
    private void productAction() {
        mainController.productAction();
    }
    
    private void createServiceAction() {
        jMenuItemServiceRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviceAction();
            }
        });
    }

    private void serviceAction(){
        mainController.serviceAction();
    }
    
    Stack<JInternalFrame> internalFrames = new Stack<>();
    @Override
    public void addjDesktop(JInternalFrame customerView) {
        jDesktopPane1.add(customerView);
        internalFrames.add(customerView);
        try {
            customerView.setSelected(true);
            jDesktopPane1.repaint();
        } catch (java.beans.PropertyVetoException e) {
        }

    }

    @Override
    public void wasFinalized(JInternalFrame view) {
        jDesktopPane1.remove(view);
        JInternalFrame internalFrame = null;
        if (!internalFrames.isEmpty()){
            internalFrames.remove(view);
            if (!internalFrames.isEmpty())
                internalFrame = internalFrames.peek();
        }
        try {
            if (internalFrame != null)
                internalFrame.setSelected(true);
        } catch (Exception e) {
        }
        /*TODO: REMOVER E ADICIONAR UTILIZAR UMA PILHA*/
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
    }

    private void createAnimalAction() {
        jMenuItemAnimalRecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                animalAction();
            }
        });
    }

    private void animalAction() {
        mainController.animalAction();
    }

    private void createPatologyAction() {
        jMenuItemPatologyRecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                patologyAction();
            }
        });
    }
    
    private void patologyAction() {
        mainController.patologyAction();
    }
    private void createVacinaAction() {
        jMenuItemVacinaRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vacinaAction();
            }
        });
    }
    
    private void vacinaAction(){
        mainController.vacinaAction();
    }
    
    private void createLoginAction() {
        jMenuItemLoginRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
    }
     private void createCompanyAction() {
        jMenuItemCompanyRecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                companyAction();
            }
        });
    }
    
    private void companyAction() {
        mainController.companyAction();
    }
           
    private void createDrugsAction() {
        jMenuItemDrugsRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drugsAction();
            }
        });
    }

    private void drugsAction(){
        mainController.drugsAction();
    }
    
    private void loginAction(){
        mainController.loginAction();
    }

    private void createCloseAction() {
        jMenuItemClose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closeAction();
            }
        });
    }
    
    private void closeAction() {
        dispose();
    }

    private void createServiceOrderAction() {
        jMenuItemServiceOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                serviceOrderAction();
            }
        });
    }
    
    private void serviceOrderAction() {
        mainController.serviceOrderAction();
    }
}
