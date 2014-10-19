/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.ServiceOrder.controller;

import br.com.uem.iss.petshop.Commons.PetshopGeneratorReport;
import br.com.uem.iss.petshop.Main.view.MainView;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrder;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderListModel;
import br.com.uem.iss.petshop.reports.ServiceOrder.model.ServiceOrderReport;
import br.com.uem.iss.petshop.reports.ServiceOrder.model.ServiceOrderReportModel;
import br.com.uem.iss.petshop.reports.ServiceOrder.view.ServiceOrderReportView;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderReportController {

    private ServiceOrderReportView serviceOrderReportView;
    private ServiceOrderReportModel serviceOrderReportModel;
    public ServiceOrderReportController(MainView mainView, ServiceOrderReportModel serviceOrderReportModel) {
        this.serviceOrderReportModel = serviceOrderReportModel;
        serviceOrderReportView = new ServiceOrderReportView(mainView, true,this,this.serviceOrderReportModel);
    }

    public void exec() {
        serviceOrderReportModel.initialize();
        serviceOrderReportView.configure();
    }

    public Boolean generate(Date initialDate, Date finalDate) {
        ArrayList<ServiceOrderReport> serviceOrdersReport = new ArrayList<>();
        ArrayList<ServiceOrder> serviceOrders;
        
        ServiceOrderListModel serviceOrderListModel = new ServiceOrderListModel();
        serviceOrderListModel.initialize(initialDate, finalDate);
        
        serviceOrders = serviceOrderListModel.getServiceOrders();
        if (serviceOrders.size() == 0){
            serviceOrderReportView.message("nenhuma ordem de servico encontrada nesse período!");
            return false;
        }
        serviceOrdersReport = serviceOrderReportModel.generate(serviceOrders);
        
        PetshopGeneratorReport pg = new PetshopGeneratorReport();
        return pg.generateReport(ServiceOrderReportModel.REPORT_NAME,serviceOrdersReport);

    }
    
}
