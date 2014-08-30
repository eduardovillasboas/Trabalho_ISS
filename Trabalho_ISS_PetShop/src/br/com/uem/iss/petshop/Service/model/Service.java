/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Service.model;

import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "SERVICE")
public class Service implements PetshopEntity,Serializable {

    @Id
    private Long ID;

    @Override
    public Long getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
