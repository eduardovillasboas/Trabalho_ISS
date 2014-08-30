/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Product.model;

import br.com.uem.iss.petshop.Interfaces.ModelInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ProductModel implements ModelInterface {

    private Product product;
    final private ProductDAO productDAO;

    final private ArrayList<ObserverModel> updateObservers;
    final private ArrayList<ObserverModel> errorMessageObservers;

    /**
     *
     */
    public ProductModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        product = new Product();
        productDAO = new ProductDAO();

    }

    @Override
    public void initialize() {
        if (product == null) {
            product = new Product();
        }

        if (product.getDescricao() == null) {
            product.setDescricao("");
        }
        if (product.getUndade() == null) {
            product.setUndade("");
        }
        updateObservers(null);
    }

    @Override
    public void persist() {
        try {
            productDAO.persist(product);
            updateObservers("Dados gravados com sucesso");
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados" + e.getMessage());
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        product = (Product) entity;
    }

    @Override
    public void updateErrorMessage(String msg) {
        errorMessageObservers.stream().forEach((observer) -> {
            observer.errorOcurred(msg);
        });
    }

    @Override
    public void updateObservers(String msg) {
        updateObservers.stream().forEach((updateObserver) -> {
            updateObserver.updateViews(msg);
        });
    }

    @Override
    public void registerUpdate(ObserverModel o) {
        updateObservers.add(o);
    }

    @Override
    public void registerErrorObserver(ObserverModel o) {
        errorMessageObservers.add(o);
    }

    public String getUndade() {
        return product.getUndade();
    }

    public void setUndade(String undade) {
        product.setUndade(undade);
    }

    public String getDescricao() {
        return product.getDescricao();
    }

    public void setDescricao(String descricao) {
        product.setDescricao(descricao);
    }

    public float getPesoBruto() {
        return product.getPesoBruto();
    }

    public void setPesoBruto(float pesoBruto) {
        product.setPesoBruto(pesoBruto);
    }

    public float getPreco() {
        return product.getPreco();
    }

    public void setPreco(float preco) {
        product.setPreco(preco);
    }

    public float getPesoLiquido() {
        return product.getPesoLiquido();
    }

    public void setPesoLiquido(float pesoLiquido) {
        product.setPesoLiquido(pesoLiquido);
    }

}
