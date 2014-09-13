/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Patology.model.PatologyModel;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryPatologyController implements FactoryController{

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        PatologyModel model = new PatologyModel();
        model.setEntity(entity);
        PatologyController c = new PatologyController(model, 
                                              desktop, 
                                              listView);
        return c;
    }
    
}
