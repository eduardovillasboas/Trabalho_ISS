/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Service.model.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author EDUARDO
 */
@Entity
@Table(name = "SERVICEORDER")
public class ServiceOrder implements Serializable, PetshopEntity {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "SELECT s FROM ServiceOrder s";

    @ManyToOne
    @JoinColumn(name = "customer_id")        
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    
    @OneToMany
    private List<Service> services;

    public ServiceOrder() {
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceOrder)) {
            return false;
        }
        ServiceOrder other = (ServiceOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.ServiceOrder.model.ServiceOrder[ id=" + id + " ]";
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        ServiceOrder serviceOrder = (ServiceOrder)entity;
        setCustomer(serviceOrder.getCustomer());
        setServices(serviceOrder.getServices());
        setAnimal(serviceOrder.getAnimal());
    }

    void add(Service s) {
        services.add(s);
    }

    public List<Service> getServices() {
        return services;
    }

    public Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Animal getAnimal() {
        return animal;
    }

    void setAnimal(Animal animal) {
        this.animal = animal;
    }

    private void setServices(List<Service> services) {
        this.services = services;
    }
    
    public static class ServiceOrderInitializer {

        private ServiceOrderInitializer() {
        }
        
        public static ServiceOrder initializer(ServiceOrder serviceOrder) {
            if (serviceOrder == null)
                serviceOrder = new ServiceOrder();
            
            
            Customer customer = serviceOrder.getCustomer();
            if (customer == null){
                customer = Customer.CustomerInitializer.initilizer(customer);
                serviceOrder.setCustomer(customer);
            }
            
            Animal animal = serviceOrder.getAnimal();
            if (animal == null){
                animal = Animal.AnimalInitializer.initializer(animal);
                serviceOrder.setAnimal(animal);
            }
            
            List<Service> services = serviceOrder.getServices();
            if (services == null){
                services = new ArrayList<>();
                serviceOrder.setServices(services);
            }
            
            return serviceOrder;
        }
    }
}
