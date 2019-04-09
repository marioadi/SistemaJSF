package com.teste.estudomaven.controller;

import com.teste.estudomaven.dao.PessoaDAO;
import com.teste.estudomaven.exceptions.ErrorBancoDadosException;
import com.teste.estudomaven.model.Pessoa;
import com.teste.estudomaven.util_jsf.FacesUtil;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Junior Sy
 */
@Named
@ViewScoped
public class PessoaBean implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(PessoaBean.class.getName());
    
    @Inject
    private PessoaDAO pessoaDAO;
    
    private Pessoa pessoa;
  
    public PessoaBean(){
        pessoa = new Pessoa();
    }
        
    public void salvar(){
        try {
            if (pessoa != null) {
                if (pessoa.getCodigo() == 0) {
                    pessoaDAO.salvar(pessoa);
                    FacesUtil.creatMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!");
                    limpar();
                }else{
                    FacesUtil.creatMessage(FacesMessage.SEVERITY_ERROR, "Error ao salvar!");
                }
            }
        } catch (ErrorBancoDadosException e) {
            FacesUtil.creatMessage(FacesMessage.SEVERITY_ERROR, "Error no Banco!");
        }
    }
    
    public void limpar(){
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
