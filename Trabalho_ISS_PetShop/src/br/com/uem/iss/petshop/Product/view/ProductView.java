/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Product.view;

import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.ViewInterface;
import br.com.uem.iss.petshop.Product.controller.ProductController;
import br.com.uem.iss.petshop.Product.model.ProductModel;
import br.com.uem.iss.petshop.Utils.NumberUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ProductView extends javax.swing.JInternalFrame implements ViewInterface {

    ProductController productControler;
    ProductModel productModel;

    ArrayList<ObserverJInternalFrame> observerJInternalFrames;

    public ProductView(ProductController c, ProductModel m) {
        initComponents();
        productControler = c;
        productModel = m;
        observerJInternalFrames = new ArrayList<>();
        updateViewFromModel();
        productModel.registerErrorObserver(this);
        productModel.registerUpdate(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        label1 = new java.awt.Label();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldCodigo = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldPesoLiquido = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPesoBruto = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEstoque = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUnidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldPreco = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();
        jButtonRecord = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setText("Cadastro de Produtos");

        jLabel1.setText("Código:");

        jFormattedTextFieldCodigo.setEditable(false);
        jFormattedTextFieldCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldCodigo.setText("0");

        jLabel2.setText("Descrição:");

        jTextFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescricaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Peso Liquido:");

        jFormattedTextFieldPesoLiquido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0,00"))));
        jFormattedTextFieldPesoLiquido.setText("0,00");
        jFormattedTextFieldPesoLiquido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPesoLiquidoActionPerformed(evt);
            }
        });

        jFormattedTextFieldPesoBruto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0,00"))));
        jFormattedTextFieldPesoBruto.setText("0,00");

        jFormattedTextFieldEstoque.setEditable(false);
        jFormattedTextFieldEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldEstoque.setText("0,00");

        jLabel7.setText("Estoque:");

        jLabel6.setText("Peso Bruto: ");

        jLabel3.setText("Unidade:");

        jTextFieldUnidade.setColumns(3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel4.setText("(Tamanho máximo 3)");

        jLabel8.setText("Preço:");

        jFormattedTextFieldPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0,00"))));
        jFormattedTextFieldPreco.setText("0,00");

        jLabel9.setText("Marca:");

        jButtonCancel.setText("Cancelar");

        jButtonRecord.setText("Gravar");
        jButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFormattedTextFieldPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(495, 495, 495)
                        .addComponent(jButtonCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonRecord))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldPesoLiquidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPesoLiquidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPesoLiquidoActionPerformed

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed

    private void jButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonRecord;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigo;
    private javax.swing.JFormattedTextField jFormattedTextFieldEstoque;
    private javax.swing.JFormattedTextField jFormattedTextFieldPesoBruto;
    private javax.swing.JFormattedTextField jFormattedTextFieldPesoLiquido;
    private javax.swing.JFormattedTextField jFormattedTextFieldPreco;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldUnidade;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateViewFromModel() {
        if (productModel != null && productModel.getProduct() != null) {
            jFormattedTextFieldCodigo.setText("0");
            jFormattedTextFieldEstoque.setText(productModel.getEstoque().toString());
            jFormattedTextFieldPesoBruto.setText(productModel.getPesoBruto().toString());
            jFormattedTextFieldPesoLiquido.setText(productModel.getPesoLiquido().toString());
            jFormattedTextFieldPreco.setText(productModel.getPreco().toString());
            jTextFieldDescricao.setText(productModel.getDescricao());
            jTextFieldMarca.setText(productModel.getMarca());
            jTextFieldUnidade.setText(productModel.getUndade());
        } else {
            jFormattedTextFieldCodigo.setText("0");
            jFormattedTextFieldEstoque.setText("");
            jFormattedTextFieldPesoBruto.setText("");
            jFormattedTextFieldPesoLiquido.setText("");
            jFormattedTextFieldPreco.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldMarca.setText("");
            jTextFieldUnidade.setText("");
        }
    }

    private void finalizeProductView() {
        updateObserversWasFinalized();
        dispose();
    }

    private void record() {
        if (productControler.persist()) {
            finalizeProductView();
        }

    }

    private void createActionCancel() {
        jButtonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalizeProductView();
            }

        });
    }

    private void createActionRecord() {
        jButtonRecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                record();
            }
        });
    }

    @Override
    public void createActions() {
        createActionRecord();
        createActionCancel();
    }

    @Override
    public void configure() {
        createActions();
        setVisible(true);
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
        productModel.setEstoque(new Double(jFormattedTextFieldEstoque.getText()));
        productModel.setPesoBruto(NumberUtil.toFloat(jFormattedTextFieldPesoBruto.getText()));
        productModel.setPesoLiquido(NumberUtil.toFloat(jFormattedTextFieldPesoLiquido.getText()));
        productModel.setPreco(NumberUtil.toFloat(jFormattedTextFieldPreco.getText()));
        productModel.setDescricao(jTextFieldDescricao.getText());
        productModel.setMarca(jTextFieldMarca.getText());
        productModel.setUndade(jTextFieldUnidade.getText());
    }

    @Override
    public void updateModelFromViewValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
