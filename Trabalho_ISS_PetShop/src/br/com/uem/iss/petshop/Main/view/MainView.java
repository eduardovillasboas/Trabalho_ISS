/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Main.view;

import br.com.uem.iss.petshop.Customer.controller.CustomerController;
import br.com.uem.iss.petshop.Customer.controller.CustomerListController;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Commons.view.PetshopListView;
import br.com.uem.iss.petshop.Main.controller.MainController;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/*.view*
 *
 * @author EDUARDO
 */
public class MainView extends javax.swing.JFrame implements ObserverJInternalFrame{

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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCustomerRecord = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

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

        jMenuItemCustomerRecord.setText("Cadastro de Clientes");
        jMenu1.add(jMenuItemCustomerRecord);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatorios");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sair");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCustomerRecord;
    // End of variables declaration//GEN-END:variables

    
    JFrame jMainFrame;
    public void createControls() {
        jMainFrame = this;
        createCustomerAction();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void createCustomerAction() {
        jMenuItemCustomerRecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                CustomerListModel listModel;
                listModel = new CustomerListModel();
                CustomerListController controller = 
                        new CustomerListController(listModel,jMainFrame);
                CustomerModel model;
                model = controller.exec();
                if (model == null)
                    return; 
                
                CustomerController c;
                c = new CustomerController(model, (ObserverJInternalFrame)jMainFrame);
                c.exec();
            }
        });
    }

    @Override
    public void addjDesktop(JInternalFrame customerView) {
        jDesktopPane1.add(customerView);
        try {
            customerView.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
        
    }
    @Override
    public void wasFinalized(JInternalFrame view) {
        jDesktopPane1.remove(view);
        jDesktopPane1.repaint();
    }
}
