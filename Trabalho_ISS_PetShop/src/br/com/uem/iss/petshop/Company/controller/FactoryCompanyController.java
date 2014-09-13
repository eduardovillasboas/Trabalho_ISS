/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.controller;

import br.com.uem.iss.petshop.Company.model.CompanyModel;
import br.com.uem.iss.petshop.Customer.controller.CustomerController;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryCompanyController implements FactoryController {

    @Override
    public ControllerInterface factoty(PetshopEntity entity, 
                                       ObserverJInternalFrame desktop, 
                                       ObserverJInternalFrame listView) {
        CompanyModel model = new CompanyModel();
        model.setEntity(entity);
        CompanyController c = new CompanyController(model, 
                                                    desktop, 
                                                    listView);
        return c;
    }

}
