/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.controller;

import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.MovementStock.view.MovementStockView;
import br.com.uem.iss.petshop.MovementStock.model.MovementStockModel;
import br.com.uem.iss.petshop.Product.model.Product;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.Product.model.ProductModel;

/**
 *
 * @author Lucas
 */
public class MovementStockController implements ControllerInterface {

    MovementStockModel moviMovementStockModel;
    MovementStockView movementStockView;

    Product movementProductStock;

    public Product getMovementProductStock() {
        return movementProductStock;
    }

    public void setMovementProductStock(Product movementProductStock) {
        this.movementProductStock = movementProductStock;
    }

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
        ProductModel productModel = new ProductModel();
        Double estoque = movementProductStock.getEstoque();
        if (moviMovementStockModel.getTipo_Movimento().trim() == "ENTRADA") {
            estoque += moviMovementStockModel.getQuantidade();

        } else {
            estoque -= moviMovementStockModel.getQuantidade();
        }
        movementProductStock.setEstoque(estoque);
        productModel.setEntity(movementProductStock);        
        return productModel.persist() && moviMovementStockModel.persist();

    }

    public PetshopEntity selectProduct() {
        ListSelectController listSelectController;
        ProductListModel prodListModel = new ProductListModel();
        listSelectController = new ListSelectController(prodListModel);

        StatusOperation status = listSelectController.exec();

        if (status == StatusOperation.EMPTY_ENTITY_MODEL) {
            movementStockView.updateViews("Nehum produto cadastrado");
        }

        setMovementProductStock((Product) listSelectController.getPetshopEntity());

        return listSelectController.getPetshopEntity();
    }

}
