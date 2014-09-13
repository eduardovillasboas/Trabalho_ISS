/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Patology.model.PatologyModel;
import br.com.uem.iss.petshop.Patology.view.PatologyView;

/**
 *
 * @author EDUARDO
 */
public class PatologyController implements ControllerInterface{

    PatologyView patologyView;
    PatologyModel patologyModel;
    public PatologyController(  PatologyModel m,
                                ObserverJInternalFrame o,
                                ObserverJInternalFrame o2) {
        patologyModel = m;
        m.initialize();
        patologyView = new PatologyView(this,patologyModel);
        patologyView.register(o);
        patologyView.register(o2);
        o.addjDesktop(patologyView);
    }

    
    @Override
    public void exec() {
        patologyModel.initialize();
        patologyView.configure();
    }

    @Override
    public Boolean persist() {
        patologyView.updateModelFromViewValues();
        return patologyModel.persist();
    }
    
}
