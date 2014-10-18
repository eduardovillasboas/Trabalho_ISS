/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Sales.model;

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
@Table(name = "ITEM_SALE")
public class ItemSale implements Serializable, PetshopEntity {

    public static final String FIND_ALL = "SELECT i FROM Item_Sale i";
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

    @Column(name = "codigo_item")
    Long codigo_item;

    @Column(name = "quantidade_vendida")
    Double quantidade_vendida;

    @Column(name = "valor")
    Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(Long codigo_item) {
        this.codigo_item = codigo_item;
    }

    public Double getQuantidade_vendida() {
        return quantidade_vendida;
    }

    public void setQuantidade_vendida(Double quantidade_vendida) {
        this.quantidade_vendida = quantidade_vendida;
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        ItemSale i;
        i = (ItemSale) entity;
        setQuantidade_vendida(i.getQuantidade_vendida());
        setCodigo_item(i.getCodigo_item());
        setValor(i.getValor());        
    }

}
