/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.RationBulkSale.controller;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Product.model.Product;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.RationBulkSale.view.RationBulkSaleView;
import br.com.uem.iss.petshop.Sales.model.ItemSale;
import br.com.uem.iss.petshop.Sales.model.SalesModel;

//import br.com.uem.iss.petshop.Sales.model.
/**
 *
 * @author Lucas
 */
public class RationBulkSaleController implements ControllerInterface {

    SalesModel salesModel;
    Product rationSale;
    Animal animalSale;
    Customer customerSale;

    public Customer getCustomerSale() {
        return customerSale;
    }

    public void setCustomerSale(Customer customerSale) {
        this.customerSale = customerSale;
    }

    public Animal getAnimalSale() {
        return animalSale;
    }

    public void setAnimalSale(Animal animalSale) {
        this.animalSale = animalSale;
    }
    RationBulkSaleView rationBulkSaleView;

    public RationBulkSaleController(SalesModel m,
            ObserverJInternalFrame o) {
        salesModel = m;
        salesModel.initialize();
        rationBulkSaleView = new RationBulkSaleView(this, salesModel);
        rationBulkSaleView.register(o);
        o.addjDesktop(rationBulkSaleView);

    }

    public PetshopEntity selectProduct() {
        ListSelectController listSelectController;
        ProductListModel prodListModel = new ProductListModel();
        listSelectController = new ListSelectController(prodListModel);

        StatusOperation status = listSelectController.exec();

        if (status == StatusOperation.EMPTY_ENTITY_MODEL) {
            rationBulkSaleView.updateViews("Nehum produto cadastrado");
        }

        setRationSale((Product) listSelectController.getPetshopEntity());

        return listSelectController.getPetshopEntity();
    }

    public PetshopEntity selectAnimal() {
        ListSelectController listSelectController;
        AnimalListModel animalListModel = new AnimalListModel();
        listSelectController = new ListSelectController(animalListModel);

        StatusOperation status = listSelectController.exec();

        if (status == StatusOperation.EMPTY_ENTITY_MODEL) {
            rationBulkSaleView.updateViews("Nehum animal adastrado");
        }

        setAnimalSale((Animal) listSelectController.getPetshopEntity());

        return listSelectController.getPetshopEntity();
    }

    public PetshopEntity selectCustomer() {
        ListSelectController listSelectController;
        CustomerListModel customerListModel = new CustomerListModel();
        listSelectController = new ListSelectController(customerListModel);

        StatusOperation status = listSelectController.exec();

        if (status == StatusOperation.EMPTY_ENTITY_MODEL) {
            rationBulkSaleView.updateViews("Nehum cliente adastrado");
        }

        setCustomerSale((Customer) listSelectController.getPetshopEntity());

        return listSelectController.getPetshopEntity();
    }

    @Override
    public void exec() {
        salesModel.initialize();
        rationBulkSaleView.configure();
    }

    @Override
    public Boolean persist() {
        rationBulkSaleView.atualizeModelFromViewValues();
        return salesModel.persist();
    }

    public Product getRationSale() {
        return rationSale;
    }

    public void setRationSale(Product rationSale) {
        this.rationSale = rationSale;
    }

}
