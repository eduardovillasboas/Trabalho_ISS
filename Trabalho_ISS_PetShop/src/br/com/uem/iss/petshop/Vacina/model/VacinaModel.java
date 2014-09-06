/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Andrade
 */
public class VacinaModel extends AbstractModel {

    private Vacina vacina;
    final private VacinaDAO vacinaDAO;

    final private ArrayList<ObserverModel> updateObservers;
    final private ArrayList<ObserverModel> errorMessageObservers;

    /**
     *
     */
    public VacinaModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        vacina = new Vacina();
        vacinaDAO = new VacinaDAO();
        //initialize();

    }

    @Override
    public void initialize() {
        if (vacina == null) {
            vacina = new Vacina();
        }

        if (vacina.getDescricao() == null) {
            vacina.setDescricao("");
        }
        if (vacina.getEstoque() == null) {
            vacina.setEstoque(new Double(0));
        }
        if (vacina.getMarca() == null) {
            vacina.setMarca("");
        }
        if (vacina.getPreco() == null){
            vacina.setPreco(new Float(0));
        }
        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            vacinaDAO.persist(vacina);
            updateObservers("Dados gravados com sucesso");
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados" + e.getMessage());
        }
        return false;
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        vacina = (Vacina) entity;
    }

    public String getDescricao() {
        return vacina.getDescricao();
    }

    public void setDescricao(String descricao) {
        vacina.setDescricao(descricao);
    }

    public Float getPreco() {
        return vacina.getPreco();
    }

    public void setPreco(Float preco) {
        vacina.setPreco(preco);
    }

    public Double getEstoque() {
        return vacina.getEstoque();
    }

    public void setEstoque(Double estoque) {
        vacina.setEstoque(estoque);
    }

    public String getMarca() {
        return vacina.getMarca();
    }

    public void setMarca(String marca) {
        vacina.setMarca(marca);
    }

    public Vacina getVacina() {
        return vacina;
    }
      
}
