/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author EDUARDO
 */
@Entity
@Table(name = "PATOLOGY")
public class Patology implements Serializable, PetshopEntity {
    
    public static String FIND_ALL = "SELECT c FROM Patology c"; 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patology)) {
            return false;
        }
        Patology other = (Patology) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uem.iss.petshop.Patology.model.Patology[ id=" + id + " ]";
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public void setAtributes(PetshopEntity entity) {
        Patology patology = (Patology)entity;
        setName(patology.getName());
        setDescription(patology.getDescription());
    }

    @Column(name = "nome")
    private String name;
    
    @Column(name = "descricao")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy="pathologys")
    private List<Animal> animal;
//    
    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
    
    
}
