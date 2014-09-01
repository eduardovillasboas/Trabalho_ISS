/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
public class PatologyDAO extends AbstractDAO{

    
    public PatologyDAO() {
        super();
    }
    
    public List<Patology> getAllPatologis() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Patology> typedQuery  = em.createQuery(Patology.FIND_ALL,Patology.class);
        return typedQuery.getResultList();
    }

    void persist(Patology patology) {
        rawPersist(patology, Patology.class);
    }
    
    void delete(Patology patology) {
        rawDelete(patology, Patology.class);
    }
}
