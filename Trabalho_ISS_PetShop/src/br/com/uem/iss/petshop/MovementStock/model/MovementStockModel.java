/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class MovementStockModel extends AbstractModel {

    private MovementStock movimentStock;
    private MovementStockDAO moviStockDAO;

    private ArrayList<ObserverModel> updateObservers;
    private ArrayList<ObserverModel> errorMessageObservers;

    /**
     *
     */
    public MovementStockModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        movimentStock = new MovementStock();
        moviStockDAO = new MovementStockDAO();
        //initialize();

    }

    public MovementStock getMovimentStock() {
        return movimentStock;
    }

    public void setMovimentStock(MovementStock movimentStock) {
        this.movimentStock = movimentStock;
    }

    @Override
    public void initialize() {
        if (movimentStock == null) {
            movimentStock = new MovementStock();
        }

        if (movimentStock.getQuantidade() == null) {
            movimentStock.setQuantidade(new Double(0));
        }

        if (movimentStock.getTipo_movimento() == null) {
            movimentStock.setTipo_movimento("");
        }

        if (movimentStock.getData_execution() == null) {
            movimentStock.setData_execution(new Date(System.currentTimeMillis()));
        }

        updateObservers(null);

    }

    @Override
    public Boolean persist() {
        try {
            if (movimentStock.getQuantidade() == 0 || movimentStock.getTipo_movimento() == "" || movimentStock.getData_execution().equals(new Date())) {
                throw new Exception("Algum campo obrigatório está vazio!");
            }
            moviStockDAO.persist(movimentStock);
            updateObservers("Dados gravados com sucesso. " + "Movimentação com código " + movimentStock.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        movimentStock = (MovementStock) entity;
    }
    
    public void setQuantidade(Double quantidade) {
        movimentStock.setQuantidade(quantidade);
    }
    
    public Double getQuantidade() {
        return  movimentStock.getQuantidade();
    }
    
    public void setTipo_Movimento(String tipo) {
        movimentStock.setTipo_movimento(tipo);
    }
    
    public String getTipo_Movimento() {
        return movimentStock.getTipo_movimento();
    }
    
    public Date getData_execution() {
        return movimentStock.getData_execution();
    }
    
    public void setData_execution( Date d ) {
        movimentStock.setData_execution( d );
    }
    

}
