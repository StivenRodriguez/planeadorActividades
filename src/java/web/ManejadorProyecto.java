/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Actividad;
import dto.Proyecto;
import dto.Recurso;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
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
public class ManejadorProyecto implements Serializable {

    private int Id;
    private String Nombre;
    private String Descripcion;
    private Recurso PersonaEncarda;
    private List<Actividad> Actividades;
    private List<Proyecto> lstProyectos;
    private List<Recurso> lstRecursos;
    private Date fechaInicio;
    private Date fechaFin;
    private int IdPersonaEncargada;
    private Proyecto proyecto;
    private String mensaje;
    private String mensajeInfo;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getMensajeInfo() {
        return mensajeInfo;
    }

    public void setMensajeInfo(String mensajeInfo) {
        this.mensajeInfo = mensajeInfo;
    }

    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdPersonaEncargada() {
        return IdPersonaEncargada;
    }

    public List<Recurso> getLstRecursos() {
        OperRecurso operacion = new OperRecurso();
        this.lstRecursos = new ArrayList<Recurso>();
        lstRecursos = operacion.consultar();
        if (lstRecursos == null || lstRecursos.isEmpty() || lstRecursos.size() == 0) {
            this.mensaje = " * No existen recursos, debe crearlos primero";
        } else {

            this.mensaje = "";

        }
        return lstRecursos;
    }

    public void setLstRecursos(List<Recurso> lstRecursos) {
        this.lstRecursos = lstRecursos;
    }

    public void setIdPersonaEncargada(int IdPersonaEncargada) {
        this.IdPersonaEncargada = IdPersonaEncargada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setLstProyectos(List<Proyecto> lstProyectos) {
        this.lstProyectos = lstProyectos;
    }

    public List<Proyecto> getLstProyectos() {
        return lstProyectos;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPersonaEncarda(Recurso PersonaEncarda) {
        this.PersonaEncarda = PersonaEncarda;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public Recurso getPersonaEncarda() {
        return PersonaEncarda;
    }

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorProyecto() {

    }

    public void guardarProyecto() {
        OperProyecto operacion = new OperProyecto();
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(Nombre);
        proyecto.setDescripcion(Descripcion);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        proyecto.setFechaInico(String.valueOf(formatter.format(fechaInicio)));
        proyecto.setFechaFin(String.valueOf(formatter.format(fechaFin)));
        Recurso recursoSel = new Recurso();
        recursoSel.setId(IdPersonaEncargada);
        proyecto.setPersonaEncarda(recursoSel);

        if (operacion.insertar(proyecto) > 0) {
            limpiarCampos();
            this.mensaje = "Proyecto Guardo correctamente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proyecto almacenado correctamente"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));

        }

    }

    public List<Recurso> consultarRecurso(long id) {
        OperRecurso operacion = new OperRecurso();
        lstRecursos = new ArrayList();
        return lstRecursos = operacion.consultarId(id);
    }

    public List<Actividad> consultarActividades() {
        OperActividad operacion = new OperActividad();
        Actividades = new ArrayList();
        return Actividades = operacion.consultarId(Id);
    }

    public List<Proyecto> consultarProyectos() {
        OperProyecto operacion = new OperProyecto();
        lstProyectos = new ArrayList();
        lstProyectos = operacion.consultar();
        return lstProyectos;
    }

    public String editarProyecto(Proyecto proyecto) throws ParseException {
        // edicion
        this.proyecto = proyecto;
        // Date fechaAux = new Date(); 
        this.setId(proyecto.getId());
        this.setNombre(proyecto.getNombre());
        this.setDescripcion(proyecto.getDescripcion());
        this.setIdPersonaEncargada(proyecto.getPersonaEncarda().getId());
        String fechaInicio = proyecto.getFechaInico();
        String fechaFin = proyecto.getFechaFin();
        Date fInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
        Date fFin = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);
        this.setFechaInicio(fInicio);
        this.setFechaFin(fFin);
        this.consultarActividades();
        return "/crearProyecto.xhtml?faces-redirect=true";
    }

    public void limpiarProyecto() {

    }

    public void limpiarCampos() {
        this.Nombre = null;
        this.Descripcion = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.IdPersonaEncargada = 0;

    }

    public String home() throws ParseException {
        return "/index.xhtml?faces-redirect=true";
    }

}
