/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Animal.model.AnimalModel;
import br.com.uem.iss.petshop.Animal.view.AnimalView;

/**
 *
 * @author EDUARDO
 */
public class AnimalController implements ControllerInterface{

    AnimalModel animalModel;
    AnimalView animalView;
    public AnimalController(AnimalModel m, ObserverJInternalFrame o) {
        animalModel = m;
        m.initialize();
        animalView = new AnimalView(this, m);
        animalView.register(o);
        o.addjDesktop(animalView);
    }

    @Override
    public void exec() {
        animalModel.initialize();
        animalView.configure();
    }

    @Override
    public void persist() {
        animalView.updateModelFromViewValues();
        animalModel.persist();
    }
    
    
}
