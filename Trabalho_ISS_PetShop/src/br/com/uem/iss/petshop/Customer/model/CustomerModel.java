/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalListModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class CustomerModel extends AbstractModel{

    private Customer customer;
    final private CustomerDAO customerDAO; 
    
    public CustomerModel() {
        customer = new Customer();
        customerDAO = new CustomerDAO();
    }
    
    @Override
    public void initialize() {
        if (customer == null)
            customer = new Customer();
        if (customer.getName() == null)
            customer.setName("");
        if (customer.getLastName() == null)
            customer.setLastName("");
        if (customer.getBirth() == null){
            customer.setBirth(new Date(0,0,0));
        }
        if (customer.getAddress() == null)
            customer.setAddress("");
        if (customer.getAnimals() == null)
            customer.setAnimals(new ArrayList<>());
        if (customer.getCpf() == null)
            customer.setCpf("");
        if (customer.getRg() == null)
            customer.setRg("");
        if (customer.getNumber() == null)
            customer.setNumber(new Long(0));
        
        updateObservers(null);
    }

    public String getName() {
        return customer.getName();
    }

    public String getLastName() {
        return customer.getLastName();
    }

    public Date getBirthDate() {
        return customer.getBirth();
    }

    public void setName(String text) {
        customer.setName(text);
    }

    public void setLastName(String text) {
        customer.setLastName(text);
    }
    
    public void setBirth(Date date){
        customer.setBirth(date);
    }

    @Override
    public Boolean persist() {
        try {
            customerDAO.persist(customer);
            updateObservers("Dados gravados com sucesso");
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados "+e.getMessage());
            return false;
        } finally {
            customerDAO.close();
        }
    }

    public Long getId() {
        return customer.getID();
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        customer = (Customer)entity;
    }

    public String getCPF() {
        return customer.getCpf();
    }

    public String getRg() {
        return customer.getRg();
    }

    public void setRg(String rg) {
        customer.setRg(rg);
    }

    public void setCpf(String cpf) {
        customer.setCpf(cpf);
    }

    public String getAddress() {
        return customer.getAddress();
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }

    public Long getNumber() {
        return customer.getNumber();
    }

    public void setNumber(Long number) {
        customer.setNumber(number);
    }

    public List<Animal> getAnimals() {
        return customer.getAnimals();
    }

    public void add(Animal e) {
        if (customer.getAnimals().contains(e)){
            updateErrorMessage("O animal "+e.getName()+" já foi adiconado para este cliente");
            return;
        }
            
        customer.add(e);
        updateObservers(null);
    }

    public void remove(Animal a) {
        customer.remove(a);
        updateObservers(null);
    }

    AnimalListModel animalListModel = new AnimalListModel();
    public AbstractTableModel getCreateModel() {
        animalListModel.initialize(customer.getAnimals());
        return animalListModel.createModel();
    }

    public Animal getAnimal(int selectedRow) {
        return (Animal)animalListModel.getPetshopEntityAt(selectedRow);
    }
   
}
