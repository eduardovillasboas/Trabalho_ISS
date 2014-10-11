/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Animal.model.AnimalModel;
import br.com.uem.iss.petshop.Animal.model.Animal_;
import br.com.uem.iss.petshop.Animal.view.AnimalView;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Patology.model.Patology;
import br.com.uem.iss.petshop.Patology.model.PatologyListModel;
import br.com.uem.iss.petshop.Utils.DateUtil;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class AnimalController implements ControllerInterface{

    AnimalModel animalModel;
    AnimalView animalView;
    public AnimalController(AnimalModel m, 
                            ObserverJInternalFrame o,
                            ObserverJInternalFrame o2) {
        animalModel = m;
        m.initialize();
        animalView = new AnimalView(this, m);
        animalView.register(o);
        animalView.register(o2);
        o.addjDesktop(animalView);
     //   animalView.setPreferredSize(animalView.getParent().getSize());
     //   animalView.pack();
    }

    @Override
    public void exec() {
        animalModel.initialize();
        animalView.configure();
    }

    @Override
    public Boolean persist() {
        animalView.updateModelFromViewValues();
        return animalModel.persist();
    }

    public void addPathology() {
        PetshopEntity entity = selectPathology();
        if (entity != null)
            animalModel.add((Patology)entity);
    }

    private PetshopEntity selectPathology() {
        ListSelectController listSelectController;
        PatologyListModel pathologyListModel = new PatologyListModel();
        listSelectController = new ListSelectController(pathologyListModel);
        
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            animalView.updateViews("Nehuma pathologia cadastrada");
        
        return listSelectController.getPetshopEntity();
    }

    public void removePathology(Patology patology) {
        animalModel.removePathology(patology);
    }

    
}
