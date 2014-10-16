/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.RationBulkSale.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Sales.model.SalesModel;
import br.com.uem.iss.petshop.Utils.FactoryController;

/**
 *
 * @author Lucas
 */
public class FactoryRationBulkSaleController implements FactoryController{

    public RationBulkSaleController c; 
    
    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        SalesModel model = new SalesModel();
        model.setEntity(entity);
        //ProductController c = new ProductController(model, 
        //                                      desktop, 
        //                                      listView);
                
        c = new RationBulkSaleController(model, desktop );
        return c;
    }
    
}

