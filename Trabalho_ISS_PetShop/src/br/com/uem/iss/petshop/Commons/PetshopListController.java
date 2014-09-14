/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Commons;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Commons.PetshopListView;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ControllerListInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;
import br.com.uem.iss.petshop.Utils.State;
import javax.swing.JFrame;

/**
 *
 * @author EDUARDO
 */
public class PetshopListController implements ControllerListInterface{

    AbstractModelList listModel;
    PetshopListView listView;
    ObserverJInternalFrame observerInterfalFrame;
    FactoryController factoryController;
    public PetshopListController(AbstractModelList lm, 
                                  JFrame jframe,
                                  FactoryController fc) {
        listModel = lm;
        observerInterfalFrame = (ObserverJInternalFrame)jframe;
        listView = new PetshopListView(jframe, 
                true,
                this,
                listModel );
        factoryController = fc;
    }

    @Override
    public void exec() {
        listModel.initialize();
        listView.configure();
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
    public void newAction() {

        ControllerInterface c;
        c = factoryController.factoty(null,
                                      observerInterfalFrame,
                                      listView);
        
        c.exec();
        listView.setVisible(false);

    }

    @Override
    public void editAction(PetshopEntity petshopEntity) {
        ControllerInterface c;
        c = factoryController.factoty(petshopEntity, observerInterfalFrame, listView);
        c.exec();
        listView.setVisible(false);
    }
    
    
}
