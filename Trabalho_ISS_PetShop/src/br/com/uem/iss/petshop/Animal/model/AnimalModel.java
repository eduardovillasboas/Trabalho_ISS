/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Patology.model.Patology;
import br.com.uem.iss.petshop.Patology.model.PatologyListModel;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class AnimalModel extends AbstractModel{

    final private AnimalDAO animalDAO;
    private Animal animal;

    public void setCustomer(List<Customer> customer) {
        animal.setCustomer(customer);
    }

    public String getName() {
        return animal.getName();
    }

    public void setName(String name) {
        animal.setName(name);
    }

    public String getBreed() {
        return animal.getBreed();
    }

    public void setBreed(String breed) {
        animal.setBreed(breed);
    }

    public Date getBirth() {
        return animal.getBirth();
    }

    public void setBirth(Date birth) {
        animal.setBirth(birth);
    }

    public Double getHeight() {
        return animal.getHeight();
    }

    public void setHeight(Double height) {
        animal.setHeight(height);
    }

    public Double getWeight() {
        return animal.getWeight();
    }

    public void setWeight(Double weight) {
        animal.setWeight(weight);
    }
    
    public AnimalModel() {
        super();
        animal = new Animal();
        animalDAO = new AnimalDAO();
    }

    
    @Override
    public void initialize() {
        animal = Animal.AnimalInitializer.initializer(animal);
    }

    @Override
    public Boolean persist() {
        DateUtil d = new DateUtil();
        if (animal.getName().isEmpty() || 
                animal.getBreed().isEmpty() ||
                animal.getBirth().equals(d.toDate("")) ||
                animal.getHeight() == 0 ||
                animal.getWeight() == 0 ){
            updateErrorMessage("Todos os campos do cadastro são obrigatórios!");
        }else {
            try {
                animalDAO.persist(animal);
                updateObservers("Dados gravados com sucesso");
                return true;
            } catch (Exception e) {
                updateErrorMessage("Erro ao gravar os dados no banco de dados"+e.getMessage());
            } finally {
                animalDAO.close();
            }
        }
        return false;
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        animal = (Animal)entity;
    }

    private final PatologyListModel patologyListModel = new PatologyListModel();
    public AbstractTableModel createModel() {
        patologyListModel.initialize(animal.getPathologys());
        return patologyListModel.createModel();
    }

    public void add(Patology patology) {
        if (animal.getPathologys() != null && animal.getPathologys().contains(patology)){
            updateErrorMessage("A patologia "+patology.getName()+" já foi adicionada para este animal");
            return;
        }
        animal.add(patology);
    }

    public Patology getPathology(int selectedRow) {
        return animal.getPathologys().get(selectedRow);
    }

    public void removePathology(Patology patology) {
        animal.getPathologys().remove(patology);
    }
    
}
