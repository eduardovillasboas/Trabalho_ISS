/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.Service.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class ServiceDAO extends AbstractDAO {

    public ServiceDAO() {
        super();
    }

    public void persist(Service s) {
        rawPersist(s, Service.class);
    }

    public void delete(Service s) {
        rawDelete(s, Service.class);
    }

    /**
     *
     * @return
     */
    public List<Service> getAllProducts() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Service> typedQuery;
        typedQuery = em.createQuery(Service.FIND_ALL, Service.class);
        return typedQuery.getResultList();
    }

}
