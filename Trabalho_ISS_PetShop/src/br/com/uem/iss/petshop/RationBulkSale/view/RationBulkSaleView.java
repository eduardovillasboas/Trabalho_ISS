/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.RationBulkSale.view;

import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.ViewInterface;
import br.com.uem.iss.petshop.Product.model.Product;
import br.com.uem.iss.petshop.Product.model.ProductDAO;
import br.com.uem.iss.petshop.RationBulkSale.controller.RationBulkSaleController;
import br.com.uem.iss.petshop.Sales.model.ItemSale;

/**
 *
 * @author Lucas
 */
import br.com.uem.iss.petshop.Sales.model.SalesModel;
import br.com.uem.iss.petshop.Utils.NumberUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class RationBulkSaleView extends javax.swing.JInternalFrame implements ViewInterface {

    RationBulkSaleController rationBulkSaleControler;
    SalesModel salesModel;
    private List<ItemSale> itens_sale = new ArrayList<ItemSale>();

    ArrayList<ObserverJInternalFrame> observerJInternalFrames;

    /**
     * Creates new form RationBulkSale
     */
    public RationBulkSaleView(RationBulkSaleController s, SalesModel m) {
        initComponents();
        rationBulkSaleControler = s;
        salesModel = m;
        observerJInternalFrames = new ArrayList<>();
//        ProductDAO productDAO = new ProductDAO();
//        products = productDAO.getAllProducts();        
        updateViewFromModel();
        salesModel.registerErrorObserver(this);
        salesModel.registerUpdate(this);
    }

    private void createSelectProductAction() {
        jButtonSelecionaProduto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectProductAction();
            }
        });
    }

    private void createSelectAnimalAction() {
        jButtonSelecionarAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectAnimalAction();
            }
        });
    }

    private void createSelectCustomerAction() {
        jButtonSelecionaCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectCustomerAction();
            }
        });
    }

    private void selectProductAction() {
        rationBulkSaleControler.selectProduct();
        jTextFieldProduto.setText(rationBulkSaleControler.getRationSale().getDescricao());

    }

    private void selectAnimalAction() {
        rationBulkSaleControler.selectAnimal();
        jTextFieldAnimal.setText(rationBulkSaleControler.getAnimalSale().getName());
    }

    private void selectCustomerAction() {
        rationBulkSaleControler.selectCustomer();
        jTextFieldCliente.setText(rationBulkSaleControler.getCustomerSale().getName() + " " + rationBulkSaleControler.getCustomerSale().getLastName());
    }

    private void createActionCancel() {
        jButtonCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalizeProductView();
            }

        });
    }

    private void finalizeProductView() {
        updateObserversWasFinalized();
        dispose();
    }

    private void actionRecord() {
        if ( rationBulkSaleControler.getAnimalSale() == null ) {
            JOptionPane.showMessageDialog( this, "Animal não selecionado!","Informação", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
        
        if ( rationBulkSaleControler.getCustomerSale() == null ) {
            JOptionPane.showMessageDialog( this, "Cliente não selecionado!","Informação", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
        
        if ( rationBulkSaleControler.getRationSale()== null ) {
            JOptionPane.showMessageDialog( this, "Item não selecionado!","Informação", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
        
        if (JOptionPane.showConfirmDialog(this, "Confirma gravação?", "Mensage do sistema", JOptionPane.INFORMATION_MESSAGE)
                != JOptionPane.YES_OPTION) {
            return;
        }

        if (rationBulkSaleControler.persist()) {
            finalizeProductView();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldAnimal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldValorDesejadoEmKG = new javax.swing.JFormattedTextField();
        jFormattedTextFieldValorDesejadoEmR$ = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jFormattedTextFieldQuantidadeDesejada = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldValorDesejadoEmR$2 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jButtonGravaVenda = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFormaDePagamento = new javax.swing.JComboBox();
        jButtonSelecionaProduto = new javax.swing.JButton();
        jButtonSelecionarAnimal = new javax.swing.JButton();
        jButtonSelecionaCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setTitle("Venda ração granel");

        jTextFieldAnimal.setEditable(false);

        jLabel5.setText("Descrição:");

        jLabel4.setText("Código Animal:");

        jLabel6.setText("Ração:");

        jTextFieldProduto.setEditable(false);

        jLabel7.setText("Descrição:");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Valor desejado em KG:");

        jFormattedTextFieldValorDesejadoEmKG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldValorDesejadoEmKG.setText("0.00");

        jFormattedTextFieldValorDesejadoEmR$.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldValorDesejadoEmR$.setText("0.00");
        jFormattedTextFieldValorDesejadoEmR$.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldValorDesejadoEmR$PropertyChange(evt);
            }
        });

        jLabel1.setText("Valor desejado em R$:");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFormattedTextFieldValorDesejadoEmR$, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFormattedTextFieldValorDesejadoEmKG, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldValorDesejadoEmR$, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldValorDesejadoEmKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jFormattedTextFieldValorDesejadoEmKG, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jFormattedTextFieldValorDesejadoEmR$, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jFormattedTextFieldQuantidadeDesejada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldQuantidadeDesejada.setText("0.00");

        jLabel8.setText("Valor em R$:");

        jFormattedTextFieldValorDesejadoEmR$2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldValorDesejadoEmR$2.setText("0.00");

        jLabel3.setText("Quantidade desejada:");

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFormattedTextFieldQuantidadeDesejada, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldValorDesejadoEmR$2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldValorDesejadoEmR$2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldQuantidadeDesejada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane3.setLayer(jFormattedTextFieldQuantidadeDesejada, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jFormattedTextFieldValorDesejadoEmR$2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCancel.setText("Cancela");

        jButtonGravaVenda.setText("Grava Venda");

        jLabel9.setText("Forma de pagamento:");

        jComboBoxFormaDePagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cartão de Débito", "Cartão de Crédito", "Dinehro", "Carnê" }));
        jComboBoxFormaDePagamento.setToolTipText("");

        jButtonSelecionaProduto.setText("Selecionar...");

        jButtonSelecionarAnimal.setText("Selecionar..");

        jButtonSelecionaCliente.setText("Selecionar...");

        jLabel10.setText("Cliente");

        jTextFieldCliente.setEditable(false);

        jLabel11.setText("Descrição:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGravaVenda)
                        .addGap(20, 20, 20))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSelecionaCliente)
                            .addComponent(jLabel10)
                            .addComponent(jButtonSelecionaProduto)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jButtonSelecionarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                                .addComponent(jTextFieldAnimal, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 153, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addGap(411, 411, 411))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionarAnimal)
                    .addComponent(jTextFieldAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSelecionaCliente)
                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionaProduto)
                    .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonGravaVenda))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldValorDesejadoEmR$PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorDesejadoEmR$PropertyChange
        // TODO add your handling code here:
        if (rationBulkSaleControler != null && rationBulkSaleControler.getRationSale() != null && evt.getNewValue() != null) {
            Double valorDesejadoEmReais = new Double(evt.getNewValue().toString());
            Float valorDoQuilo;
            valorDoQuilo = (rationBulkSaleControler.getRationSale().getPreco() / rationBulkSaleControler.getRationSale().getPesoLiquido());
            Double valorDesejadoEmKG;
            valorDesejadoEmKG = (valorDesejadoEmReais / valorDoQuilo);
            jFormattedTextFieldValorDesejadoEmKG.setText(valorDesejadoEmKG.toString().replace(".", ","));
        }
    }//GEN-LAST:event_jFormattedTextFieldValorDesejadoEmR$PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonGravaVenda;
    private javax.swing.JButton jButtonSelecionaCliente;
    private javax.swing.JButton jButtonSelecionaProduto;
    private javax.swing.JButton jButtonSelecionarAnimal;
    private javax.swing.JComboBox jComboBoxFormaDePagamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidadeDesejada;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorDesejadoEmKG;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorDesejadoEmR$;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorDesejadoEmR$2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldAnimal;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldProduto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void createActions() {
        createSelectProductAction();
        createActionCancel();
        createActionRecord();
        createSelectAnimalAction();
        createSelectCustomerAction();

    }

    private void createActionRecord() {
        jButtonGravaVenda.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionRecord();
            }
        });
    }

    @Override
    public void configure() {
        createActions();
        setVisible(true);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateModelFromViewValues() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateViewFromModel() {
//        for (Product product : products) {
//            jComboBoxCodigoRacao.add((PopupMenu)(Serializable)product);
//        }       

    }

    @Override
    public void register(ObserverJInternalFrame o) {
        observerJInternalFrames.add(o);
    }

    @Override
    public void updateObserversWasFinalized() {
        for (ObserverJInternalFrame observerJInternalFrame : observerJInternalFrames) {
            observerJInternalFrame.wasFinalized(this);
        }
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
        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
        } else {
            JOptionPane.showMessageDialog(this, "um erro desconhecido ocorreu");
        }
    }

    public void atualizeModelFromViewValues() {
        ItemSale i = new ItemSale();
        i.setCodigo_item(rationBulkSaleControler.getRationSale().getID());
        i.setQuantidade_vendida(new Double(jFormattedTextFieldQuantidadeDesejada.getText()));
        i.setValor(i.getQuantidade_vendida() * rationBulkSaleControler.getRationSale().getPreco());
        itens_sale.add(i);
        salesModel.setItens_sale(itens_sale);

        Double valor;
        valor = new Double(0);

        for (Iterator<ItemSale> iterator = itens_sale.iterator(); iterator.hasNext();) {
            ItemSale next = iterator.next();
            valor += next.getValor();
        }
        salesModel.setValor(valor);
        salesModel.setAnimal(null);
        salesModel.setCustomer(null);
        salesModel.setForma_pagamento(jComboBoxFormaDePagamento.toString());

    }

}