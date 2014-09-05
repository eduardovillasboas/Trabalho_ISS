/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Login.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ricardo Andrade
 */
public class LoginDAO extends AbstractDAO{
    public LoginDAO() {
        super();
    }
    
    public void persist( Login l ) {
        rawPersist( l, Login.class );        
    }
    
    public void delete( Login l ) {
        rawDelete( l, Login.class );
    }
    
    public List<Login> getAllLogin() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Login> typedQuery;
        typedQuery = em.createQuery(Login.FIND_ALL,Login.class);
        return typedQuery.getResultList();
    }
}
