/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Service.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Service.model.ServiceModel;
import br.com.uem.iss.petshop.Service.view.ServiceView;

/**
 *
 * @author Lucas
 */
public class ServiceController implements ControllerInterface {

    ServiceModel serviceModel;
    ServiceView serviceView;

    public ServiceController(ServiceModel m, ObserverJInternalFrame o) {
        serviceModel = m;
        serviceModel.initialize();
        serviceView = new ServiceView(this, serviceModel);
        serviceView.register(o);
        o.addjDesktop(serviceView);
    }

    @Override
    public void exec() {
        serviceModel.initialize();
        serviceView.configure();
    }

    @Override
    public Boolean persist() {
        serviceView.atualizeModelFromViewValues();
        return serviceModel.persist();
    }

}
