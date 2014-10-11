/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.controller;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderModel;
import br.com.uem.iss.petshop.ServiceOrder.view.ServiceOrderView;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderController implements ControllerInterface{

    final private ServiceOrderModel serviceOrderModel;
    final private ServiceOrderView serviceOrderView;
    ServiceOrderController(ServiceOrderModel m, 
                           ObserverJInternalFrame desktop, 
                           ObserverJInternalFrame listView) {
        serviceOrderModel = m;
        serviceOrderModel.initialize();
        serviceOrderView = new ServiceOrderView(this,serviceOrderModel);
        serviceOrderView.register(desktop);
        serviceOrderView.register(listView);
        desktop.addjDesktop(serviceOrderView);
        serviceOrderView.setPreferredSize(serviceOrderView.getParent().getSize());
        serviceOrderView.pack();
        serviceOrderView.disableTextFields();
    }

    @Override
    public void exec() {
        serviceOrderModel.initialize();
        serviceOrderView.configure();
    }

    @Override
    public Boolean persist() {
        /*
        TODO: AO CHAMAR NAO ESQUECER DE ANTES INVOCAR updateModelFromViewValues();
        */        
        return serviceOrderModel.persist();
    }

    public void selectCustomer() {
        ListSelectController listSelectController;
        CustomerListModel customerListModel = new CustomerListModel();
        customerListModel.initialize();
        listSelectController = new ListSelectController(customerListModel);
        
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            serviceOrderView.updateViews("Nenhum cliente cadastrado!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            serviceOrderModel.setCustomer((Customer)listSelectController.getPetshopEntity());
        }
        
    }

    public void selectAnimal() {
        ListSelectController listSelectController;
        AnimalListModel animalListModel = new AnimalListModel();
        animalListModel.initialize(serviceOrderModel.getCustomer().getAnimals());
        listSelectController = new ListSelectController(animalListModel);
        
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            serviceOrderView.updateViews("Nenhum animal cadastrado!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            serviceOrderModel.setAnimal((Animal)listSelectController.getPetshopEntity());
        }

    }
}
