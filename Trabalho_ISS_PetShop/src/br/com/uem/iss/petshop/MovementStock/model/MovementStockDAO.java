/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uem.iss.petshop.MovementStock.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class MovementStockDAO extends AbstractDAO {

    public MovementStockDAO() {
        super();
    }

    public void persist(MovementStock m) {
        rawPersist(m, MovementStock.class);
    }

    public void delete(MovementStock m) {
        rawDelete(m, MovementStock.class);
    }
    
    public List<MovementStock> getAllMoviments() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<MovementStock> typedQuery;
        typedQuery = em.createQuery(MovementStock.FIND_ALL, MovementStock.class);
        return typedQuery.getResultList();
    }

}