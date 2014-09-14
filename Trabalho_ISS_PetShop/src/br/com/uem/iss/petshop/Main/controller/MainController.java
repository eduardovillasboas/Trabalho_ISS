/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Main.controller;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Animal.controller.FactoryAnimalController;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.view.ListController;
import br.com.uem.iss.petshop.Company.controller.FactoryCompanyController;
import br.com.uem.iss.petshop.Company.model.CompanyListModel;
import br.com.uem.iss.petshop.Customer.controller.FactoryCustomerController;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Drugs.controller.FactoryDrugController;
import br.com.uem.iss.petshop.Drugs.model.DrugListModel;
import br.com.uem.iss.petshop.Login.controller.FactoryLoginController;
import br.com.uem.iss.petshop.Login.model.LoginListModel;
import br.com.uem.iss.petshop.Main.view.MainView;
import br.com.uem.iss.petshop.Patology.controller.FactoryPatologyController;
import br.com.uem.iss.petshop.Patology.model.PatologyListModel;
import br.com.uem.iss.petshop.Product.controller.FactoryProductController;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.Service.controller.FactoryServiceController;
import br.com.uem.iss.petshop.Service.model.ServiceListModel;
import br.com.uem.iss.petshop.Utils.FactoryController;
import br.com.uem.iss.petshop.Vacina.controller.FactoryVacinaController;
import br.com.uem.iss.petshop.Vacina.model.VacinaListModel;

/**
 *
 * @author EDUARDO
 */
public class MainController {

    MainView mainView;
    public MainController() {
        mainView = new MainView(this);
    }

    public boolean login() {
        return true;
    }

    public void exec() {
        mainView.createControls();
    }

    public void action(AbstractModelList listModel, FactoryController factoryController){
        ListController listController;
        listController = new ListController(listModel, mainView, factoryController);
        listController.exec();
    }

    public void customerAction() {
        action(new CustomerListModel(), new FactoryCustomerController());
    }

    public void productAction() {
        action(new ProductListModel(), new FactoryProductController());
    }

    public void serviceAction() {
        action(new ServiceListModel(), new FactoryServiceController());
    }

    public void animalAction() {
        action(new AnimalListModel(), new FactoryAnimalController());
    }

    public void patologyAction() {
        action(new PatologyListModel(), new FactoryPatologyController());
    }

    public void vacinaAction() {
        action(new VacinaListModel(), new FactoryVacinaController());
    }

    public void loginAction() {
        action(new LoginListModel(), new FactoryLoginController());
    }

    public void companyAction() {
        action(new CompanyListModel(), new FactoryCompanyController());
    }

    public void drugsAction() {
        action(new DrugListModel(), new FactoryDrugController());
    }
}
