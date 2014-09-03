/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rafael
 */
public class CompanyDAO extends AbstractDAO {

    public CompanyDAO() {
        super();
    }

    public void persist(Company s) {
        rawPersist(s, Company.class);
    }

    public void delete(Company s) {
        rawDelete(s, Company.class);
    }

    /**
     *
     * @return
     */
    public List<Company> getAllCompanies() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Company> typedQuery;
        typedQuery = em.createQuery(Company.FIND_ALL, Company.class);
        return typedQuery.getResultList();
    }

}
