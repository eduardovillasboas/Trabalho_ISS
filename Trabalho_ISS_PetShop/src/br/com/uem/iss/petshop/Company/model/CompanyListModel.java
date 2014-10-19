/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael
 */
public class CompanyListModel extends AbstractModelList{

    private List<Company> companys;

    public CompanyListModel() {
        super();
        companys = new ArrayList<>();
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return companys.get(value);
    }

    @Override
    public void initialize() {
        CompanyDAO companyDAO = new CompanyDAO();
        companys = companyDAO.getAllCompanys();
        try {
            
        } catch (Exception e) {
            companys = new ArrayList<>();
        } finally {
            companyDAO.close();
        }
        
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
                return companys.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Company company = companys.get(rowIndex);
                if (columnIndex == 0)
                    return company.getID();
                
                return company.getNome();
            }
        };
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
        
        return "Nome";
    }

    public int length() {
        return companys.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Company a = companys.get(rowIndex);
        if (columnIndex == 0)
            return a.getID();
        return a.getNome();
    }

    @Override
    public void delele(int selectedRow) {
        try {
            Company a = companys.get(selectedRow);
            companys.remove(selectedRow);
            CompanyDAO companyDAO = new CompanyDAO();
            companyDAO.delete(a);
            updateObservers("A Empresa "+a.getNome().trim()+" deletado com sucesso!");
        } catch (Exception e) {
            updateObservers(e.getMessage());
        }
    }

    @Override
    public String getTitle() {
        return "Cadastro de Empresa";
    }
    
    public List<Company> getCompanys() {
        return companys; 
    }
}