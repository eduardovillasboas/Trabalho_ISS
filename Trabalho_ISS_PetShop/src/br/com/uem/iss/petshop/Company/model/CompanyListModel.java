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

/**
 *
 * @author Rafael
 */
public class CompanyListModel extends AbstractModelList {
    
    private List<Company> companies;

    public CompanyListModel() {
        super();
        companies = new ArrayList<>();
    }

    @Override
    public void initialize() {
        CompanyDAO companyDAO = new CompanyDAO();
        companies = companyDAO.getAllCompanies();
        try {
            
        } catch (Exception e) {
            companies = new ArrayList<>();
        } finally {
            companyDAO.close();
        }

    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return companies.get(value);
    }
    
    
    public int length() {
        return companies.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Company company = companies.get(rowIndex);
        if (columnIndex == 0)
            return company.getID();
        
        return company.getNome();
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
//        else if (col == 1 ){
//            return "Nome";            
//        }
        return "Nome";
    }

    public Company getCustomerAt(int value) {
        return companies.get(value);
    }

    public void delele(int selectedRow) {
        Company p = companies.get(selectedRow);
        companies.remove(selectedRow);
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.delete(p);
        updateObservers( "Empresa " + p.getNome().trim()+" deletado com sucesso!" );
    }
    
}