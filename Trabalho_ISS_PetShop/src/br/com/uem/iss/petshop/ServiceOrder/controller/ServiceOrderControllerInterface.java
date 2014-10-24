/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;

/**
 *
 * @author EDUARDO
 */
public interface ServiceOrderControllerInterface extends ControllerInterface{
    public void selectCustomer();
    public void selectAnimal();
    public void addService();
    public void removeService(int index);
    public void calculeTotal();
    public Boolean canPrint();
    
}
