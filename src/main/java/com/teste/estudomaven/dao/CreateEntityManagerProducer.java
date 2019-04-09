package com.teste.estudomaven.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Junior Sy
 */
@ApplicationScoped
public class CreateEntityManagerProducer {
    
    EntityManagerFactory factory;

    public CreateEntityManagerProducer(){
        factory = Persistence.createEntityManagerFactory("EstudoMavenPU");
    }
    
    @Produces
    @RequestScoped
    public EntityManager createEntityManager(){
        return this.factory.createEntityManager();
    }
    
    public void closeEntityManager(EntityManager manager){
        manager.close();
    }
}
