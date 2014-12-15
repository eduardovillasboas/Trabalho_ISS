/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.controller;

import br.com.uem.iss.petshop.ServiceOrder.controllerInterfaces.ServiceOrderControllerInterface;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.Service.model.ServiceListModel;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderModel;
import br.com.uem.iss.petshop.ServiceOrder.view.ServiceOrderView;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderController implements ServiceOrderControllerInterface{

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
        if (serviceOrderModel.isClosed()){
            serviceOrderView.disableAllControls();
        }
        else if (serviceOrderModel.getAnimal() != null && !serviceOrderModel.getAnimal().getName().isEmpty()){
            serviceOrderView.enableEditMode();
        } else {
            serviceOrderView.enableInsertMode();
        }
        
        
        serviceOrderView.configure();
    }

    @Override
    public Boolean persist() {
        /*
        TODO: AO CHAMAR NAO ESQUECER DE ANTES INVOCAR updateModelFromViewValues();
        */        
        serviceOrderView.updateModelFromViewValues();
        return serviceOrderModel.persist();
    }

    @Override
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

    @Override
    public void selectAnimal() {
        ListSelectController listSelectController;
        AnimalListModel animalListModel = new AnimalListModel();
        
        listSelectController = new ListSelectController(animalListModel);
        animalListModel.initialize(serviceOrderModel.getCustomer().getAnimals());
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            serviceOrderView.updateViews("Nenhum animal cadastrado para esse cliente!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            serviceOrderModel.setAnimal((Animal)listSelectController.getPetshopEntity());
        }

    }

    @Override
    public void addService() {
        ListSelectController listSelectController;
        ServiceListModel serviceListModel = new ServiceListModel();
        listSelectController = new ListSelectController(serviceListModel);
        
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            serviceOrderView.updateViews("Nenhum serviço cadastrado!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            serviceOrderModel.addService((Service)listSelectController.getPetshopEntity());
        }
        
    }

    @Override
    public void calculeTotal() {
        serviceOrderModel.calculeTotal();
    }


    @Override
    public void removeService(int selected) {
        serviceOrderModel.remove(selected);
    }

    @Override
    public Boolean canPrint() {
        return true;
    }
}
