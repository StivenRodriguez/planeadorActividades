/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Tarea;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperTarea;

@ManagedBean
@SessionScoped
public class ManejadorTarea implements Serializable {
     private int Id;
    private int IdActividad;
    private String Descripcion;
    private String FechaInicio;
    private String FechaFin;
    private int Estado;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getId() {
        return Id;
    }

    public int getIdActividad() {
        return IdActividad;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public int getEstado() {
        return Estado;
    }

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorTarea() {

    }
    
    public void guardarTarea() {
        OperTarea operacion = new OperTarea();
        Tarea tarea = new Tarea();
        tarea.setDescripcion(Descripcion);
        tarea.setFechaInicio(FechaInicio);
        tarea.setFechaFin(FechaFin);
        tarea.setIdActividad(IdActividad);
        tarea.setEstado(Estado);
        
        if (operacion.insertar(tarea) > 1) {
            // inserto correctamente
            limpiarTarea();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tarea almacenada correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
            
        }
    }
    
    public void limpiarTarea() {
        this.Descripcion = null;
        this.Estado = 0;
        this.FechaFin = null;
        this.FechaInicio = null;
        this.Id = 0;
        this.IdActividad = 0;      
        
    }
}


