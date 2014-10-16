/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Sales.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "SALES")
public class Sale implements Serializable, PetshopEntity {

    public static final String FIND_ALL = "SELECT s FROM Sales s";
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
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")        
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
//    @Column(name = "codigo_item")
//    int codigo_item;
//
//    @Column(name = "quantidade_vendida")
//    Double quantidade_vendida;
//
    @Column(name = "valor")
    Float valor;

    @Column(name = "forma_pagamento", length = 15)
    String forma_pagamento;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

//    public int getCodigo_item() {
//        return codigo_item;
//    }
//
//    public void setCodigo_item(int codigo_item) {
//        this.codigo_item = codigo_item;
//    }
//
//    public Double getQuantidade_vendida() {
//        return quantidade_vendida;
//    }
//
//    public void setQuantidade_vendida(Double quantidade_vendida) {
//        this.quantidade_vendida = quantidade_vendida;
//    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }
    
    @Override
    public void setAtributes(PetshopEntity entity) {
        Sale s;
        s = (Sale)entity;
        setAnimal(s.getAnimal());
//        setCodigo_item(s.getCodigo_item());
        setForma_pagamento(s.getForma_pagamento());
//        setQuantidade_vendida(s.getQuantidade_vendida());
        setValor(s.getValor());
        
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
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Sale.model.Sale [ ID=" + ID + " ]";
    }

}
