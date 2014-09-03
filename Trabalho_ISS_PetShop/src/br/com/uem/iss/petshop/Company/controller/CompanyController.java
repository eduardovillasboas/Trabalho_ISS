/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Company.model.CompanyModel;
import br.com.uem.iss.petshop.Company.view.CompanyView;

/**
 *
 * @author Rafael
 */
public class CompanyController implements ControllerInterface {

    CompanyModel companyModel;
    CompanyView companyView;

    public CompanyController(CompanyModel m, ObserverJInternalFrame o) {
        companyModel = m;
        companyModel.initialize();
        companyView = new CompanyView(this, companyModel);
        companyView.register(o);
        o.addjDesktop(companyView);
    }

    @Override
    public void exec() {
        companyModel.initialize();
        companyView.configure();
    }

    @Override
    public Boolean persist() {
        companyView.atualizeModelFromViewValues();
        return companyModel.persist();
    }

}