/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class AnimalListModel extends AbstractModelList{

    private List<Animal> animals;

    public AnimalListModel() {
        super();
        animals = new ArrayList<>();
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return animals.get(value);
    }

    @Override
    public void initialize() {
        AnimalDAO animalDAO = new AnimalDAO();
        animals = animalDAO.getAllAnimals();
        try {
            
        } catch (Exception e) {
            animals = new ArrayList<>();
        } finally {
            animalDAO.close();
        }
        
    }
    
}
