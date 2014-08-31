/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Customer.view.CustomerView;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;

/**
 *
 * @author EDUARDO
 */
public class CustomerController implements ControllerInterface{

    CustomerModel customerModel;
    CustomerView customerView;
    public CustomerController(CustomerModel m,ObserverJInternalFrame o) {
        customerModel = m;
        customerModel.initialize();
        customerView = new CustomerView(this,customerModel);
        customerView.register(o);
        o.addjDesktop(customerView);
    }

    @Override
    public void exec() {
        customerModel.initialize();
        customerView.configure();
    }

    @Override
    public void persist() {
        customerView.updateModelFromViewValues();
        customerModel.persist();
    }

}
