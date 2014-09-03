/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Drugs.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class DrugModel extends AbstractModel {

    private Drug drug;
    private final DrugDAO drugDAO;

    private final ArrayList<ObserverModel> updateObservers;
    private final ArrayList<ObserverModel> errorMessageObservers;

    /**
     *
     */
    public DrugModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        drug = new Drug();
        drugDAO = new DrugDAO();
    }

    @Override
    public void initialize() {
        if (drug == null) {
            drug = new Drug();
        }
        if (drug.getNome() == null) {
            drug.setNome("");
        } 
        if (drug.getDescricao() == null) {
            drug.setDescricao("");
        }                
        if (drug.getFornecedor() == null) {
            drug.setFornecedor("");
        } 
        if (drug.getFornecedor() == null) {
            drug.setFornecedor("");
        } 
        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            if (drug.getNome().isEmpty() ||  drug.getDescricao().isEmpty() || drug.getFornecedor().isEmpty() || drug.getQuantidade().isEmpty() ){
                throw new Exception( "Algum campo obrigatório não está preenchido!" );
            }
            drugDAO.persist(drug);
            updateObservers("Dados gravados com sucesso.o Código do Medicamento é: " + drug.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        drug = (Drug) entity;
    }
    public String getNome() {
        return drug.getNome();
    }

    public void setNome(String nome) {
        drug.setNome(nome);
    }
    public String getDescricao() {
        return drug.getDescricao();
    }

    public void setDescricao(String descricao) {
        drug.setDescricao(descricao);
    }
    
    public String getFornecedor() {
        return drug.getFornecedor();
    }

    public void setFornecedor(String fornecedor) {
        drug.setFornecedor(fornecedor);
    }
    
    public String getQuantidade() {
        return drug.getQuantidade();
    }

    public void setQuantidade(String quantidade) {
        drug.setQuantidade(quantidade);
    }
   
    public Drug getDrug() {
        return drug;
    }
}