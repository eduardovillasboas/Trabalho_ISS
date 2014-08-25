/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
public class CustomerDAO {

    EntityManagerHelper entityManagerHelper;
    public CustomerDAO() {
        entityManagerHelper = new EntityManagerHelper();
    }

    List<Customer> getAllCustomers() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Customer> typedQuery  = em.createQuery("SELECT c FROM Customer c",Customer.class);
        return typedQuery.getResultList();
    }
    
    public void persist(Object o){
        entityManagerHelper.persist(o);
    }
    
    public void close(){
        entityManagerHelper.close();
    }

    void beginTransaction() {
        entityManagerHelper.getEntityManager().getTransaction().begin();
    }

    void commit() {
        entityManagerHelper.getEntityManager().getTransaction().commit();
    }
    
}
