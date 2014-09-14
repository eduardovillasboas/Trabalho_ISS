/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Service.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class ServiceListModel extends AbstractModelList {
    
    private List<Service> services;

    public ServiceListModel() {
        super();
        services = new ArrayList<>();
    }

    @Override
    public void initialize() {
        ServiceDAO serviceDAO = new ServiceDAO();
        services = serviceDAO.getAllProducts();
        try {
            
        } catch (Exception e) {
            services = new ArrayList<>();
        } finally {
            serviceDAO.close();
        }

    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return services.get(value);
    }
    
    
    public int length() {
        return services.size();
    }

    public Object getRawValueAt(int rowIndex, int columnIndex) {
        Service service = services.get(rowIndex);
        if (columnIndex == 0)
            return service.getID();
        
        return service.getDescricao();
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
//        else if (col == 1 ){
//            return "Descrição";            
//        }
        return "Descrição";
    }

    public Service getCustomerAt(int value) {
        return services.get(value);
    }

    @Override
    public void delele(int selectedRow) {
        Service p = services.get(selectedRow);
        services.remove(selectedRow);
        ServiceDAO serviceDAO = new ServiceDAO();
        serviceDAO.delete(p);
        updateObservers( "Servico " + p.getDescricao().trim()+" deletado com sucesso!" );
    }

    @Override
    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

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
                return getRawValueAt(rowIndex, columnIndex);
            }
        };
    }

    @Override
    public String getTitle() {
        return "Cadastro de Serviços";
    }
    
}
