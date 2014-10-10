/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderModel;
import br.com.uem.iss.petshop.ServiceOrder.view.ServiceOrderView;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderController implements ControllerInterface{

    ServiceOrderModel serviceOrderModel;
    ServiceOrderView serviceOrderView;
    ServiceOrderController(ServiceOrderModel m, 
                           ObserverJInternalFrame desktop, 
                           ObserverJInternalFrame listView) {
        serviceOrderModel = m;
        serviceOrderModel.initialize();
        serviceOrderView = new ServiceOrderView(this,serviceOrderModel);
        serviceOrderView.register(desktop);
        serviceOrderView.register(listView);
        desktop.addjDesktop(serviceOrderView);
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
    
}
