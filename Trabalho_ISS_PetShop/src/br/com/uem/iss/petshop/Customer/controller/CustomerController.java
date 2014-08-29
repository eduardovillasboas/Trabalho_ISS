/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Customer.view.CustomerView;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;

/**
 *
 * @author EDUARDO
 */
public class CustomerController {

    CustomerModel customerModel;
    CustomerView customerView;
    public CustomerController(CustomerModel m,ObserverJInternalFrame o) {
        customerModel = m;
        customerModel.initialize();
        customerView = new CustomerView(this,customerModel);
        customerView.register(o);
        o.addjDesktop(customerView);
    }

    public void exec() {
        customerModel.initialize();
        customerView.configure();
    }

    public void persist() {
        customerView.atualizeModelFromViewValues();
        customerModel.persist();
    }

}
