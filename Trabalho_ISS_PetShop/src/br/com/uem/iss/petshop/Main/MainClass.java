/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Main;

import br.com.uem.iss.petshop.Main.controller.MainController;

/**
 *
 * @author EDUARDO
 * classe principal do projeto a partir dessa classe a aplicacação é
 * iniciada
 */
public class MainClass {
    
    public static void main(String args[]) {
       
        MainController mainController = new MainController();
        if (!mainController.login())
            return;
        
        mainController.exec();
    }
}
