/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalInitializer;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerInitializer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderModel extends AbstractModel{

    ServiceOrder serviceOrder;
    final private ServiceOrderDAO serviceOrderDAO;
    private Customer customer;
    private Animal animal;
    private final ArrayList<ObserverServiceOrderChangeAnimal> observerChangeAnimal; 
    final private ArrayList<ObserverServiceOrderChangeCustomer> observerChangeCustomer;
    private List<Service> services;
    
    public void addService(Service s) {
        services.add(s);
        //TODO: UPDATE Observers.
    }
    
    public interface ObserverServiceOrderChangeAnimal{
        void animalChanged();
    } 
    
    public interface ObserverServiceOrderChangeCustomer{
        void customerChanged();
    }
    
    public ServiceOrderModel() {
        serviceOrder = new ServiceOrder();
        serviceOrderDAO = new ServiceOrderDAO();
        observerChangeAnimal = new ArrayList<>();
        observerChangeCustomer = new ArrayList<>();
    }

    public void register(ObserverServiceOrderChangeAnimal o){
        observerChangeAnimal.add(o);
    }
    
    public void animalWasChanged(){
        for (ObserverServiceOrderChangeAnimal observerServiceOrderChangeAnimal : observerChangeAnimal) {
            observerServiceOrderChangeAnimal.animalChanged();
        }
    }
    
    public void register(ObserverServiceOrderChangeCustomer o){
        observerChangeCustomer.add(o);
    }
    
    public void customerWasChanged(){
        for (ObserverServiceOrderChangeCustomer observerServiceOrderChangeCustomer : observerChangeCustomer) {
            observerServiceOrderChangeCustomer.customerChanged();
        }
    }
    
    @Override
    public void initialize() {
        initializerEntities();
        //TODO: inicializar serviceOrder
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        serviceOrder = (ServiceOrder)entity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customerWasChanged();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        animalWasChanged();
    }

    private void initializerEntities() {
        CustomerInitializer customerInitializer;
        customerInitializer = new CustomerInitializer();
        customer = customerInitializer.initilizer(customer);
        AnimalInitializer animalInitializer;
        animalInitializer = new AnimalInitializer();
        animal = animalInitializer.initializer(animal);
        services = new ArrayList<>();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerLastName() {
        return customer.getLastName();
    }

    public String getCustomerPhone() {
        return customer.getPhone();
    }

    public String getCustomerBirth() {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.toString(customer.getBirth());
    }

    public String getAnimalName() {
        return animal.getName();
    }

    public String getAnimalBirth() {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.toString(animal.getBirth());
    }

}
