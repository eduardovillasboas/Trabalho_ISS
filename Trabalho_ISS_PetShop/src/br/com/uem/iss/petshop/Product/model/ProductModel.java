/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Product.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ProductModel extends AbstractModel {

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
        //initialize();

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
        if (product.getEstoque() == null) {
            product.setEstoque(new Double(0));
        }
        if (product.getMarca() == null) {
            product.setMarca("");
        }
        if (product.getPesoBruto() == null) {
            product.setPesoBruto(new Float(0));
        }
        if (product.getPesoLiquido() == null) {
            product.setPesoLiquido(new Float(0));
        }
        if (product.getPreco() == null) {
            product.setPreco(new Float(0));
        }
        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            if (product.getDescricao().isEmpty() || product.getMarca().isEmpty() || product.getPreco() <= 0 || product.getUndade().isEmpty()) {
                throw new Exception("Algum campo obrigatório está vazio!");                                
            }
            productDAO.persist(product);            
            updateObservers("Dados gravados com sucesso. " + "Poduto com código " + product.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        product = (Product) entity;
    }
    
    public Long getID() {
        return product.getID();        
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

    public Float getPesoBruto() {
        return product.getPesoBruto();
    }

    public void setPesoBruto(Float pesoBruto) {
        product.setPesoBruto(pesoBruto);
    }

    public Float getPreco() {
        return product.getPreco();
    }

    public void setPreco(Float preco) {
        product.setPreco(preco);
    }

    public Float getPesoLiquido() {
        return product.getPesoLiquido();
    }

    public void setPesoLiquido(Float pesoLiquido) {
        product.setPesoLiquido(pesoLiquido);
    }

    public Double getEstoque() {
        return product.getEstoque();
    }

    public void setEstoque(Double estoque) {
        product.setEstoque(estoque);
    }

    public String getMarca() {
        return product.getMarca();
    }

    public void setMarca(String marca) {
        product.setMarca(marca);
    }

    public Product getProduct() {
        return product;
    }

}
