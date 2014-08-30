/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.petshop.Animal.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
public class AnimalDAO extends AbstractDAO{

    public AnimalDAO() {
        super();
    }
    
    List<Animal> getAllCustomers() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Animal> typedQuery  = em.createQuery(Animal.FIND_ALL,Animal.class);
        return typedQuery.getResultList();
    }
    
    public void persist(Animal c){
        rawPersist(c,Animal.class);
    }

    void delete(Animal c){
        rawDelete(c,Animal.class);
    }

    
}
