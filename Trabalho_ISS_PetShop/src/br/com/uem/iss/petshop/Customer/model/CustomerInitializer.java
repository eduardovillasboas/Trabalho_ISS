/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EDUARDO
 */
public class CustomerInitializer {

    public CustomerInitializer() {
    }
    
    public Customer initilizer(Customer customer){
        if (customer == null)
            customer = new Customer();
        
        if (customer.getName() == null)
            customer.setName("");
        if (customer.getLastName() == null)
            customer.setLastName("");
        if (customer.getBirth() == null){
            customer.setBirth(new Date(0,0,0));
        }
        if (customer.getAddress() == null)
            customer.setAddress("");
        if (customer.getAnimals() == null)
            customer.setAnimals(new ArrayList<>());
        if (customer.getCpf() == null)
            customer.setCpf("");
        if (customer.getRg() == null)
            customer.setRg("");
        if (customer.getNumber() == null)
            customer.setNumber(new Long(0));
        if (customer.getPhone() == null)
            customer.setPhone("");
        
        return customer;
    }
}
