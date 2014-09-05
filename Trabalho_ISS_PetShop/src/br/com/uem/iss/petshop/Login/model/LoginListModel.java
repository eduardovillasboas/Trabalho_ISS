/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Login.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ricardo Andrade
 */
public class LoginListModel extends AbstractModelList{

    private List<Login> login;
    public LoginListModel() {
        super();
        login = new ArrayList<>();
    }
    
    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return login.get(value);
    }

    @Override
    public void initialize() {
        LoginDAO loginDAO = new LoginDAO();
        login = loginDAO.getAllLogin();
        try {
            
        } catch (Exception e) {
            login = new ArrayList<>();
        } finally {
            loginDAO.close();
        }
        
    }

    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
                return columnName(col);
            }

            @Override
            public int getRowCount() {
                return login.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Login l = login.get(rowIndex);
                if (columnIndex == 0)
                    return l.getID();
                return l.getName();
            }
        };
    }

    public void delete(int selectedRow) {
        try {
            Login l = login.get(selectedRow);
            login.remove(selectedRow);
            LoginDAO loginDAO = new LoginDAO();
            loginDAO.delete(l);
            updateObservers("O Login "+l.getName().trim()+" deletado com sucesso!");
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
        return login.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Login l = login.get(rowIndex);
        if (columnIndex == 0)
            return l.getID();
        return l.getName();
    }
    
    
}
