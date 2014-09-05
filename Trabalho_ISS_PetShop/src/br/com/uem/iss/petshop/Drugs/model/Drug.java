/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Drugs.model;

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
 * @author Rafael
 */
@Entity
@Table(name = "DRUG")
public class Drug implements PetshopEntity, Serializable {

    public static final String FIND_ALL = "SELECT s FROM Drug s";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "nome", length = 70)
    String nome;

    @Column(name = "descricao", length = 70)
    String descricao;

    @Column(name = "fornecedor", length = 70)
    String fornecedor;

    @Column(name = "quantidade", length = 70)
    String quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getQuantidade() {
        return descricao;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        Drug s;

        s = (Drug) entity;

        setNome(s.getNome());
        setDescricao(s.getDescricao());
        setFornecedor(s.getFornecedor());
        setQuantidade(s.getQuantidade());

        setID(s.getID());

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
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Drug.model.Drug[ ID=" + ID + " ]";
    }

}
