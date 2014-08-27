/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Customer.view.CustomerListView;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class CustomerListController {

    CustomerListModel listModel;
    CustomerListView listView;
    public CustomerListController(CustomerListModel lm, JFrame jframe) {
        listModel = lm;
        listView = new CustomerListView(jframe, true,this,listModel);
        
    }

    public CustomerModel exec() {
        listModel.initialize();
        AbstractTableModel tableModel = new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
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
                return listModel.getValueAt(rowIndex,columnIndex);
            }
        };

        return listView.configure(tableModel);
    }

    public void delete(int selectedRow) {
        listModel.delele(selectedRow);
    }

    
}
