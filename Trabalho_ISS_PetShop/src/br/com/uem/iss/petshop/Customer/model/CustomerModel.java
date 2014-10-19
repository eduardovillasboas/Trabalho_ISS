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
import br.com.uem.iss.petshop.Utils.DateUtil;
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
        customer = Customer.CustomerInitializer.initilizer(customer);
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
        if (!Customer.Checker.mandatoryFieldsFilled(customer)){
            updateErrorMessage("Todos os campos do cadastro são obrigatórios!");
        } else {
            try {
                customerDAO.persist(customer);
                updateObservers("Dados gravados com sucesso");
                return true;
            } catch (Exception e) {
                updateErrorMessage("Erro ao gravar os dados no banco de dados "+e.getMessage());
            } finally {
                customerDAO.close();
            }
        }
        return false;
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
    }

    public void remove(Animal a) {
        customer.remove(a);
    }

    AnimalListModel animalListModel = new AnimalListModel();
    public AbstractTableModel getCreateModel() {
        animalListModel.initialize(customer.getAnimals());
        return animalListModel.createModel();
    }

    public Animal getAnimal(int selectedRow) {
        return (Animal)animalListModel.getPetshopEntityAt(selectedRow);
    }

    public String getPhone() {
        return customer.getPhone();
    }

    public void setPhone(String text) {
        customer.setPhone(text);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
