/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.controller;

import br.com.uem.iss.petshop.Interfaces.ControllerInterface;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Vacina.model.VacinaModel;
import br.com.uem.iss.petshop.Vacina.view.VacinaView;

/**
 *
 * @author Ricardo Andrade
 */
public class VacinaController implements ControllerInterface {

    VacinaModel vacinaModel;
    VacinaView vacinaView;

    public VacinaController(VacinaModel m, 
                            ObserverJInternalFrame o,
                            ObserverJInternalFrame o2) {
        vacinaModel = m;
        vacinaModel.initialize();
        vacinaView = new VacinaView(this, vacinaModel);
        vacinaView.register(o);
        vacinaView.register(o2);
        o.addjDesktop(vacinaView);
    }

    @Override
    public void exec() {
        vacinaModel.initialize();
        vacinaView.configure();
    }

    @Override
    public Boolean persist() {
        vacinaView.atualizeModelFromViewValues();
        return vacinaModel.persist();
    }
    
}
