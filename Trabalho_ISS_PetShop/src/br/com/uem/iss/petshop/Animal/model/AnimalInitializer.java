/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EDUARDO
 */
public class AnimalInitializer {

    public AnimalInitializer() {
    }
    
    public Animal initializer(Animal animal){
        //DateUtil dateUtil = new DateUtil();
        if (animal == null)
            animal = new Animal();
        if (animal.getName() == null)
            animal.setName("");
        if (animal.getBirth() == null)
            animal.setBirth(new Date(0,0,0));
        
        if (animal.getBreed() == null)
            animal.setBreed("");
        if (animal.getCustomer() == null)
            animal.setCustomer(new ArrayList<>());
        if (animal.getHeight() == null)
            animal.setHeight(new Double(0));
        if (animal.getWeight() == null)
            animal.setWeight(new Double(0));

        return animal;
    }
}
