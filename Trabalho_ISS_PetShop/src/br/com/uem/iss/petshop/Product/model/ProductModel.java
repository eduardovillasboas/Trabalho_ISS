///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.com.uem.iss.petshop.Customer.model;
//
//import br.com.uem.iss.petshop.Interfaces.ModelInterface;
//import br.com.uem.iss.petshop.Interfaces.ObserverModel;
//import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
//import java.util.ArrayList;
//import java.util.Date;
//
///**
// *
// * @author EDUARDO
// */
//public class CustomerModel implements ModelInterface{
//
//    private Customer customer;
//    final private CustomerDAO customerDAO; 
//
//    final private ArrayList<ObserverModel> updateObservers;
//    final private ArrayList<ObserverModel> errorMessageObservers;
//
//    public CustomerModel() {
//        updateObservers = new ArrayList<>();
//        errorMessageObservers = new ArrayList<>();
//        customer = new Customer();
//        customerDAO = new CustomerDAO();
//
//    }
//    
//    @Override
//    public void registerErrorObserver(ObserverModel e) {
//        errorMessageObservers.add(e);
//    }
//    
//    @Override
//    public void registerUpdate(ObserverModel e) {
//        updateObservers.add(e);
//    }
//    
//    @Override
//    public  void updateErrorMessage(String msg){
//        for (ObserverModel observer  : errorMessageObservers) {
//            observer.errorOcurred(msg);
//        }
//    }
//    
//    @Override
//    public void updateObservers(String msg){
//        for (ObserverModel updateObserver : updateObservers) {
//            updateObserver.updateViews(msg);
//        }
//    }
//
//    @Override
//    public void initialize() {
//        if (customer == null)
//            customer = new Customer();
//        
//        if (customer.getName() == null)
//            customer.setName("");
//        if (customer.getLastName() == null)
//            customer.setLastName("");
//        if (customer.getBirth() == null)
//            customer.setBirth(new Date());
//        updateObservers(null);
//    }
//
//    public String getName() {
//        return customer.getName();
//    }
//
//    public String getLastName() {
//        return customer.getLastName();
//    }
//
//    public Date getBirthDate() {
//        return customer.getBirth();
//    }
//
//    public void setName(String text) {
//        customer.setName(text);
//    }
//
//    public void setLastName(String text) {
//        customer.setLastName(text);
//    }
//    
//    public void setBirth(Date date){
//        customer.setBirth(date);
//    }
//
//    @Override
//    public void persist() {
//        try {
//            customerDAO.persist(customer);
//            updateObservers("Dados gravados com sucesso");
//        } catch (Exception e) {
//            updateErrorMessage("Erro ao gravar os dados no banco de dados"+e.getMessage());
//        }
//    }
//
//    public Long getId() {
//        return customer.getID();
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    @Override
//    public void setEntity(PetshopEntity entity) {
//        customer = (Customer)entity;
//    }
//
//}
//
//
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

}
