/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderModel extends AbstractModel{

    ServiceOrder serviceOrder;
    final private ServiceOrderDAO serviceOrderDAO;
    public ServiceOrderModel() {
        serviceOrder = new ServiceOrder();
        serviceOrderDAO = new ServiceOrderDAO();
    }

    
    @Override
    public void initialize() {
        //TODO: inicializar serviceOrder
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        serviceOrder = (ServiceOrder)entity;
    }
    
}
