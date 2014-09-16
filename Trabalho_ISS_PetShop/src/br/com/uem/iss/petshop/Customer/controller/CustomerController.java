/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.controller;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Customer.view.CustomerView;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;

/**
 *
 * @author EDUARDO
 */
public class CustomerController implements ControllerInterface{

    CustomerModel customerModel;
    CustomerView customerView;
    public CustomerController(CustomerModel m,ObserverJInternalFrame o,
            ObserverJInternalFrame o2) {
        customerModel = m;
        customerModel.initialize();
        customerView = new CustomerView(this,customerModel);
        customerView.register(o);
        customerView.register(o2);
        o.addjDesktop(customerView);
    }

    @Override
    public void exec() {
        customerModel.initialize();
        customerView.configure();
    }

    @Override
    public Boolean persist() {
        customerView.updateModelFromViewValues();
        return customerModel.persist();        
    }

    public void addAnimal() {
        ListSelectController listSelectController;
        AnimalListModel animalModel = new AnimalListModel();
        listSelectController = new ListSelectController(animalModel);
        PetshopEntity entity;
        entity = listSelectController.exec();
        customerModel.add((Animal)entity);
    }

}
