/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Interfaces;

import br.com.uem.iss.petshop.Login.view.LoginView;
import javax.swing.JInternalFrame;

/**
 *
 * @author EDUARDO
 */
public interface ObserverJInternalFrame {
    public void wasFinalized(JInternalFrame view);
    public void addjDesktop(JInternalFrame customerView);

    
}
