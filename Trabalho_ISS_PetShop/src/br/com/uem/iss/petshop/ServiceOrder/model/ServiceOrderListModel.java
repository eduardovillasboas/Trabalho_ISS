/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderListModel extends AbstractModelList{

    private List<ServiceOrder> serviceOrders;

    public ServiceOrderListModel() {
        serviceOrders = new ArrayList<>();
    }
    
    private String columnName(int col) {
        if (col == 0)
            return "Nome do cliente";
        else
            return "Data de Execução";
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
                return serviceOrders.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ServiceOrder serviceOrder = serviceOrders.get(rowIndex);
                if (columnIndex == 0)
                    return serviceOrder.getCustomer().getName();
                else
                    return serviceOrder.getID()+" Alterar para data de execucao";
            }
        };
    }

    @Override
    public void delele(int selectedRow) {
        try {
            ServiceOrder serviceOrder = serviceOrders.get(selectedRow);
            serviceOrders.remove(selectedRow);
            ServiceOrderDAO customerDAO = new ServiceOrderDAO();
            customerDAO.delete(serviceOrder);
            updateObservers("Ordem de serviço número "+serviceOrder.getID()+" deletada com sucesso!");
        } catch (Exception e) {
            updateErrorMessage(e.getMessage());
        }

    }

    @Override
    public String getTitle() {
        return "Lista de ordens de serviço";
    }

    @Override
    public void initialize() {
        ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
        try {
            serviceOrders = serviceOrderDAO.getAllServiceOrders();
        } catch (Exception e) {
            serviceOrders = new ArrayList<>();
        } finally {
            serviceOrderDAO.close();
        }
    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return serviceOrders.get(value);
    }
    
}
