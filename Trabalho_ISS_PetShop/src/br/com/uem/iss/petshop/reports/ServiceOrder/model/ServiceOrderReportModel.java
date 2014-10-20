/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.ServiceOrder.model;

import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrder;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderReportModel {

    final public static String REPORT_NAME = "relatorio_ordem_servico";
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ServiceOrderReport> generate(List<ServiceOrder> serviceOrders) {
        ArrayList<ServiceOrderReport> serviceOrdersReport = new ArrayList<>();
        
        DateUtil dateUtil = new DateUtil();
        
        for (int i = 0; i < serviceOrders.size(); i++) {
            ServiceOrderReport servOrdRepo;
            ServiceOrder so = serviceOrders.get(i);
            servOrdRepo = new ServiceOrderReport();
            servOrdRepo.setAnimalName(so.getAnimal().getName());
            servOrdRepo.setCustomerName(so.getCustomer().getName());
            servOrdRepo.setEmissionDate(dateUtil.toString(so.getEmissionDate()));
            servOrdRepo.setPaymentType(so.getPaymentType().toString());
            servOrdRepo.setServiceOrderID(so.getID().toString());
            servOrdRepo.setServiceOrderStatus(so.getStatus().toString());
            servOrdRepo.setServiceOrderTotal(calculeTotal(so));
            serviceOrdersReport.add(servOrdRepo);
        }
        
        return serviceOrdersReport;
    }

    private String calculeTotal(ServiceOrder so) {
        Double total = new Double(0d);
        for (Service service : so.getServices()) {
            total += service.getPreco();
        }
        return total.toString();
    }
    
}
