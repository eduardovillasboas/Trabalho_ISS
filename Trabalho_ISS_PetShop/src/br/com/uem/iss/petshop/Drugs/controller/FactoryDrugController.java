/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Drugs.controller;

import br.com.uem.iss.petshop.Drugs.model.DrugModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryDrugController implements FactoryController{

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        DrugModel model = new DrugModel();
        model.setEntity(entity);
        DrugController c = new DrugController(model, 
                                              desktop, 
                                              listView);
        return c;
    }
    
}
