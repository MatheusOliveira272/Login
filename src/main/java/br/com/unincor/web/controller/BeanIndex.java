package br.com.unincor.web.controller;

import br.com.unincor.web.model.domain.Cliente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class BeanIndex implements Serializable{
     Cliente cliente;
        
    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest)
                FacesContext.getCurrentInstance().getExternalContext().getRequest();
        cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
         
    }
}
