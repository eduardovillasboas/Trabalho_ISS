/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    
    public void persist(Customer c){
        if (c.getId() != null){
            update(c);
        }
        else{
            rawPersist(c);
        }
            
    }
    
    public void close(){
        entityManagerHelper.close();
    }
    
    public EntityTransaction getTransaction(){
        return entityManagerHelper.getTransaction();
    }

    private void rawPersist(Customer c) {
        entityManagerHelper.persist(c);
    }

    private void update(Customer c) {
        EntityManager em = entityManagerHelper.getEntityManager();
        Customer customer = em.find(Customer.class, c.getId());
        em.getTransaction().begin();
        customer.setName(c.getName());
        customer.setLastName(c.getLastName());
        customer.setBirth(c.getBirth());
        em.getTransaction().commit();
    }

    void delete(Customer c) {
        EntityManager em = entityManagerHelper.getEntityManager();
        Customer customer = em.find(Customer.class, c.getId());
        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();
    }
    
   
}
