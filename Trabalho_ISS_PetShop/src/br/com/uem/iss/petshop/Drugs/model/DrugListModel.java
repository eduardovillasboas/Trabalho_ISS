/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Drugs.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael
 */
public class DrugListModel extends AbstractModelList {

    private List<Drug> drugs;

    public DrugListModel() {
        super();
        drugs = new ArrayList<>();
    }

    @Override
    public void initialize() {
        DrugDAO drugDAO = new DrugDAO();
        drugs = drugDAO.getAllDrugs();
        try {

        } catch (Exception e) {
            drugs = new ArrayList<>();
        } finally {
            drugDAO.close();
        }

    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return drugs.get(value);
    }

    public int length() {
        return drugs.size();
    }

    public Object _getValueAt(int rowIndex, int columnIndex) {
        Drug drug = drugs.get(rowIndex);
        if (columnIndex == 0) {
            return drug.getID();
        }
        else if (columnIndex == 1) {
            return drug.getNome();
        } else if (columnIndex == 2) {
            return drug.getDescricao();
        } else if (columnIndex == 3) {
            return drug.getFornecedor();
        }
        else if (columnIndex == 4) {
            return drug.getQuantidade();
        }
        return null;
    }

    public String columnName(int col) {
        if (col == 0) {
            return "Código";
        } else if (col == 1) {
            return "Nome";
        } else if (col == 2) {
            return "Descrição";
        } else if (col == 3) {
            return "Fornecedor";
        } else if (col == 4) {
            return "Quantidade";
        }
        return null;
    }

    public Drug getCustomerAt(int value) {
        return drugs.get(value);
    }

    public void delele(int selectedRow) {
        Drug p = drugs.get(selectedRow);
        drugs.remove(selectedRow);
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.delete(p);
        updateObservers("Medicamento " + p.getDescricao().trim() + p.getFornecedor().trim() + p.getQuantidade().trim() + " deletado com sucesso!");
    }

    @Override
    public AbstractTableModel createModel() {
       AbstractTableModel tableModel = new AbstractTableModel() {

            @Override
            public String getColumnName(int col) {
                return columnName(col);
            }

            @Override
            public int getRowCount() {
                return length();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return _getValueAt(rowIndex, columnIndex);
            }
        };
       return tableModel;
    }

    @Override
    public String getTitle() {
        return "Cadastro de Medicamentos";
    }

}
