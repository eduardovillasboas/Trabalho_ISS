/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Login.controller;

import br.com.uem.iss.petshop.Commons.view.PetshopListView;
import br.com.uem.iss.petshop.Interfaces.ControllerListInterface;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Login.model.LoginListModel;
import br.com.uem.iss.petshop.Utils.State;
import javax.swing.JFrame;

/**
 *
 * @author Ricardo Andrade
 */
public class LoginListController implements ControllerListInterface{

    LoginListModel listModel;
    PetshopListView listView;
    public LoginListController(LoginListModel m,JFrame jFrame) {
        listModel = m;
        listModel.initialize();
        listView = new PetshopListView(jFrame, true, this, m);
    }

    @Override
    public void delete(int selectedRow) {
        listModel.delete(selectedRow);
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
