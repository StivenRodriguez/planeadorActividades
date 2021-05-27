/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Recurso;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperRecurso;

@ManagedBean
@SessionScoped
public class ManejadorRecurso implements Serializable {

    public List<Recurso> getLstRecursos() {
        OperRecurso operacion = new OperRecurso();
        this.lstRecursos = new ArrayList<Recurso>();
        lstRecursos = operacion.consultar();
        return lstRecursos;
    }

    public void setLstRecursos(List<Recurso> lstRecursos) {
        this.lstRecursos = lstRecursos;
    }

    private int Id;
    private String Nombres;
    private String Apellidos;
    private String Cargo;
    private String Email;
    private List<Recurso> lstRecursos;
    private Recurso recurso;

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getEmail() {
        return Email;
    }

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorRecurso() {

    }

    public String guardarRecurso() {
        OperRecurso operacion = new OperRecurso();
        Recurso recurso = new Recurso();
        recurso.setNombres(Nombres);
        recurso.setApellidos(Apellidos);
        recurso.setCargo(Cargo);
        recurso.setEmail(Email);
        int result = operacion.insertar(recurso);
        
        if (result > 0) {
            // guardado correctamente
            
            limpiarRecurso();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Actividad almacenada correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
        
        return "/crearRecursos.xhtml?faces-redirect=true";  
    }

    public List<Recurso> consultarRecurso() {
        OperRecurso operacion = new OperRecurso();
        lstRecursos = new ArrayList();
        return lstRecursos = operacion.consultar();
    }

    public void limpiarRecurso() {
        this.Apellidos = null;
        this.Cargo = null;
        this.Email = null;
        this.Id = 0;
        this.Nombres = null;

    }
}
