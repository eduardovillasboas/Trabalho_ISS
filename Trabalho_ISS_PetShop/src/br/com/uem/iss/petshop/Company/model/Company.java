/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.model;

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
@Table(name = "COMPANY")
public class Company implements PetshopEntity,Serializable {
    public static final String FIND_ALL = "SELECT s FROM Company s";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    
    @Column(name = "nome", length = 70 )
    String nome;
    
    @Column(name = "telefone", length =  10 )
    String telefone;
    
    @Column(name = "email", length =  30 )
    String email;
    
    @Column(name = "endereco", length =  90 )
    String endereco;
    
    @Column(name = "cidade", length =  50 )
    String cidade;
    
    @Column(name = "estado", length =  50 )
    String estado;
    
    @Column(name = "cep", length =  20 )
    String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public Long getID() {
        return ID;
    }
    
    public void setID( Long ID ){
        this.ID = ID;
    }
            
    @Override
    public void setAtributes(PetshopEntity entity) {
        Company s;
        
        s = (Company)entity;
        
        setNome(s.getNome());
        setTelefone(s.getTelefone());
        setEmail(s.getEmail());
        setEndereco(s.getEndereco());
        setCidade(s.getCidade());
        setEstado(s.getEstado());
        setCep(s.getCep());
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        return (this.ID != null || other.ID == null) && (this.ID == null || this.ID.equals(other.ID));
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Company.model.Company[ ID=" + ID + " ]";
    }
    
}
