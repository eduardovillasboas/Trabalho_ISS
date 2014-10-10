/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Service.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ServiceModel extends AbstractModel {

    private Service service;
    private final ServiceDAO serviceDAO;

    /**
     *
     */
    public ServiceModel() {
        service = new Service();
        serviceDAO = new ServiceDAO();
    }

    @Override
    public void initialize() {
        if (service == null) {
            service = new Service();
        }

        if (service.getDescricao() == null) {
            service.setDescricao("");
        }                
        if (service.getPreco() == null) {
            service.setPreco(new Float(0));
        }
        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            if ( service.getDescricao().isEmpty() || service.getPreco() <= 0 ) {
                throw new Exception( "Algum campo obrigatório não está preenchido!" );
            }
            serviceDAO.persist(service);
            updateObservers("Dados gravados com sucesso.o Código do serviço é: " + service.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        service = (Service) entity;
    }

    public String getDescricao() {
        return service.getDescricao();
    }

    public void setDescricao(String descricao) {
        service.setDescricao(descricao);
    }

    public Float getPreco() {
        return service.getPreco();
    }

    public void setPreco(Float preco) {
        service.setPreco(preco);
    }

    public Service getService() {
        return service;
    }
}
