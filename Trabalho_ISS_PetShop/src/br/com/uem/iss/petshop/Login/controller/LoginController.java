/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Login.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Login.model.LoginModel;
import br.com.uem.iss.petshop.Login.view.LoginView;

/**
 *
 * @author Ricardo Andrade
 */
public class LoginController implements ControllerInterface{

    LoginModel loginModel;
    LoginView loginView;
    public LoginController(LoginModel m,
                           ObserverJInternalFrame o,
                           ObserverJInternalFrame o2) {
        loginModel = m;
        m.initialize();
        loginView = new LoginView(this, m);
        loginView.register(o);
        loginView.register(o2);
        o.addjDesktop(loginView);
    }

    @Override
    public void exec() {
        loginModel.initialize();
        loginView.configure();
    }

    @Override
    public Boolean persist() {
        loginView.updateModelFromViewValues();
        return loginModel.persist();
    }
    
}
