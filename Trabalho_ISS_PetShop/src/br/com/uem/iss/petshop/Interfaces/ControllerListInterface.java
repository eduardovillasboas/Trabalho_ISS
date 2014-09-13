/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Interfaces;

import br.com.uem.iss.petshop.Utils.State;

/**
 *
 * @author EDUARDO
 */
public interface ControllerListInterface {
    
    public void delete(int selectedRow);
    public State getState();
    public void exec();
    public void newAction();
    public void editAction(PetshopEntity petshopEntity);

    
}
