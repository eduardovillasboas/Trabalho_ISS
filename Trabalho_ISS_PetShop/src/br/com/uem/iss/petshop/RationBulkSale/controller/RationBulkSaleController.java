/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.RationBulkSale.controller;

import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.RationBulkSale.view.RationBulkSaleView;
import br.com.uem.iss.petshop.Sales.model.SalesModel;

//import br.com.uem.iss.petshop.Sales.model.
/**
 *
 * @author Lucas
 */
public class RationBulkSaleController implements ControllerInterface {

    SalesModel salesModel;
    RationBulkSaleView rationBulkSaleView;

    public RationBulkSaleController(SalesModel m,
            ObserverJInternalFrame o) {
        salesModel = m;
        salesModel.initialize();
        rationBulkSaleView = new RationBulkSaleView(this, salesModel);
        rationBulkSaleView.register(o);

    }

    private PetshopEntity selectProduct() {
        ListSelectController listSelectController;
        ProductListModel prodListModel = new ProductListModel();
        listSelectController = new ListSelectController(prodListModel);

        StatusOperation status = listSelectController.exec();

        if (status == StatusOperation.EMPTY_ENTITY_MODEL) {
            rationBulkSaleView.updateViews("Nehum produto cadastrado");
        }

        return listSelectController.getPetshopEntity();
    }

    @Override
    public void exec() {
        salesModel.initialize();
        rationBulkSaleView.configure();
    }

    @Override
    public Boolean persist() {
        //rationBulkSaleView.atualizeModelFromViewValues();
        return salesModel.persist();
    }

}
