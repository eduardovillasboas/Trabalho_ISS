/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Vacina.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ricardo Andrade
 */
public class VacinaDAO extends AbstractDAO {
    
    public VacinaDAO() {
        super();
    }
    
    public void persist( Vacina v ) {
        rawPersist( v, Vacina.class );        
    }
    
    public void delete( Vacina v ) {
        rawDelete( v, Vacina.class );
    }
    
    /**
     *
     * @return
     */
    public List<Vacina> getAllVacina() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Vacina> typedQuery;
        typedQuery = em.createQuery(Vacina.FIND_ALL,Vacina.class);
        return typedQuery.getResultList();
    }

           
    
}
    

