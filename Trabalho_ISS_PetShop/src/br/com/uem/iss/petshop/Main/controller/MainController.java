/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Main.controller;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Animal.controller.FactoryAnimalController;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.PetshopListController;
import br.com.uem.iss.petshop.Company.controller.FactoryCompanyController;
import br.com.uem.iss.petshop.Company.model.CompanyListModel;
import br.com.uem.iss.petshop.Customer.controller.FactoryCustomerController;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.Drugs.controller.FactoryDrugController;
import br.com.uem.iss.petshop.Drugs.model.DrugListModel;
import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Login.controller.FactoryLoginController;
import br.com.uem.iss.petshop.Login.model.LoginListModel;
import br.com.uem.iss.petshop.Main.view.MainView;
import br.com.uem.iss.petshop.MovementStock.controller.FactoryMovementStockController;
import br.com.uem.iss.petshop.Patology.controller.FactoryPatologyController;
import br.com.uem.iss.petshop.Patology.model.PatologyListModel;
import br.com.uem.iss.petshop.Product.controller.FactoryProductController;
import br.com.uem.iss.petshop.Product.model.ProductListModel;
import br.com.uem.iss.petshop.RationBulkSale.controller.FactoryRationBulkSaleController;
import br.com.uem.iss.petshop.Service.controller.FactoryServiceController;
import br.com.uem.iss.petshop.Service.model.ServiceListModel;
import br.com.uem.iss.petshop.ServiceOrder.controller.FactoryServiceOrderController;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderListModel;
import br.com.uem.iss.petshop.Utils.FactoryController;
import br.com.uem.iss.petshop.Vacina.controller.FactoryVacinaController;
import br.com.uem.iss.petshop.Vacina.model.VacinaListModel;
import br.com.uem.iss.petshop.reports.DeliveryReceipt.controller.DeliveryReceiptController;
import br.com.uem.iss.petshop.reports.DeliveryReceipt.model.DeliveryReceiptModel;
import br.com.uem.iss.petshop.reports.ServiceOrder.controller.ServiceOrderReportController;
import br.com.uem.iss.petshop.reports.ServiceOrder.model.ServiceOrderReportModel;

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

    public void serviceOrderReport() {
        ServiceOrderReportModel serviceOrderReportModel = new ServiceOrderReportModel();
        ServiceOrderReportController serviceOrderReportController = new ServiceOrderReportController(mainView, serviceOrderReportModel);
        serviceOrderReportController.exec();
    }   

    public void reportDeliveryReceipt() {
        DeliveryReceiptModel deliveryReceiptModel = new DeliveryReceiptModel();
        DeliveryReceiptController deliveryReceiptController = new DeliveryReceiptController(mainView,deliveryReceiptModel);
        deliveryReceiptController.exec();
    }

    public void action(AbstractModelList listModel, FactoryController factoryController) {
        PetshopListController listController;
        listController = new PetshopListController(listModel, mainView, factoryController);
        listController.exec();
    }

    public void actionV(FactoryController factoryController) {
        ObserverJInternalFrame observerInterfalFrame = (ObserverJInternalFrame) mainView;
        ControllerInterface c;
        c = factoryController.factoty(null, observerInterfalFrame, null);
        c.exec();

    }
        
    public void movimentacaoEstoqueAction(){
        actionV(new FactoryMovementStockController());
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

    public void vendaGranelAction() {
        actionV(new FactoryRationBulkSaleController());
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

    public void serviceOrderAction() {
        action(new ServiceOrderListModel(), new FactoryServiceOrderController());
    }

}
