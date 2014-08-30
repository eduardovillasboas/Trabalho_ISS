/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.petshop.Animal.model;

import br.com.uem.iss.petshop.Interfaces.ObservableModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import java.util.ArrayList;

/**
 *
 * @author EDUARDO
 */
public class AnimalModel implements ObservableModel{

    private ArrayList<ObserverModel> updateObservers;
    private ArrayList<ObserverModel> errorMessageObservers;
    private AnimalDAO animalDAO;
    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public AnimalModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        animal = new Animal();
        animalDAO = new AnimalDAO();
        
    }
    
    
    @Override
    public void updateErrorMessage(String msg) {
        for (ObserverModel observer  : errorMessageObservers) {
            observer.errorOcurred(msg);
        }
    }

    @Override
    public void updateObservers(String msg) {
        for (ObserverModel updateObserver : updateObservers) {
            updateObserver.updateViews(msg);
        }
    }

    @Override
    public void registerUpdate(ObserverModel o) {
        updateObservers.add(o);
    }

    @Override
    public void registerErrorObserver(ObserverModel o) {
        errorMessageObservers.add(o);
    }

    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
