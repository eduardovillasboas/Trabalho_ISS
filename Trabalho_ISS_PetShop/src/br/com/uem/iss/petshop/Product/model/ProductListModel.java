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
import javax.swing.table.AbstractTableModel;

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
    
    
    public int length() {
        return products.size();
    }

    public Object rawGetValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        if (columnIndex == 0)
            return product.getID();
        
        return product.getDescricao();
    }

    public String columnName(int col) {
        if (col == 0)
            return "Código";
        return "Descrição";
    }

    public Product getCustomerAt(int value) {
        return products.get(value);
    }

    public void delele(int selectedRow) {
        Product p = products.get(selectedRow);
        products.remove(selectedRow);
        ProductDAO productDAO = new ProductDAO();
        productDAO.delete(p);
        updateObservers( "Produto " + p.getDescricao().trim()+" deletado com sucesso!" );
    }

    @Override
    public AbstractTableModel createModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col) {
                return columnName(col);
            }

            @Override
            public int getRowCount() {
                return length();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rawGetValueAt(rowIndex, columnIndex);
            }
        };

    }
    
}
