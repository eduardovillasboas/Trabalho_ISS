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
    public PatologyController(PatologyModel m,ObserverJInternalFrame o) {
        patologyModel = m;
        m.initialize();
        patologyView = new PatologyView(this,patologyModel);
    }

    
    @Override
    public void exec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
