/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;
import br.com.uem.iss.petshop.Vacina.model.Vacina;
import br.com.uem.iss.petshop.Vacina.model.VacinaModel;

/**
 *
 * @author EDUARDO
 */
public class FactoryVacinaController implements FactoryController {

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        VacinaModel model = new VacinaModel();
        model.setEntity(entity);
        VacinaController c = new VacinaController(model, 
                                              desktop, 
                                              listView);
        return c;

    }
    
}
