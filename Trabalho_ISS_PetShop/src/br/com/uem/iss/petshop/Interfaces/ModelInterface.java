/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Interfaces;

/**
 *
 * @author EDUARDO
 */
public interface ModelInterface extends ObservableModel{
    public void setCustomer(PetshopEntity p);
    public void initialize();
    public void persist();
}
