/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.controller;

import br.com.uem.iss.petshop.Animal.DAO.AnimalDAO;
import br.com.uem.iss.petshop.Animal.model.AnimalModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author EDUARDO
 */
public class FactoryAnimalController implements FactoryController {

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        AnimalModel model = new AnimalModel(new AnimalDAO());
        model.setEntity(entity);
        AnimalController c = new AnimalController(model, 
                                                  desktop, 
                                                  listView);
        return c;
        
    }
    
}
