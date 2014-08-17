package br.com.uem.iss.petshop.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDUARDO
 */
public class EntityManagerHelper {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    
    public EntityManagerHelper() {
    }
       
    public void createEntityManager(){
        /*
        * TODO: testar se da erro
        * criar mais de uma conexão
        * fechar e tentar utilizar denovo,ou seja,
        * entitiManagerFactory é compartilhada internamente?
        */
        entityManagerFactory = Persistence.createEntityManagerFactory("Trabalho_ISS_PetShopPU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public void persist(Object o){
        entityManager.persist(o);
    }
    
    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
