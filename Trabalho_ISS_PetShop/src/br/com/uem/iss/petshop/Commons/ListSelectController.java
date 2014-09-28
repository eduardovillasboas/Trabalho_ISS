/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Commons;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;

/**
 *
 * @author EDUARDO
 */

public class ListSelectController {
    
    
    AbstractModelList modelList;
    ListSelectView listView;
    PetshopEntity entity;
    public ListSelectController( AbstractModelList ml) {
        modelList = ml;
        listView = new ListSelectView(null, 
                                      true, 
                                      ml, 
                                      this);
        
    }

    public StatusOperation exec() {
        entity = listView.configure();
        return listView.getStatusOperation();
    }
    
    public PetshopEntity getPetshopEntity(){
        return entity;
    }
}
