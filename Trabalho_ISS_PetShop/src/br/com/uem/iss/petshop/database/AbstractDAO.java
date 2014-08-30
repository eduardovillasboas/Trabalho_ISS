/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.database;

import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author EDUARDO
 */
public class AbstractDAO {

    protected EntityManagerHelper entityManagerHelper;
    public AbstractDAO() {
        entityManagerHelper = new EntityManagerHelper();
    }

    public void update(PetshopEntity e, Class<PetshopEntity> classEntiy) {
        EntityManager em = entityManagerHelper.getEntityManager();
        PetshopEntity entity =(PetshopEntity)em.find(classEntiy, e.getID());
        em.getTransaction().begin();
        entity.setAtributes(e);
        em.getTransaction().commit();
    }
    
    public Class<PetshopEntity> convertClassType(Object cClass) {
        return (Class<PetshopEntity>)cClass;
    }

    private void rawPersistDAO(PetshopEntity c) {
        entityManagerHelper.persist(c);
    }

    protected void rawPersist(PetshopEntity c, Object typeClass){
        if (c.getID() != null){
            Class<PetshopEntity> pClass;
            pClass = convertClassType(typeClass);
            update(c,pClass);
        }
        else{
            rawPersistDAO(c);
        }
    }

    public EntityTransaction getTransaction(){
        return entityManagerHelper.getTransaction();
    }

    public void close(){
        entityManagerHelper.close();
    }

    protected void rawDelete(PetshopEntity c, Object typObject) {
        EntityManager em = entityManagerHelper.getEntityManager();
        Class<PetshopEntity> typeEntity = convertClassType(typObject);
        PetshopEntity customer = em.find(typeEntity, c.getID());
        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();
    }

}