/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryCustomerController implements FactoryController{

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        CustomerModel model = new CustomerModel();
        model.setEntity(entity);
        CustomerController c = new CustomerController(model, desktop, listView);
        
        return c;

    }
    
}
