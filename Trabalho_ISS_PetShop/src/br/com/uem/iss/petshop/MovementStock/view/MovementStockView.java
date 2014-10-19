/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.view;

import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.ViewInterface;
import br.com.uem.iss.petshop.MovementStock.model.MovementStockModel;
import java.util.ArrayList;
import br.com.uem.iss.petshop.MovementStock.controller.MovementStockController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MovementStockView extends javax.swing.JInternalFrame implements ViewInterface {

    MovementStockController movimentStockController;
    MovementStockModel movementStockModel;

    ArrayList<ObserverJInternalFrame> observerJInternalFrames;

    /**
     * Creates new form MovementStock
     */
    public MovementStockView(MovementStockController c, MovementStockModel m) {
        initComponents();
        movimentStockController = c;
        movementStockModel = m;
        observerJInternalFrames = new ArrayList<>();
        updateViewFromModel();
        movementStockModel.registerErrorObserver(this);
        movementStockModel.registerUpdate(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldQuantidade = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDescricaoItem = new javax.swing.JTextField();
        jButtonLancar = new javax.swing.JButton();
        jButtonSelecionarItem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldValorAtualEstoque = new javax.swing.JFormattedTextField();
        jButtonCancelar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setTitle("Movimentação de Estoque");

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setName("Movimentação de Estoque"); // NOI18N
        label1.setText("Movimentação de Estoque");

        jLabel1.setText("Tipo Movimento:");

        jLabel3.setText("Quantidade:");

        jFormattedTextFieldQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldQuantidade.setText("0.00");
        jFormattedTextFieldQuantidade.setToolTipText("");

        jLabel4.setText("Código:");

        jLabel5.setText("Descrição:");

        jTextFieldDescricaoItem.setEditable(false);

        jButtonLancar.setText("Lançar");
        jButtonLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLancarActionPerformed(evt);
            }
        });

        jButtonSelecionarItem.setText("Selecionar...");

        jLabel6.setText("Estoque Atual:");

        jFormattedTextFieldValorAtualEstoque.setEditable(false);

        jButtonCancelar.setText("Cancelar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENTRADA", "SAIDA" }));

        jLabel2.setText("Data:");

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLancar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSelecionarItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldDescricaoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jFormattedTextFieldValorAtualEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionarItem)
                    .addComponent(jTextFieldDescricaoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldValorAtualEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLancar)
                            .addComponent(jButtonCancelar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLancarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLancarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLancar;
    private javax.swing.JButton jButtonSelecionarItem;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorAtualEstoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldDescricaoItem;
    private java.awt.Label label1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    // End of variables declaration//GEN-END:variables

    private void finalizeMovementView() {
        updateObserversWasFinalized();
        dispose();
    }

    private void createActionRecord() {
        jButtonLancar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionRecord();
            }
        });
    }

    private void actionRecord() {
        if (JOptionPane.showConfirmDialog(this, "Confirma gravação?", "Mensage do sistema", JOptionPane.INFORMATION_MESSAGE)
                != JOptionPane.YES_OPTION) {
            return;
        }

        if (movimentStockController.persist()) {
            finalizeMovementView();
        }
    }

    private void createActionCancel() {
        jButtonCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalizeMovementView();
            }

        });
    }

    @Override
    public void createActions() {
        createActionCancel();
        createSelectProductAction();
        createActionRecord();
    }

    @Override
    public void configure() {
        createActions();
        setVisible(true);
    }

    @Override
    public void updateModelFromViewValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateViewFromModel() {
        jFormattedTextField1.setText(movementStockModel.getData_execution().toString());
    }

    @Override
    public void register(ObserverJInternalFrame o) {
        observerJInternalFrames.add(o);
    }

    @Override
    public void updateObserversWasFinalized() {
        observerJInternalFrames.stream().forEach((observerJInternalFrame) -> {
            observerJInternalFrame.wasFinalized(this);
        });
    }

    private void createSelectProductAction() {
        jButtonSelecionarItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectProductAction();
            }
        });
    }

    private void selectProductAction() {
        movimentStockController.selectProduct();
        jTextFieldDescricaoItem.setText(movimentStockController.getMovementProductStock().getDescricao());
        jFormattedTextFieldValorAtualEstoque.setText(movimentStockController.getMovementProductStock().getEstoque().toString());

    }

    @Override
    public void updateViews(String msg) {
        if (msg != null) {
            JOptionPane.showMessageDialog(this, msg);
            return;
        }
        updateViewFromModel();
    }

    @Override
    public void errorOcurred(String error) {
        if (error == null) {
            JOptionPane.showMessageDialog(this, "um erro desconhecido ocorreu");
        } else {
            JOptionPane.showMessageDialog(this, error);
        }
    }

    public void atualizeModelFromViewValues() {
        movementStockModel.setQuantidade(new Double(jFormattedTextFieldQuantidade.getText()));
        movementStockModel.setTipo_Movimento((String) jComboBox1.getSelectedItem());
        movementStockModel.setData_execution(new Date(System.currentTimeMillis()));
    }
}
