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

    private Set<Patology> patologys;
    public PatologyListModel() {
        patologys = new HashSet<>();
    }
    
    @Override
    public void initialize() {
        PatologyDAO patologyDAO = new PatologyDAO();
        try {
            for (Patology patology : patologyDAO.getAllPatologis()) {
                patologys.add(patology);
            }
        } catch (Exception e) {
            patologys = new HashSet<>();
        } finally {
        }
        
    }
    
    public void initialize(Set<Patology> p){
        patologys = p;
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        Patology array[] = toArray(patologys);
        Patology p = array[value];
        return p;
    }

    public String columnName(int col){
        if (col == 0)
            return "Codigo";
        return "Nome";
    }
    
    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
                return columnName(col);
            }
            
            @Override
            public int getRowCount() {
                return patologys.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Patology array[] = toArray(patologys);
                Patology p = array[rowIndex];
                if (columnIndex == 0)
                    return p.getID();
                return p.getName();
            }

        };
    
    }

    private Patology[] toArray(Set<Patology> patologys) {
        Object o[] = patologys.toArray();
        Patology p[] = new Patology[o.length];
        for (int i = 0;i<o.length;++i) {
            p[i] = (Patology)o[i];
        }
        return p;
    }

    public void delele(int selectedRow) {
        try {
            Patology array[] = toArray(patologys);
            Patology p = array[selectedRow];
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
