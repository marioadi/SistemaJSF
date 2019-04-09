package com.teste.estudomaven.dao;

import com.teste.estudomaven.model.Pessoa;
import java.io.Serializable;

/**
 *
 * @author Junior Sy
 */
public class PessoaDAO extends DAO<Pessoa> implements Serializable{
    
    public PessoaDAO() {
        super(Pessoa.class);
    }  
}
