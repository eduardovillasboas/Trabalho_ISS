/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class CustomerListModel extends AbstractModelList{

    private List<Customer> customers;
    public CustomerListModel() {
        customers = new ArrayList<>();
    }
    
    public int length() {
        return customers.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customers.get(rowIndex);
        if (columnIndex == 0)
            return customer.getID();
        
        return customer.getName();
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
        return "Nome";
    }

    public Customer getCustomerAt(int value) {
        return customers.get(value);
    }

    @Override
    public void initialize() {
        CustomerDAO customerDAO = new CustomerDAO();
        customers = customerDAO.getAllCustomers();
        try {
            
        } catch (Exception e) {
            customers = new ArrayList<>();
        } finally {
            customerDAO.close();
        }
    }

    public void delele(int selectedRow) {
        try {
            Customer c = customers.get(selectedRow);
            customers.remove(selectedRow);
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.delete(c);
            updateObservers("Cliente "+c.getName().trim()+" deletado com sucesso!");
        } catch (Exception e) {
            updateErrorMessage(e.getMessage());
        }
    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return customers.get(value);
    }
        public AbstractTableModel createModel(){
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
                return columnName(col);
            }
            
            @Override
            public int getRowCount() {
                return customers.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Customer c = customers.get(rowIndex);
                if (columnIndex == 0)
                    return c.getID();
                return c.getName();
            }
        };
    }

}
