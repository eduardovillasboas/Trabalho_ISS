/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.model;

import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "MOVIMENT_STOCK")
public class MovementStock implements Serializable, PetshopEntity {

    public static final String FIND_ALL = "SELECT m FROM MOVIMENT_STOCK m";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Override
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Temporal(TemporalType.DATE)
    private Date data_execution;

    public Date getData_execution() {
        return data_execution;
    }

    public void setData_execution(Date data_execution) {
        this.data_execution = data_execution;
    }

    @Column(name = "quantidade")
    Double quantidade;

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo_movimento() {
        return tipo_movimento;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    @Column(name = "tipo_movimento", length = 10)
    String tipo_movimento;

    @Override
    public void setAtributes(PetshopEntity entity) {
        MovementStock m;
        m = (MovementStock) entity;
        setData_execution(m.getData_execution());
        setQuantidade(m.getQuantidade());
        setTipo_movimento(m.getTipo_movimento());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovementStock)) {
            return false;
        }
        MovementStock other = (MovementStock) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.MovimentStock.model.MovmentStock[ ID=" + ID + " ]";
    }

}
