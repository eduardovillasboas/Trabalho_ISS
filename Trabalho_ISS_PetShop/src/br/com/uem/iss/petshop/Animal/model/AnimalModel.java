/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;

/**
 *
 * @author EDUARDO
 */
public class AnimalModel extends AbstractModel{

    private AnimalDAO animalDAO;
    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public AnimalModel() {
        animal = new Animal();
        animalDAO = new AnimalDAO();
        
    }

    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
