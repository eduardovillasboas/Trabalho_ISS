/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Interfaces;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public interface PetshopListControllerInterface {

    public Object execControllerInterface(AbstractTableModel tableModel, JTable jTableCustomerTable);
    public void delete(int selectedRow);
    
}
