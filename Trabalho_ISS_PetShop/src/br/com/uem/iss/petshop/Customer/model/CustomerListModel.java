/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.Interfaces.ObservableModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class CustomerListModel implements ObservableModel{

    List<Customer> customers;
    ArrayList<ObserverModel> observersUpdateView;
    ArrayList<ObserverModel> observersError;
    public CustomerListModel() {
        customers = new ArrayList<>();
        observersError = new ArrayList<>();
        observersUpdateView = new ArrayList<>();
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
        Customer c = customers.get(selectedRow);
        customers.remove(selectedRow);
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.delete(c);
        updateObservers("Cliente "+c.getName().trim()+" deletado com sucesso!");
    }

    @Override
    public void updateErrorMessage(String msg) {
        for (ObserverModel observer : observersError) {
            observer.errorOcurred(msg);
        }
    }

    @Override
    public void updateObservers(String msg) {
        for (ObserverModel observer : observersError) {
            observer.updateViews(msg);
        }
    }

    @Override
    public void registerUpdate(ObserverModel o) {
        observersUpdateView.add(o);
    }

    @Override
    public void registerErrorObserver(ObserverModel o) {
        observersError.add(o);
    }
    
}
