/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Abstract.model;

import br.com.uem.iss.petshop.Interfaces.ObservableModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author EDUARDO
 */
abstract public class AbstractObservableModel implements ObservableModel{
    
    final private ArrayList<ObserverModel> observersUpdateView;
    final private ArrayList<ObserverModel> observersError;

    public AbstractObservableModel() {
        observersError = new ArrayList<>();
        observersUpdateView = new ArrayList<>();
    }
    
    @Override
    public void updateErrorMessage(String msg) {
        for (ObserverModel observer : observersError) {
            observer.errorOcurred(msg);
        }
    }

    @Override
    public void updateObservers(String msg) {
        for (ObserverModel observer : observersError) {
            observer.updateViews(msg);
        }
    }

    @Override
    public void registerUpdate(ObserverModel o) {
        observersUpdateView.add(o);
    }

    @Override
    public void registerErrorObserver(ObserverModel o) {
        observersError.add(o);
    }
    
}
