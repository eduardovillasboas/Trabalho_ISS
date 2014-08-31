/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EDUARDO
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable,PetshopEntity {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "SELECT c FROM Customer c";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getID() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "sobrenome")
    private String lastName;
    
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)        
    private Date birth;
   
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "endereco")
    private String address;
    
    @Column(name = "numero")
    private Long number;
    
    @ManyToMany()
    @JoinTable(name="ANIMAL_CLIENT")
    private List<Animal> animals;
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Customer.model.Customer[ id=" + id + " ]";
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        Customer e = (Customer)entity;
        setName(e.getName());
        setLastName(e.getLastName());
        setBirth(e.getBirth());
        setAddress(e.getAddress());
        setAnimals(e.getAnimals());
        setCpf(e.getCpf());
        setRg(e.getRg());
        setNumber(e.getNumber());
    }


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public boolean add(Animal e) {
        return animals.add(e);
    }

    public boolean remove(Animal a) {
        return animals.remove(a);
    }
 
    
}
