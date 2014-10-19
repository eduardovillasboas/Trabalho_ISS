/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.DeliveryReceipt.controller;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Commons.ListSelectController;
import br.com.uem.iss.petshop.Commons.PetshopGeneratorReport;
import br.com.uem.iss.petshop.Commons.StatusOperation;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerListModel;
import br.com.uem.iss.petshop.reports.DeliveryReceipt.model.DeliveryReceipt;
import br.com.uem.iss.petshop.reports.DeliveryReceipt.model.DeliveryReceiptModel;
import br.com.uem.iss.petshop.reports.DeliveryReceipt.view.DeliveryReceiptView;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author EDUARDO
 */
public class DeliveryReceiptController  {

    private DeliveryReceiptModel deliveryReceiptModel;
    private DeliveryReceiptView deliveryReceiptView;
    public DeliveryReceiptController(JFrame mainFrame, DeliveryReceiptModel deliveryReceiptModel) {
        this.deliveryReceiptModel = deliveryReceiptModel;
        deliveryReceiptView = new DeliveryReceiptView(mainFrame, true, this, deliveryReceiptModel);
    }

    public void exec() {
        deliveryReceiptModel.initialize();
        deliveryReceiptView.configure();

    }

    public Boolean generateReport() {
        ArrayList<DeliveryReceipt> deliveryReceiptModels = new ArrayList<>();
        deliveryReceiptModels.add(deliveryReceiptModel.getDeliveryReciReceipt());
        PetshopGeneratorReport pg = new PetshopGeneratorReport();
        return pg.generateReport(DeliveryReceiptModel.REPORT_NAME,deliveryReceiptModels);
    }

    public void selectCustomer() {
        ListSelectController listSelectController;
        CustomerListModel customerListModel = new CustomerListModel();
        customerListModel.initialize();
        listSelectController = new ListSelectController(customerListModel);
        
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            deliveryReceiptView.messageView("Nenhum cliente cadastrado!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            deliveryReceiptModel.setCustomer((Customer)listSelectController.getPetshopEntity());
        }

    }

    public void selectAnimal() {
        ListSelectController listSelectController;
        AnimalListModel animalListModel = new AnimalListModel();
        
        listSelectController = new ListSelectController(animalListModel);
        animalListModel.initialize(deliveryReceiptModel.getCustomer().getAnimals());
        StatusOperation status = listSelectController.exec();
        
        if (status == StatusOperation.EMPTY_ENTITY_MODEL)
            deliveryReceiptView.messageView("Nenhum animal cadastrado para esse cliente!");
        
        if (status == StatusOperation.SELECTED_ENTITY){
            deliveryReceiptModel.setAnimal((Animal)listSelectController.getPetshopEntity());
        }

    }

    public Boolean invalidFields() {
        if (deliveryReceiptModel.getCustomer() == null || deliveryReceiptModel.getCustomer().getName().isEmpty())
            deliveryReceiptView.messageView("Cliente não selecionado!");
        else if (deliveryReceiptModel.getAnimal() == null || deliveryReceiptModel.getAnimal().getName().isEmpty())
            deliveryReceiptView.messageView("Animal não selecionado!");
        else
            return false;
        
        return true;
    }

}
