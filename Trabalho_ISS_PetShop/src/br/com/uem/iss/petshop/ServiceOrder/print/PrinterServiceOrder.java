/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.print;

import br.com.uem.iss.petshop.Commons.PetshopGeneratorReport;
import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrderModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class PrinterServiceOrder {

    ServiceOrderModel serviceOrderModel;
    public PrinterServiceOrder() {
        
    }
    
    public void setServiceOrder(ServiceOrderModel serviceOrderModel) {
        this.serviceOrderModel = serviceOrderModel;
    }

    public Boolean generate() {
        Double totalValue;
        totalValue = new Double(0d);
        PrintableServiceOrder printableServiceOrder = new PrintableServiceOrder();
        printableServiceOrder.setCustomerName(serviceOrderModel.getCustomerName());
        printableServiceOrder.setAnimalName(serviceOrderModel.getAnimalName());
        printableServiceOrder.setPaymentType(serviceOrderModel.getPaymentType().toString());
        printableServiceOrder.setEntryValue(serviceOrderModel.getEntryValue());
        List<Service> services = serviceOrderModel.getServices();
        printableServiceOrder.setServiceName(services.get(0).getDescricao());
        printableServiceOrder.setServiceValue(services.get(0).getPreco().toString());
        totalValue += services.get(0).getPreco();
        printableServiceOrder.setTotalValue(totalValue);
        ArrayList<PrintableServiceOrder> printableServices = new ArrayList<>();
        printableServices.add(printableServiceOrder);
        for (int i = 1; i < services.size(); i++) {
            printableServiceOrder = new PrintableServiceOrder();
            printableServiceOrder.setServiceName(services.get(i).getDescricao());
            printableServiceOrder.setServiceValue(services.get(i).getPreco().toString());
            printableServices.add(printableServiceOrder);
            totalValue += services.get(i).getPreco();
            printableServiceOrder.setTotalValue(totalValue);
        }
        
        PetshopGeneratorReport petshopGeneratorReport = new PetshopGeneratorReport();
        return petshopGeneratorReport.generateReport(PrintableServiceOrder.REPORT_NAME, printableServices);
    }
    
}
