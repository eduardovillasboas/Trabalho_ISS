/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Product.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModelList;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ProductListModel extends AbstractModelList {

    private List<Product> products;

    public ProductListModel() {
        super();
        products = new ArrayList<>();
    }

    @Override
    public void initialize() {
        ProductDAO productDAO = new ProductDAO();
        products = productDAO.getAllProducts();
        try {
            
        } catch (Exception e) {
            products = new ArrayList<>();
        } finally {
            productDAO.close();
        }

    }

    @Override
    public PetshopEntity getPetshopEntityAt(int value) {
        return products.get(value);
    }
    
}
