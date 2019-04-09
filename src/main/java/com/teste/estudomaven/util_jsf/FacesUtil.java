/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.estudomaven.util_jsf;


import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Junior Sy
 */
public class FacesUtil {

    public static void creatMessage(Severity s, String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s, msg, msg));
    }
    
    public static void Message(String txt, int codigo){
        
        switch(codigo){
            case 1: getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, txt, "Erro")); break;
            case 2: getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, txt, "Info")); break;
            default: break;
        }
    }
    
    private static FacesContext getContext(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        external.getFlash().setKeepMessages(true);
        return context;
    }
    
}
