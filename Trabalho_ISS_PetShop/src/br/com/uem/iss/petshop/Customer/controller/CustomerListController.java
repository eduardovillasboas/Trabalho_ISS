/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Commons.view.PetshopListView;
import br.com.uem.iss.petshop.Interfaces.PetshopListControllerInterface;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class CustomerListController implements PetshopListControllerInterface{

    CustomerListModel listModel;
    PetshopListView listView;
    public CustomerListController(CustomerListModel lm, JFrame jframe) {
        listModel = lm;
        listView = new PetshopListView(jframe, true,this,listModel);
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

        return (CustomerModel)listView.configure(tableModel);
    }

    @Override
    public void delete(int selectedRow) {
        listModel.delele(selectedRow);
    }

    @Override
    public Object execControllerInterface(AbstractTableModel tableModel, JTable jTableCustomerTable) {
        CustomerModel customerModel;
        customerModel = new CustomerModel();
            
        if (tableModel.getRowCount() == 0){
            Customer c = new Customer();
            customerModel.setCustomer(c);
        }
        else {
            jTableCustomerTable.setModel(tableModel);
            listView.setLocationRelativeTo(null);
            listView.setVisible(true);
            if (listView.getState() == PetshopListView.State.STATE_CANCEL)
                return null;
            if (jTableCustomerTable.getSelectedRow() == -1 && listView.getState() != PetshopListView.State.STATE_NEW)
                return null;
            if (listView.getState() == PetshopListView.State.STATE_NEW){
                Customer c = new Customer();
                c.setId(null);
                c.setBirth(new Date());
                c.setLastName("");
                c.setName("");
                customerModel.setCustomer(c);
            }else{
                int value = jTableCustomerTable.getSelectedRow();
                Customer customer = listModel.getCustomerAt(value);
                customerModel.setCustomer(customer);
            }
        }
        return customerModel;
    }

    
}
