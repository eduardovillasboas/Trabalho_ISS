/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class AnimalListModel extends AbstractModelList{

    private List<Animal> animals;

    public AnimalListModel() {
        super();
        animals = new ArrayList<>();
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return animals.get(value);
    }

    @Override
    public void initialize() {
        AnimalDAO animalDAO = new AnimalDAO();
        animals = animalDAO.getAllAnimals();
        try {
            
        } catch (Exception e) {
            animals = new ArrayList<>();
        } finally {
            animalDAO.close();
        }
        
    }

    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return animals.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Animal animal = animals.get(rowIndex);
                if (columnIndex == 0)
                    return animal.getId();
                
                return animal.getName();
            }
        };
    }

    public void delete(int selectedRow) {
        try {
            Animal a = animals.get(selectedRow);
            animals.remove(selectedRow);
            AnimalDAO animalDAO = new AnimalDAO();
            animalDAO.delete(a);
            updateObservers("O Animal "+a.getName().trim()+" deletado com sucesso!");
        } catch (Exception e) {
            updateObservers(e.getMessage());
        }
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
        
        return "Nome";
    }

    public int length() {
        return animals.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal a = animals.get(rowIndex);
        if (columnIndex == 0)
            return a.getID();
        return a.getName();
    }
    
}
