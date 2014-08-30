/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Product.model;

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
 * @author Lucas
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable,PetshopEntity {    
    public static final String FIND_ALL = "SELECT p FROM PRODUCT p";
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
    
    @Column(name = "unidade", length = 3 )
    String undade;

    @Column(name = "marca", length = 20 )
    String marca;
    
    @Column(name = "estoque" )
    Double estoque;
    
    @Column(name = "peso_bruto")
    float pesoBruto;
    
    @Column(name = "preco")
    float preco;
    
    @Column(name = "peso_liquido")
    float pesoLiquido;
    
    public String getUndade() {
        return undade;
    }

    public void setUndade(String undade) {
        this.undade = undade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   

    public float getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(float pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }
     
    @Override
    public void setAtributes(PetshopEntity entity) {
        Product p;
        p = (Product)entity;
        setDescricao(p.getDescricao());
        setPesoBruto(p.getPesoBruto());
        setPesoLiquido(p.getPesoLiquido());
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Customer.model.Customer[ ID=" + ID + " ]";
    }
    
}
