/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.controller;

import br.com.uem.iss.petshop.Commons.view.PetshopListView;
import br.com.uem.iss.petshop.Interfaces.ControllerListInterface;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Patology.model.PatologyListModel;
import br.com.uem.iss.petshop.Utils.State;
import javax.swing.JFrame;

/**
 *
 * @author EDUARDO
 */
public class PatologyListController implements ControllerListInterface{

    PatologyListModel listModel;
    PetshopListView listView;
    public PatologyListController(PatologyListModel lm, JFrame jFrame) {
        listModel = lm;
        listView = new PetshopListView(jFrame, 
                true,
                this,
                listModel);
    }

    @Override
    public void delete(int selectedRow) {
        listModel.delele(selectedRow);
    }

    @Override
    public State getState() {
        return listView.getState();
    }

    @Override
    public PetshopEntity exec() {
        listModel.initialize();
        return listView.configure(listModel.createModel());
    }
    
}
