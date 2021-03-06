/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Animal.model;

import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Patology.model.Patology;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EDUARDO
 */
@Entity
public class Animal implements Serializable, PetshopEntity {
    public static final String FIND_ALL = "SELECT a FROM Animal a";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "animals")
    private List<Customer> customer;

    
    @ManyToMany()
    @JoinTable(name="ANIMAL_PATHOLOGY")
    private List<Patology> pathologys = new ArrayList<>();
    
    @Column(name = "nome")
    private String name;
    
    @Column(name = "raca")
    private String breed;
    
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date birth;
    
    @Column(name = "altura")
    private Double height;
    
    @Column(name = "peso")
    private Double weight;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uem.petshop.Animal.model.Animal[ id=" + id + " ]";
    }


    @Override
    public void setAtributes(PetshopEntity entity) {
        Animal animal = (Animal)entity;
        setName(animal.getName());
        setBirth(animal.getBirth());
        setBreed(animal.getBreed());
        setHeight(animal.getHeight());
        setWeight(animal.getWeight());
        setPathologys(animal.getPathologys());
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public Long getID() {
        return id;
    }
    
    public List<Patology> getPathologys() {
        return pathologys;
    }
            
    public void setPathologys(List<Patology> p) {
        pathologys = p;
    }

    void add(Patology patology) {
        pathologys.add(patology);
    }
    
    static public class AnimalInitializer {

        private AnimalInitializer() {
        }
    
        static public Animal initializer(Animal animal){
            //DateUtil dateUtil = new DateUtil();
            if (animal == null)
                animal = new Animal();
            if (animal.getName() == null)
                animal.setName("");
            if (animal.getBirth() == null)
                animal.setBirth(new Date(0,0,0));

            if (animal.getBreed() == null)
                animal.setBreed("");
            if (animal.getCustomer() == null)
                animal.setCustomer(new ArrayList<>());
            if (animal.getHeight() == null)
                animal.setHeight(new Double(0));
            if (animal.getWeight() == null)
                animal.setWeight(new Double(0));

            return animal;
        }
    }
    
    public static class Checker {

        public static boolean mandatoryFieldsFilled(Animal animal) {
            if (animal == null)
                return false;
            DateUtil d = new DateUtil();
            //!animal.getBirth().equals(d.toDate("")) &&
            return !animal.getName().isEmpty() && 
                    !animal.getBreed().isEmpty() &&
                    animal.getHeight() != 0 &&
                    animal.getWeight() != 0;
        }
        
    }
}
