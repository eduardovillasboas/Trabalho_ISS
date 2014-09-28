/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Customer.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
public class CustomerDAO extends AbstractDAO{

    
    public CustomerDAO() {
        super();
    }

    List<Customer> getAllCustomers() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Customer> typedQuery  = em.createQuery(Customer.FIND_ALL,Customer.class);
        return typedQuery.getResultList();
    }
    
    public void persist(Customer c){
        rawPersist(c,Customer.class);
    }

    void delete(Customer c){
        rawDelete(c,Customer.class);
    }
  
}
