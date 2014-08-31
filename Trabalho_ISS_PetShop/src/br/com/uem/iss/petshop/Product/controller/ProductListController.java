/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Product.controller;

import br.com.uem.iss.petshop.Commons.view.PetshopListView;
import br.com.uem.iss.petshop.Interfaces.ControllerListInterface;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.Utils.State;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class ProductListController implements ControllerListInterface {

    ProductListModel listModel;
    PetshopListView listView;

    public ProductListController(ProductListModel lm, JFrame jframe) {
        listModel = lm;
        listView = new PetshopListView(jframe,
                true,
                this,
                listModel);
    }

    /**
     *
     * @return
     */
    public PetshopEntity exec() {
        listModel.initialize();
        AbstractTableModel tableModel = new AbstractTableModel() {

            @Override
            public String getColumnName(int col) {
                return listModel.columnName(col);
            }

            @Override
            public int getRowCount() {
                return listModel.length();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return listModel.getValueAt(rowIndex, columnIndex);
            }
        };

        return listView.configure(tableModel);
    }

    @Override
    public void delete(int selectedRow) {
        listModel.delele(selectedRow);
    }

    @Override
    public State getState() {
        return listView.getState();
    }

}
