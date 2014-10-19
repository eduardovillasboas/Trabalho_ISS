/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.DeliveryReceipt.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author EDUARDO
 */
public class DeliveryReceiptModel {

    public final static String REPORT_NAME = "comprovante_de_entrega";
    private DeliveryReceipt deliveryReceipt;

    final private ArrayList<ObserverCustomerChange> customersChange;
    final private ArrayList<ObserverAnimalChange> animalsChange;
    public DeliveryReceiptModel() {
        customersChange = new ArrayList<>();
        animalsChange = new ArrayList<>();
    }

    public DeliveryReceipt getDeliveryReciReceipt() {
        return deliveryReceipt;
    }
    
    public void register(ObserverAnimalChange o) {
        animalsChange.add(o);
    }
    
    public void register(ObserverCustomerChange o) {
        customersChange.add(o);
    }

    void updateCustomerChanges(Customer customer) {
        for (ObserverCustomerChange observerCustomerChange : customersChange) {
            observerCustomerChange.update(customer);
        }
    }

    private void updateAnimalChanges(Animal animal) {
        for (ObserverAnimalChange observerAnimalChange : animalsChange) {
            observerAnimalChange.update(animal);
        }
    }

    public Animal getAnimal() {
        return deliveryReceipt.getAnimal();
    }

    public interface ObserverAnimalChange {
        public void update(Animal animal);
    }
    
    public Customer getCustomer() {
        return deliveryReceipt.getCustomer();
    }
    
    public interface ObserverCustomerChange {
        public void update(Customer customer);
    }
    
    public void initialize() {
        deliveryReceipt = new DeliveryReceipt();
        deliveryReceipt.initialize();
    }

    public void setCustomer(Customer customer) {
        deliveryReceipt.setCustomer(customer);
        updateCustomerChanges(customer);
    }

    public void setAnimal(Animal animal) {
        deliveryReceipt.setAnimal(animal);
        updateAnimalChanges(animal);
    }

   
}
