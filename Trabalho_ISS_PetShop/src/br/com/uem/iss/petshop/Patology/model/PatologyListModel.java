/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class PatologyListModel extends AbstractModelList{

    private List<Patology> patologys = new ArrayList<>();
    public PatologyListModel() {
    }
    
    @Override
    public void initialize() {
        PatologyDAO patologyDAO = new PatologyDAO();
        try {
            patologys = patologyDAO.getAllPatologis();
        } catch (Exception e) {
            patologys = new ArrayList<>();
        } finally {
        }
        
    }
    
    public void initialize(List<Patology> p){
        patologys = p;
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return patologys.get(value);
    }

    public String columnName(int col){
        if (col == 0)
            return "Codigo";
        return "Nome";
    }
    
    @Override
    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
                return columnName(col);
            }
            
            @Override
            public int getRowCount() {
                if (patologys == null)
                    return 0;
                return patologys.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Patology p = patologys.get(rowIndex);
                if (columnIndex == 0)
                    return p.getID();
                return p.getName();
            }

        };
    
    }


    public void delele(int selectedRow) {
        try {
            Patology p = patologys.get(selectedRow);
            patologys.remove(selectedRow);
            PatologyDAO patologyDAO = new PatologyDAO();
            patologyDAO.delete(p);
            updateObservers("Cliente "+p.getName().trim()+" deletado com sucesso!");
        } catch (Exception e) {
            updateErrorMessage(e.getMessage());
        }

        
    }

    @Override
    public String getTitle() {
        return "Cadastro de Patologias";
    }
    
}
