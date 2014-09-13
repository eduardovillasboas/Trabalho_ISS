/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Drugs.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Drugs.model.DrugModel;
import br.com.uem.iss.petshop.Drugs.view.DrugView;

/**
 *
 * @author Rafael
 */
public class DrugController implements ControllerInterface {

    DrugModel drugModel;
    DrugView drugView;

    public DrugController(DrugModel m, 
                          ObserverJInternalFrame o,
                          ObserverJInternalFrame o2) {
        drugModel = m;
        drugModel.initialize();
        drugView = new DrugView(this, drugModel);
        drugView.register(o);
        drugView.register(o2);
        o.addjDesktop(drugView);
    }

    @Override
    public void exec() {
        drugModel.initialize();
        drugView.configure();
    }

    @Override
    public Boolean persist() {
        drugView.atualizeModelFromViewValues();
        return drugModel.persist();
    }

}

