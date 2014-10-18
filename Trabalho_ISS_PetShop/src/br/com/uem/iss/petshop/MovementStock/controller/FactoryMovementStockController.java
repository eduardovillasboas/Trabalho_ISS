/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.FactoryController;
import br.com.uem.iss.petshop.MovementStock.model.MovementStockModel;

/**
 *
 * @author Lucas
 */
public class FactoryMovementStockController implements FactoryController {

    @Override
    public ControllerInterface factoty(PetshopEntity entity, ObserverJInternalFrame desktop, ObserverJInternalFrame listView) {
        MovementStockModel model = new MovementStockModel();
        model.setEntity(entity);
        MovementStockController c = new MovementStockController(model,
                desktop,
                null);
        return c;
    }

}
