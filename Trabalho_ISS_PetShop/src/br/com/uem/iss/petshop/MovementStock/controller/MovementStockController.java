/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.MovementStock.view.MovementStockView;
import br.com.uem.iss.petshop.MovementStock.model.MovementStockModel;

/**
 *
 * @author Lucas
 */
public class MovementStockController implements ControllerInterface {

    MovementStockModel moviMovementStockModel;
    MovementStockView movementStockView;

    public MovementStockController(MovementStockModel m,
            ObserverJInternalFrame o,
            ObserverJInternalFrame o2) {
        moviMovementStockModel = m;
        moviMovementStockModel.initialize();
        movementStockView = new MovementStockView(this, moviMovementStockModel);
        movementStockView.register(o);
        movementStockView.register(o2);
        o.addjDesktop(movementStockView);
    }

    @Override
    public void exec() {
        moviMovementStockModel.initialize();
        movementStockView.configure();

    }

    @Override
    public Boolean persist() {
        movementStockView.atualizeModelFromViewValues();
        return moviMovementStockModel.persist();

    }

}
