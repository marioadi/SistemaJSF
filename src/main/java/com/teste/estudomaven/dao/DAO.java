package com.teste.estudomaven.dao;

import com.teste.estudomaven.exceptions.ErrorBancoDadosException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Junior Sy
 * 
 */
public abstract class DAO<T> implements Serializable {
    
    @Inject
    protected EntityManager manager;
    
    private final Class<T> classe;
    protected EntityTransaction trx;
    
    public DAO(Class<T> classe){
        this.classe = classe;
    }
    
    public void salvar(T t) throws ErrorBancoDadosException{
        try {
            trx = manager.getTransaction();
            trx.begin();
            
            manager.persist(t);
            
            trx.commit();
            
        } catch (Exception ex) {
            throw new ErrorBancoDadosException(ex.getMessage());
        }
    }
}
