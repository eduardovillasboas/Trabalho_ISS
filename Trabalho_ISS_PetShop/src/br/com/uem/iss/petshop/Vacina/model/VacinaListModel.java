/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo Andrade
 */
public class VacinaListModel extends AbstractModelList {

    private List<Vacina> vacina;

    public VacinaListModel() {
        super();
        vacina = new ArrayList<>();
    }

    @Override
    public void initialize() {
        VacinaDAO vacinaDAO = new VacinaDAO();
        vacina = vacinaDAO.getAllVacina();
        try {
            
        } catch (Exception e) {
            vacina = new ArrayList<>();
        } finally {
            vacinaDAO.close();
        }

    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return vacina.get(value);
    }
    
    
    public int length() {
        return vacina.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Vacina v = vacina.get(rowIndex);
        if (columnIndex == 0)
            return v.getID();
        
        return v.getDescricao();
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
        return "Descrição";
    }

    public Vacina getCustomerAt(int value) {
        return vacina.get(value);
    }

    public void delele(int selectedRow) {
        Vacina v = vacina.get(selectedRow);
        vacina.remove(selectedRow);
        VacinaDAO vacinaDAO = new VacinaDAO();
        vacinaDAO.delete(v);
        updateObservers( "Vacina " + v.getDescricao().trim()+" deletada com sucesso!" );
    }
    
}
