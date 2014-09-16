/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Abstract.model;

import br.com.uem.iss.petshop.Interfaces.ModelListInterface;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public abstract class AbstractModelList extends AbstractObservableModel implements ModelListInterface{

    public AbstractModelList() {
        super();
    }

    public abstract AbstractTableModel createModel();
    public abstract void delele(int selectedRow);
    public abstract String getTitle();
     
    
}
