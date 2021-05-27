/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Actividad;
import dto.Proyecto;
import dto.Recurso;
import dto.Tarea;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperActividad;
import logica.OperProyecto;
import logica.OperRecurso;

@ManagedBean
@SessionScoped
public class ManejadorActividad implements Serializable {

    private int Id;
    private int IdProyecto;
    private String Nombre;
    private int Estado;
    private Recurso PersonaEncargada;
    private List<Tarea> Tareas;
    private List<Actividad> lstActividad;
    private List<Proyecto> lstProyecto;
    private List<Recurso> lstRecurso;
    private Date FechaInicio;
    private Date FechaFin;
    private int IdPersonaEncargada;
    private String mensaje;

    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int IdProyecto) {
        this.IdProyecto = IdProyecto;
    }

    public int getIdPersonaEncargada() {
        return IdPersonaEncargada;
    }

    public void setIdPersonaEncargada(int IdPersonaEncargada) {
        this.IdPersonaEncargada = IdPersonaEncargada;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public List<Recurso> getLstRecurso() {
        OperRecurso operacion = new OperRecurso();
        this.lstRecurso = new ArrayList<Recurso>();
        lstRecurso = operacion.consultar();
        return lstRecurso;
    }

    public void setLstRecurso(List<Recurso> lstRecurso) {
        this.lstRecurso = lstRecurso;
    }

    public List<Proyecto> getLstProyecto() {
        OperProyecto operacion = new OperProyecto();
        this.lstProyecto = new ArrayList<Proyecto>();
        lstProyecto = operacion.consultar();
        return lstProyecto;
    }

    public void setLstProyecto(List<Proyecto> lstProyecto) {
        this.lstProyecto = lstProyecto;
    }

    public List<Actividad> getLstActividad() {
        return lstActividad;
    }

    public void setLstActividad(List<Actividad> lstActividad) {
        this.lstActividad = lstActividad;
    }

    public void setTareas(List<Tarea> Tareas) {
        this.Tareas = Tareas;
    }

    public List<Tarea> getTareas() {
        return Tareas;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public void setPersonaEncargada(Recurso PersonaEncargada) {
        this.PersonaEncargada = PersonaEncargada;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEstado() {
        return Estado;
    }

    public Recurso getPersonaEncargada() {
        return PersonaEncargada;
    }

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorActividad() {

    }

    public void guardarActividad() {
        OperActividad operacion = new OperActividad();
        Actividad actividad = new Actividad();
        actividad.setNombre(Nombre);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        actividad.setFechaInicio(String.valueOf(formatter.format(FechaInicio)));
        actividad.setFechaFin(String.valueOf(formatter.format(FechaFin)));
        actividad.setIdProyecto(IdProyecto);
        Recurso recursoSel = new Recurso();
        recursoSel.setId(IdPersonaEncargada);
        actividad.setPersonaEncargada(recursoSel);
        int result = operacion.insertar(actividad);
        if (result > 0) {
            // inserto correctamente
            limpiarActividad();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Actividad almacenada correctamente"));

        } else {
            limpiarActividad();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }

    public List<Actividad> consultarRecurso() {
        OperActividad operacion = new OperActividad();
        lstActividad = new ArrayList();
        return lstActividad = operacion.consultar();
    }

    public void limpiarActividad() {
        this.FechaFin = null;
        this.FechaInicio = null;
        this.Id= 0;
        this.IdPersonaEncargada = 0;
        this.IdProyecto = 0;
        this.Nombre = null;       

    }
    
    public String salir() {
        return "/index.xhtml?faces-redirect=true";  
    }
}
