///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.com.uem.iss.petshop.Customer.controller;
//
//import br.com.uem.iss.petshop.Customer.model.CustomerModel;
//import br.com.uem.iss.petshop.Customer.view.CustomerView;
//import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
//import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
//
///**
// *
// * @author EDUARDO
// */
//public class CustomerController implements ControllerInterface{
//
//    CustomerModel customerModel;
//    CustomerView customerView;
//    public CustomerController(CustomerModel m,ObserverJInternalFrame o) {
//        customerModel = m;
//        customerModel.initialize();
//        customerView = new CustomerView(this,customerModel);
//        customerView.register(o);
//        o.addjDesktop(customerView);
//    }
//
//    @Override
//    public void exec() {
//        customerModel.initialize();
//        customerView.configure();
//    }
//
//    @Override
//    public void persist() {
//        customerView.atualizeModelFromViewValues();
//        customerModel.persist();
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Product.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Product.model.ProductModel;
import br.com.uem.iss.petshop.Product.view.ProductView;

/**
 *
 * @author Lucas
 */
public class ProductController implements ControllerInterface {

    ProductModel productModel;
    ProductView productView;

    public ProductController(ProductModel m, ObserverJInternalFrame o) {
        productModel = m;
        productModel.initialize();
        productView = new ProductView(this, productModel);
        productView.register(o);
        o.addjDesktop(productView);
    }

    @Override
    public void exec() {
        productModel.initialize();
        productView.configure();
    }

    @Override
    public void persist() {
        productView.atualizeModelFromViewValues();
        productModel.persist();
    }

}
