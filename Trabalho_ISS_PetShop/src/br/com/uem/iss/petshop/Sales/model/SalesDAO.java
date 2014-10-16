/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Sales.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class SalesDAO extends AbstractDAO {

    public SalesDAO() {
        super();
    }
    
    List<Sale> getAllServiceOrders() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Sale> typedQuery = em.createQuery(Sale.FIND_ALL, Sale.class);
        return typedQuery.getResultList();
    }
    
    public void persist(Sale c) {
        rawPersist(c, Sale.class);
    }

    void delete(Sale c) {
        rawDelete(c, Sale.class);
    }

}