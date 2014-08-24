/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Util;

/**
 *
 * @author EDUARDO
 */
public interface ObservableModel {
    public  void updateErrorMessage(String msg);
    public void updateObservers(String msg);
    public void registerUpdate(ObserverModel o);
    public void registerErrorObserver(ObserverModel o);

}
