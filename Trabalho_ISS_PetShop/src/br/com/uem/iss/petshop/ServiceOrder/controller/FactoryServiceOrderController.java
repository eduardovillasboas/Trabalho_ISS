/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderModel;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryServiceOrderController implements FactoryController{

    @Override
    public ControllerInterface factoty(PetshopEntity entity, 
            ObserverJInternalFrame desktop, 
            ObserverJInternalFrame listView) {
        ServiceOrderModel serviceOrderModel = new ServiceOrderModel();
        serviceOrderModel.setEntity(entity);
        
        ServiceOrderController c = new ServiceOrderController(serviceOrderModel,
                                                              desktop,
                                                              listView);
        return c;
    }
    
}
