/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Main.controller;

import br.com.uem.iss.petshop.Main.view.MainView;

/**
 *
 * @author EDUARDO
 */
public class MainController {

    MainView mainView;
    public MainController() {
        mainView = new MainView(this);
    }

    public boolean login() {
        return true;
    }

    public void exec() {
        mainView.createControls();
    }
    
}
