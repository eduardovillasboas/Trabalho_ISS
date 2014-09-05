/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.model ;

import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Andrade
 */
@Entity
@Table(name = "VACINA")
public class Vacina implements Serializable,PetshopEntity {    
    public static final String FIND_ALL = "SELECT v FROM Vacina v";
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
    
    @Column(name = "descricao", length = 70 )
    String descricao;
    
    @Column(name = "marca", length = 20 )
    String marca;
    
    @Column(name = "estoque" )
    Double estoque;
    
    @Column(name = "preco")
    Float preco;
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        Vacina v;
        v = (Vacina)entity;
        setDescricao(v.getDescricao());
        setPreco(v.getPreco());
        setMarca(v.getMarca());
        setEstoque(v.getEstoque());
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
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Vacina.model.Vacina[ ID=" + ID + " ]";
    }
    
}