/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Sales.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class SalesModel extends AbstractModel {

    private final SalesDAO salesDAO;
    private Sale sale;

    final private ArrayList<ObserverModel> updateObservers;
    final private ArrayList<ObserverModel> errorMessageObservers;

    public SalesModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        sale = new Sale();
        salesDAO = new SalesDAO();
        //initialize();

    }

    @Override
    public void initialize() {
        if (sale == null) {
            sale = new Sale();
        }
//        if (sale.getCodigo_animal() == null) {
//            sale.setCodigo_animal(0);
//        } 
        //sale.setCodigo_item(0);
        if (sale.getForma_pagamento() == null) {
            sale.setForma_pagamento("");
        }
//        if (sale.getQuantidade_vendida() == null) {
//            sale.setQuantidade_vendida(new Double(0));
//        }

        if (sale.getValor() == null) {
            sale.setValor(new Float(0));
        }

        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            if (sale.getForma_pagamento().isEmpty()) {
//                if ( sale.getForma_pagamento().isEmpty() || sale.getQuantidade_vendida() <= 0 || sale.getQuantidade_vendida() <= 0) {
                throw new Exception("Algum campo obrigatório está vazio!");
            }
            salesDAO.persist(sale);
            updateObservers("Dados gravados com sucesso. " + "Venda com código " + sale.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        sale = (Sale) entity;
    }

    public Float getValor() {
        return sale.getValor();
    }

    public void setValor(Float valor) {
        sale.setValor(valor);
    }

    public String getForma_pagamento() {
        return sale.getForma_pagamento();
    }

    public void setForma_pagamento(String forma_pagamento) {
        sale.setForma_pagamento(forma_pagamento);
    }

    public Animal getAnimal() {
        return sale.getAnimal();
    }

    public void setAnimal(Animal animal) {
        sale.setAnimal(animal);
    }

    public Customer getCustomer() {
        return sale.getCustomer();
    }

    public void setCustomer(Customer customer) {
        sale.setCustomer(customer);
    }

    public Long getID() {
        return sale.getID();
    }

}
