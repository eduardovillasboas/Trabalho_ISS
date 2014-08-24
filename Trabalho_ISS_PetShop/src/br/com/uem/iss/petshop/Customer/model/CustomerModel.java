/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.Util.ObservableModel;
import br.com.uem.iss.petshop.Util.ObserverModel;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EDUARDO
 */
public class CustomerModel implements ObservableModel{

    Customer customer;
    public void setCustomer(Customer c) {
        customer = c;
    }
    
    ArrayList<ObserverModel> updateObservers;
    ArrayList<ObserverModel> errorMessageObservers;

    public CustomerModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        customer = new Customer();
    }
    
    @Override
    public void registerErrorObserver(ObserverModel e) {
        errorMessageObservers.add(e);
    }
    
    @Override
    public void registerUpdate(ObserverModel e) {
        updateObservers.add(e);
    }
    
    @Override
    public  void updateErrorMessage(String msg){
        for (ObserverModel observer  : errorMessageObservers) {
            observer.errorOcurred(msg);
        }
    }
    
    @Override
    public void updateObservers(String msg){
        for (ObserverModel updateObserver : updateObservers) {
            updateObserver.updateViews(msg);
        }
    }

    public void initialize() {
        if (customer == null)
            customer = new Customer();
        
        if (customer.getName() == null)
            customer.setName("");
        if (customer.getLastName() == null)
            customer.setLastName("");
        if (customer.getBirth() == null)
            customer.setBirth(new Date());
        updateObservers(null);
    }

    public String getName() {
        return customer.getName();
    }

    public String getLastName() {
        return customer.getLastName();
    }

    public Date getBirthDate() {
        return customer.getBirth();
    }

    public void setName(String text) {
        customer.setName(text);
    }

    public void setLastName(String text) {
        customer.setLastName(text);
    }
    
    public void setBirthDat(Date date){
        customer.setBirth(date);
    }

    public void gravar() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.persist(customer);
    }
}
