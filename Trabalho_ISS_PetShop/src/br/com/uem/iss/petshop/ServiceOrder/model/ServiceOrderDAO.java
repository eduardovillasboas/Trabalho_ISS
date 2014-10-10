/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderDAO extends AbstractDAO {
    
    public ServiceOrderDAO(){
        super();
    }
    
    List<ServiceOrder> getAllServiceOrders() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<ServiceOrder> typedQuery  = em.createQuery(ServiceOrder.FIND_ALL,ServiceOrder.class);
        return typedQuery.getResultList();
    }
    
    public void persist(ServiceOrder c){
        rawPersist(c,ServiceOrder.class);
    }

    void delete(ServiceOrder c){
        rawDelete(c,ServiceOrder.class);
    }

}
