/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.estudomaven.model;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Junior Sy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EstudoMavenPU");
        EntityManager manager = getEntityManager(factory);
        EntityTransaction trx = manager.getTransaction();
        trx.begin();
        
        //TESTE AQUI
        cadastarPesssoa(manager);
    
        trx.commit();
        manager.close();
        close(factory);

    }
    
    public static void cadastarPesssoa(EntityManager manager){
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Larissa");
            pessoa.setIdade(21);
            manager.persist(pessoa);
            System.out.println("------------OK------------");
        } catch (PersistenceException e) {
            System.out.println("----------ERROR-----------");
        }
    }
    
    public static EntityManager getEntityManager(EntityManagerFactory factory){
        return factory.createEntityManager();
    }
    
    public static void close(EntityManagerFactory factory){
        factory.close();
    }
    
}
