/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Drugs.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author Rafael
 */
public class DrugDAO extends AbstractDAO {

    public DrugDAO() {
        super();
    }

    public void persist(Drug s) {
        rawPersist(s, Drug.class);
    }

    public void delete(Drug s) {
        rawDelete(s, Drug.class);
    }

    /**
     *
     * @return
     */
    public List<Drug> getDrugs() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Drug> typedQuery;
        typedQuery = em.createQuery(Drug.FIND_ALL, Drug.class);
        return typedQuery.getResultList();
    }

    List<Drug> getAllDrugs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
