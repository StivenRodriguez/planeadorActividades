/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.text.ParseException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ascar
 */
@ManagedBean
@SessionScoped
public class ManejadorLinks implements Serializable {

    public String crearProyecto() throws ParseException {
        return "/crearProyecto.xhtml?faces-redirect=true";
    }

    public String listarProyecto() throws ParseException {
        return "/proyectosExistentes.xhtml?faces-redirect=true";
    }

    public String crearActividad() throws ParseException {
        return "/crearActividad.xhtml?faces-redirect=true";
    }

    public String crearRecursos() throws ParseException {
        return "/crearRecursos.xhtml?faces-redirect=true";
    }

    public String home() throws ParseException {
        return "/index.xhtml?faces-redirect=true";
    }

}
