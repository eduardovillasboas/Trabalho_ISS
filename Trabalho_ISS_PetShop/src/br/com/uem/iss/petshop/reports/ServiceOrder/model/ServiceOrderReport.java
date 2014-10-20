/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.ServiceOrder.model;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderReport {

    private String emissionDate;
    private String serviceOrderID;
    private String serviceOrderStatus;
    private String customerName;
    private String animalName;
    private String paymentType;
    private String serviceOrderTotal;
    
    public ServiceOrderReport() {
    }

    public String getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(String emissionDate) {
        this.emissionDate = emissionDate;
    }

    public String getServiceOrderID() {
        return serviceOrderID;
    }

    public void setServiceOrderID(String serviceOrderID) {
        this.serviceOrderID = serviceOrderID;
    }

    public String getServiceOrderStatus() {
        return serviceOrderStatus;
    }

    public void setServiceOrderStatus(String serviceOrderStatus) {
        this.serviceOrderStatus = serviceOrderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getServiceOrderTotal() {
        return serviceOrderTotal;
    }

    public void setServiceOrderTotal(String serviceOrderTotal) {
        this.serviceOrderTotal = serviceOrderTotal;
    }
    
    
}
