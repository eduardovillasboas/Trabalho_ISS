/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Product.model;

import br.com.uem.iss.petshop.database.AbstractDAO;
import br.com.uem.iss.petshop.database.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class ProductDAO extends AbstractDAO {
    
    public ProductDAO() {
        super();
    }
    
    public void persist( Product p ) {
        rawPersist( p, Product.class );        
    }
    
    public void delete( Product p ) {
        rawDelete( p, Product.class );
    }
    
    /**
     *
     * @return
     */
    public List<Product> getAllProducts() {
        entityManagerHelper = new EntityManagerHelper();
        EntityManager em = entityManagerHelper.getEntityManager();
        TypedQuery<Product> typedQuery  = em.createQuery(Product.FIND_ALL,Product.class);
        return typedQuery.getResultList();
    }
            
    
}
